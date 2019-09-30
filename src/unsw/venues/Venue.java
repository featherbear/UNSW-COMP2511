package unsw.venues;

import java.util.ArrayList;

import unsw.venues.exceptions.InsufficientRooms;
import unsw.venues.exceptions.RoomExists;

public class Venue {
	private String name;
	private ArrayList<Room> rooms;
	private ArrayList<Booking> bookings;

	/**
	 * Get a venue that matches a name from a list of venues
	 * 
	 * @param venues
	 * @param name
	 * @return ArrayList<Venue>
	 */
	public static Venue getVenueByName(ArrayList<Venue> venues, String name) {
		for (Venue venue : venues) {
			if (venue.getName().equals(name))
				return venue;
		}
		return null;
	}

	Venue(String name) {
		this.name = name;
		this.rooms = new ArrayList<Room>();
		this.bookings = new ArrayList<Booking>();
	}

	/**
	 * Creates a new Room in the venue. Throws
	 * 
	 * @param name
	 * @param size
	 */
	public void addRoom(String name, Size size) {
		// Check that the given room name doesn't exist
		for (Room room : this.rooms) {
			if (room.getName().equals(name))
				throw new RoomExists();
		}

		Room newRoom = new Room(name, size, this);
		this.rooms.add(newRoom);
	}

	/**
	 * @return Venue name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return Venue rooms
	 */
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}

	/**
	 * Get the room in the venue matching a name
	 * 
	 * @param name
	 * @return Room || null
	 */
	public Room getRoomByName(String name) {
		return Room.getRoomByName(this.rooms, name);
	}

	/**
	 * Get the rooms in the venue that match a size
	 * 
	 * @param size
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getRoomsBySize(Size size) {
		return Room.getRoomsBySize(this.rooms, size);
	}

	/**
	 * Check if the Venue has enough rooms for a booking
	 * 
	 * @param date   range
	 * @param number of small rooms
	 * @param number of medium rooms
	 * @param number of large rooms
	 * @param offset - number of small rooms
	 * @param offset - number of medium rooms
	 * @param offset - number of large rooms
	 * @return Bookability
	 */
	public boolean _canBook(LocalDateRange dateRange, int small, int medium, int large, int small_offset,
			int medium_offset, int large_offset) {
		int nSmall = 0;
		int nMedium = 0;
		int nLarge = 0;

		for (Room room : this.rooms) {
			switch (room.getSize()) {
			case SMALL:
				nSmall++;
				break;
			case MEDIUM:
				nMedium++;
				break;
			case LARGE:
				nLarge++;
				break;
			}
		}

		for (Booking booking : this.bookings) {
			if (booking.getDateRange().overlaps(dateRange)) {

				// TEST
				if (booking.getEndDate().isBefore(dateRange.getEnd()))
					continue;
				//

				nSmall -= booking.getSmallCount();
				nMedium -= booking.getMediumCount();
				nLarge -= booking.getLargeCount();
			}
		}

		nSmall += small_offset;
		nMedium += medium_offset;
		nLarge += large_offset;

		return !(small > nSmall || medium > nMedium || large > nLarge);
	}

	/**
	 * Check if the Venue has enough rooms for a booking
	 * 
	 * @param date   range
	 * @param number of small rooms
	 * @param number of medium rooms
	 * @param number of large rooms
	 * @return Bookability
	 */
	public boolean canBook(LocalDateRange dateRange, int small, int medium, int large) {
		return this._canBook(dateRange, small, medium, large, 0, 0, 0);
	}

	public ArrayList<Booking> getBookings() {
		return this.bookings;
	}

	/**
	 * Create a booking
	 * 
	 * @param id
	 * @param dateRange
	 * @param small
	 * @param medium
	 * @param large
	 * @return Booking
	 */
	public Booking addBooking(String id, LocalDateRange dateRange, int small, int medium, int large) {
		if (!(this.canBook(dateRange, small, medium, large)))
			throw new InsufficientRooms();

		// Assume small > 0 || medium > 0 || large > 0

		Booking booking = new Booking(this, id, dateRange);
		if (small > 0) {
			ArrayList<Room> smallRooms = Room.getRoomsBySize(this.getFreeRooms(dateRange), Size.SMALL);
			for (int i = 0; i < small; i++) {
				booking.addRoom(smallRooms.get(i));
			}
		}

		if (medium > 0) {
			ArrayList<Room> mediumRooms = Room.getRoomsBySize(this.getFreeRooms(dateRange), Size.MEDIUM);
			for (int i = 0; i < medium; i++) {
				booking.addRoom(mediumRooms.get(i));
			}
		}

		if (large > 0) {
			ArrayList<Room> largeRooms = Room.getRoomsBySize(this.getFreeRooms(dateRange), Size.LARGE);
			for (int i = 0; i < large; i++) {
				booking.addRoom(largeRooms.get(i));
			}
		}

		this.bookings.add(booking);
		return booking;

	}

	public ArrayList<Booking> getBookingsByRoom(Room room) {
		ArrayList<Booking> result = new ArrayList<Booking>();
		for (Booking booking : this.bookings) {
			if (booking.getRooms().contains(room))
				result.add(booking);
		}

		return result;
	}

	public ArrayList<Booking> getBookingsByRoom(String room) {
		return this.getBookingsByRoom(Room.getRoomByName(this.rooms, room));

	}

	public void removeBooking(Booking booking) {
		// Assume `booking` is valid
		this.bookings.remove(booking);
	}

	public ArrayList<Room> getFreeRooms(LocalDateRange dateRange) {
		ArrayList<Room> result = this.getRooms();
		for (Booking booking : Booking.getBookingsByDateRange(this.bookings, dateRange)) {
			for (Room room : booking.getRooms()) {
				result.remove(room);
			}
		}

		return result;

	}
}
