package unsw.venues;

import java.util.ArrayList;

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
	 * Creates a new Room in the venue.
	 * 
	 * @param name
	 * @param size
	 */
	public void addRoom(String name, Size size) {
		// Assume `name` is unique

		Room newRoom = new Room(name, size, this);
		this.rooms.add(newRoom);
	}

	/**
	 * Remove a room from the venue
	 * 
	 * @param room
	 */
	public void removeRoom(Room room) {
		this.rooms.remove(room);
	}

	/**
	 * Remove a room from the venue
	 * 
	 * @param room
	 */
	public void removeRoom(String room) {
		// Assume `room` exists
		this.removeRoom(Room.getRoomByName(this.rooms, room));
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
		// Jenn thinks that we shouldn't put the cloning of the list here.
		ArrayList<Room> results = new ArrayList<Room>(this.countRooms());
		for (Room room : this.rooms)
			results.add(room);

		return results;
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
	 * @return boolean
	 */
	public boolean canBook(LocalDateRange dateRange, int small, int medium, int large) {
		return this.canBook(dateRange, small, medium, large, 0, 0, 0);
	}

	/**
	 * Check if the Venue has enough rooms for a booking, with supplied room offset
	 * 
	 * @param date          range
	 * @param number        of small rooms
	 * @param number        of medium rooms
	 * @param number        of large rooms
	 * @param offset_small  - number of small rooms
	 * @param offset_medium - number of medium rooms
	 * @param offset_large  - number of large rooms
	 * @return boolean
	 */
	public boolean canBook(LocalDateRange dateRange, int small, int medium, int large, int small_offset,
			int medium_offset, int large_offset) {

		// Use the `getRooms` method over `this.rooms` as it creates a copy
		ArrayList<Room> rooms = this.getRooms();

		for (Booking booking : this.bookings) {
			// If a booking overlaps the date range, then consider all of the rooms as
			// unavailable for the entire period
			if (booking.getDateRange().overlaps(dateRange)) {
				rooms.removeAll(booking.getRooms());
			}
		}

		// Check that there are enough rooms for each size
		return !((small - small_offset) > Room.getRoomsBySize(rooms, Size.SMALL).size()
				|| (medium - medium_offset) > Room.getRoomsBySize(rooms, Size.MEDIUM).size()
				|| (large - large_offset) > Room.getRoomsBySize(rooms, Size.LARGE).size());
	}

	/**
	 * @return bookings
	 */
	public ArrayList<Booking> getBookings() {
		ArrayList<Booking> results = new ArrayList<Booking>(this.bookings.size());
		for (Booking booking : this.bookings)
			results.add(booking);

		return results;
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
		if (!(this.canBook(dateRange, small, medium, large))) {
			throw new Error("Insufficient Rooms");
		}

		// Assume small > 0 || medium > 0 || large > 0

		ArrayList<Room> freeRooms = this.getFreeRooms(dateRange);

		Booking booking = new Booking(this, id, dateRange);

		// Add small rooms
		if (small > 0) {
			ArrayList<Room> smallRooms = Room.getRoomsBySize(freeRooms, Size.SMALL);
			for (int i = 0; i < small; i++) {
				booking.addRoom(smallRooms.get(i));
			}
		}

		// Add medium rooms
		if (medium > 0) {
			ArrayList<Room> mediumRooms = Room.getRoomsBySize(freeRooms, Size.MEDIUM);
			for (int i = 0; i < medium; i++) {
				booking.addRoom(mediumRooms.get(i));
			}
		}

		// Add large rooms
		if (large > 0) {
			ArrayList<Room> largeRooms = Room.getRoomsBySize(freeRooms, Size.LARGE);
			for (int i = 0; i < large; i++) {
				booking.addRoom(largeRooms.get(i));
			}
		}

		this.bookings.add(booking);

		// Sort the bookings by earliest to latest booking
		this.bookings.sort((Booking b1, Booking b2) -> b1.getStartDate().compareTo(b2.getStartDate()));

		return booking;

	}

	/**
	 * Find bookings that use a given room
	 * 
	 * @param room
	 * @return ArrayList<Booking>
	 */
	public ArrayList<Booking> getBookingsByRoom(Room room) {
		ArrayList<Booking> result = new ArrayList<Booking>();

		for (Booking booking : this.bookings) {
			if (booking.getRooms().contains(room))
				result.add(booking);
		}

		return result;
	}

	/**
	 * Find bookings that use a given room
	 * 
	 * @param room
	 * @return ArrayList<Booking>
	 */
	public ArrayList<Booking> getBookingsByRoom(String room) {
		return this.getBookingsByRoom(Room.getRoomByName(this.rooms, room));

	}

	/**
	 * Remove a booking from the venue bookings
	 * 
	 * @param booking
	 */
	public void removeBooking(Booking booking) {
		// Assume `booking` is valid
		this.bookings.remove(booking);
	}

	/**
	 * Get bookings that are not used within a LocateDateRange
	 * 
	 * @param dateRange
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getFreeRooms(LocalDateRange dateRange) {
		ArrayList<Room> result = this.getRooms();

		for (Booking booking : Booking.getBookingsByDateRange(this.bookings, dateRange)) {
			for (Room room : booking.getRooms()) {
				result.remove(room);
			}
		}

		return result;

	}

	/**
	 * Count the number of rooms of a given size in the venue
	 * 
	 * @param size
	 * @return number of rooms
	 */
	public int countRooms(Size size) {
		return Room.getRoomsBySize(this.rooms, size).size();
	}

	/**
	 * Count the number of rooms in the venue
	 * 
	 * @return number of rooms
	 */
	public int countRooms() {
		return this.rooms.size();
	}

	@Override
	public String toString() {
		return this.name;
	}
}
