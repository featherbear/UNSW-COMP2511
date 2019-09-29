/**
 *
 */
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
		if (venueObj == null) {
			venueObj = new Venue(venue);
			this.venues.add(venueObj);
		}

		// Assume room has not already been added
		venueObj.addRoom(room, size);
	}

	public void cancel(String id) {
		for (Venue venue : this.venues) {
			// Assume `id` is valid
			Booking booking = Booking.getBookingById(venue.getBookings(), id);
			if (booking != null) {
				venue.removeBooking(booking);
				return;
			}
		}
	}

	public JSONObject request(String id, LocalDate start, LocalDate end, int small, int medium, int large) {
		JSONObject result = new JSONObject();

		/*
		 * Ignored considerations (safe system) - startDate is after endDate - duplicate
		 * id
		 */

		LocalDateRange dateRange = new LocalDateRange(start, end);

		for (Venue venue : this.venues) {

			if (venue.canBook(dateRange, small, medium, large)) {

				Booking booking = venue.addBooking(id, dateRange, small, medium, large);

				result.put("venue", venue.getName());

				JSONArray rooms = new JSONArray();
				for (Room room : booking.getRooms()) {
					room.getName();
				}
				result.put("rooms", rooms);

				result.put("status", "success");

				return result;

			}
		}

		result.put("status", "rejected");
		return result;
	}

	public JSONObject change(String id, LocalDate start, LocalDate end, int small, int medium, int large) {
		JSONObject result = new JSONObject();

		for (Venue venue : this.venues) {
			LocalDateRange dateRange = new LocalDateRange(start, end);

			Booking booking = Booking.getBookingById(venue.getBookings(), id);
			if (booking != null) {
				boolean status = booking.requestChange(dateRange, small, medium, large);

				if (status) {
					result.put("venue", venue.getName());

					JSONArray rooms = new JSONArray();
					for (Room room : booking.getRooms()) {
						room.getName();
					}
					result.put("rooms", rooms);

					result.put("status", "success");

					return result;
				}

				result.put("status", "rejected");
				return result;
			}

		}

		result.put("status", "rejected");
		return result;
	}

	/**
	 * List the rooms and their bookings for a specified venue
	 * 
	 * @param venue
	 * @return JSONArray
	 */
	public JSONArray list(String venue) {
		JSONArray result = new JSONArray();

		// Assume `venue` is valid
		Venue venueObj = Venue.getVenueByName(this.venues, venue);
		for (Room room : venueObj.getRooms()) {
			JSONObject roomJSON = new JSONObject();
			roomJSON.put("room", room.getName());

			// For each booking, add a reservation object into an array
			JSONArray reservationsJSON = new JSONArray();
			for (Booking booking : venueObj.getBookingsByRoom(room)) {
				JSONObject reservationJSON = new JSONObject();
				reservationJSON.put("id", booking.getId());
				reservationJSON.put("start", booking.getStartDate().toString());
				reservationJSON.put("end", booking.getEndDate().toString());

				reservationsJSON.put(reservationJSON);
			}
			roomJSON.put("reservations", reservationsJSON);

			// Attach room json to result
			result.put(roomJSON);
		}

		return result;
	}

	public static void main(String[] args) {
		VenueHireSystem system = new VenueHireSystem();

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.trim().equals("")) {
				JSONObject command = new JSONObject(line);
				system.processCommand(command);
			}
		}
		sc.close();
	}

}
