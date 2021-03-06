package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Venue Hire System for COMP2511.
 *
 * A basic prototype to serve as the "back-end" of a venue hire system. Input
 * and output is in JSON format.
 *
 * @author Robert Clifton-Everest
 *
 */
public class VenueHireSystem {

	private ArrayList<Venue> venues;

	/**
	 * Constructs a venue hire system. Initially, the system contains no venues,
	 * rooms, or bookings.
	 */
	public VenueHireSystem() {
		this.venues = new ArrayList<Venue>();
	}

	private void processCommand(JSONObject json) {
		switch (json.getString("command")) {

		case "room":
			String room_venue = json.getString("venue");
			String room_room = json.getString("room");
			String room_sizeString = json.getString("size");

			Size room_size = null;
			switch (room_sizeString) {
			case "small":
				room_size = Size.SMALL;
				break;
			case "medium":
				room_size = Size.MEDIUM;
				break;
			case "large":
				room_size = Size.LARGE;
				break;
			default:
				// Input will always be trusted, so we don't need to worry about this.
			}

			addRoom(room_venue, room_room, room_size);
			break;

		case "request":
			String request_id = json.getString("id");

			LocalDate request_start = LocalDate.parse(json.getString("start"));
			LocalDate request_end = LocalDate.parse(json.getString("end"));

			int request_small = json.getInt("small");
			int request_medium = json.getInt("medium");
			int request_large = json.getInt("large");

			JSONObject request_result = request(request_id, request_start, request_end, request_small, request_medium,
					request_large);

			System.out.println(request_result.toString(2));
			break;

		case "change":
			String change_id = json.getString("id");

			LocalDate change_start = LocalDate.parse(json.getString("start"));
			LocalDate change_end = LocalDate.parse(json.getString("end"));

			int change_small = json.getInt("small");
			int change_medium = json.getInt("medium");
			int change_large = json.getInt("large");

			JSONObject change_result = change(change_id, change_start, change_end, change_small, change_medium,
					change_large);

			System.out.println(change_result.toString(2));

			break;
		case "list":
			String list_venue = json.getString("venue");

			JSONArray list_result = list(list_venue);
			System.out.println(list_result.toString(2));
			break;

		case "cancel":
			String cancel_id = json.getString("id");

			cancel(cancel_id);
			break;
		}
	}

	private void addRoom(String venue, String room, Size size) {
		Venue venueObj = Venue.getVenueByName(this.venues, venue);

		// Add Venue if it does not exist
		if (venueObj == null) {
			venueObj = new Venue(venue);
			this.venues.add(venueObj);
		}

		// Assume room has not already been added
		venueObj.addRoom(room, size);
	}

	private void cancel(String id) {
		for (Venue venue : this.venues) {
			// Assume `id` is valid
			Booking booking = Booking.getBookingById(venue.getBookings(), id);
			if (booking == null)
				continue;

			venue.removeBooking(booking);
			return;
		}
	}

	/**
	 * Perform a booking request
	 * 
	 * @param id
	 * @param start
	 * @param end
	 * @param small
	 * @param medium
	 * @param large
	 * @return JSONObject
	 */
	private JSONObject request(String id, LocalDate start, LocalDate end, int small, int medium, int large) {

		/*
		 * Ignored considerations (safe system)
		 * 
		 * 
		 * 1) startDate is after endDate
		 * 
		 * 2) duplicate id
		 */

		LocalDateRange dateRange = new LocalDateRange(start, end);

		for (Venue venue : this.venues) {

			if (venue.canBook(dateRange, small, medium, large)) {
				Booking booking = venue.addBooking(id, dateRange, small, medium, large);
				return generateSuccess(booking);
			}
		}

		return generateReject();
	}

	/**
	 * Perform a change request
	 * 
	 * @param id
	 * @param start
	 * @param end
	 * @param small
	 * @param medium
	 * @param large
	 * @return JSONObject
	 */
	private JSONObject change(String id, LocalDate start, LocalDate end, int small, int medium, int large) {

		LocalDateRange dateRange = new LocalDateRange(start, end);

		for (Venue venue : this.venues) {

			Booking booking = Booking.getBookingById(venue.getBookings(), id);

			if (booking == null)
				continue;

			// Try to request a change
			boolean status = booking.requestChange(dateRange, small, medium, large);

			// If change success, then produce
			if (status) {
				return generateSuccess(booking);
			} else {
				// Change failed - not enough rooms to accommodate new rooms

				/*
				 * To remove any ambiguity, all reservation requests and changes are fulfilled
				 * as follows: each venue is checked (in order of definition in the input) to
				 * determine whether it can satisfy all requested rooms, and if so, the first
				 * available rooms (again in order of definition in the input) are assigned to
				 * the reservation.
				 * 
				 * This is the procedure you must follow for assigning rooms for both requests
				 * and changes. There are no requirements that the venue must remain the same.
				 * -- Rob Everest (https://piazza.com/class/k083hgcwt215x8?cid=91)
				 */
				for (Venue newVenue : this.venues) {
					if (venue == newVenue)
						continue;

					if (newVenue.canBook(dateRange, small, medium, large)) {
						venue.removeBooking(booking);
						booking = newVenue.addBooking(id, dateRange, small, medium, large);
						return generateSuccess(booking);
					}

				}

				return generateReject();
			}

		}

		return generateReject();
	}

	/**
	 * List the rooms and their bookings for a specified venue
	 * 
	 * @param venue
	 * @return JSONArray
	 */
	private JSONArray list(String venue) {
		JSONArray result = new JSONArray();

		// Assume `venue` is valid
		Venue venueObj = Venue.getVenueByName(this.venues, venue);

		for (Room room : venueObj.getRooms()) {

			JSONObject roomJSON = new JSONObject();

			// Add the room name
			roomJSON.put("room", room.getName());

			// Add instances of the room's bookings into an array
			JSONArray reservationsJSON = new JSONArray();
			for (Booking booking : venueObj.getBookingsByRoom(room)) {
				JSONObject reservationJSON = new JSONObject();
				reservationJSON.put("id", booking.getId());
				reservationJSON.put("start", booking.getStartDate().toString());
				reservationJSON.put("end", booking.getEndDate().toString());

				reservationsJSON.put(reservationJSON);
			}
			roomJSON.put("reservations", reservationsJSON);

			// Attach room to result
			result.put(roomJSON);
		}

		return result;
	}

	/**
	 * Create a JSON success object for a booking
	 * 
	 * @param booking
	 * @return JSONObject
	 */
	private JSONObject generateSuccess(Booking booking) {
		JSONObject result = new JSONObject();

		result.put("venue", booking.getVenue().getName());

		JSONArray rooms = new JSONArray();
		for (Room room : booking.getRooms()) {
			rooms.put(room.getName());
		}
		result.put("rooms", rooms);

		result.put("status", "success");

		return result;
	}

	/**
	 * Create a JSON reject object
	 * 
	 * @return JSONObject
	 */
	private JSONObject generateReject() {
		JSONObject result = new JSONObject();
		result.put("status", "rejected");
		return result;
	}

	public static void main(String[] args) {
		VenueHireSystem system = new VenueHireSystem();

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String line = sc.nextLine().trim();
			if (!line.equals("")) {
				if (line.startsWith("#"))
					continue;
				JSONObject command = new JSONObject(line);
				system.processCommand(command);
			}
		}
		sc.close();
	}

}
