package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
	private Venue venue;
	private String id;

	private ArrayList<Room> rooms;
	private LocalDateRange dateRange;

	/**
	 * Get a booking that matches an ID from a list of bookings
	 * 
	 * @param bookings
	 * @param id
	 * @return Booking || null
	 */
	public static Booking getBookingById(ArrayList<Booking> bookings, String id) {

		for (Booking booking : bookings) {
			if (booking.getId().equals(id))
				return booking;
		}

		return null;
	}

	/**
	 * Get bookings that are within a date range
	 * 
	 * @param bookings
	 * @param dateRange
	 * @return ArrayList<Booking>
	 */
	public static ArrayList<Booking> getBookingsByDateRange(ArrayList<Booking> bookings, LocalDateRange dateRange) {
		ArrayList<Booking> result = new ArrayList<Booking>();

		for (Booking booking : bookings) {

			if (booking.getDateRange().overlaps(dateRange)) {
				result.add(booking);
			}
		}

		return result;
	}

	/**
	 * Creates a booking
	 * 
	 * @param venue
	 * @param id
	 * @param dateRange
	 */
	public Booking(Venue venue, String id, LocalDateRange dateRange) {
		this.venue = venue;
		this.id = id;
		this.rooms = new ArrayList<Room>();

		this.dateRange = dateRange;
	}

	/**
	 * @return Booked venue
	 */
	public Venue getVenue() {
		return this.venue;
	}

	/**
	 * @return Booking Id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return Booked rooms
	 */
	public ArrayList<Room> getRooms() {
		ArrayList<Room> results = new ArrayList<Room>(this.rooms.size());

		for (Room room : this.rooms)
			results.add(room);

		return results;
	}

	/**
	 * Get the rooms in the booking that match a size
	 * 
	 * @param size
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getRoomsBySize(Size size) {
		return Room.getRoomsBySize(this.rooms, size);
	}

	/**
	 * @return Booking start date
	 */
	public LocalDate getStartDate() {
		return this.dateRange.getStart();
	}

	/**
	 * @return Booking end date
	 */
	public LocalDate getEndDate() {
		return this.dateRange.getEnd();
	}

	/**
	 * @return Booking date range
	 */
	public LocalDateRange getDateRange() {
		return this.dateRange;
	}

	/**
	 * Add a room to the booking
	 * 
	 * @param room
	 */
	public void addRoom(Room room) {
		// Assume `room` is unique
		this.rooms.add(room);
	}

	public void removeRoom(Room room) {
		// Assume `room` inside `this.rooms`
		this.rooms.remove(room);
	}

	/**
	 * Get number of rooms in the booking
	 * 
	 * @return count
	 */
	public int getCount() {
		return this.rooms.size();
	}

	/**
	 * Get number of rooms in the booking of a given size
	 * 
	 * @param size
	 * @return count
	 */
	public int getCount(Size size) {
		return Room.getRoomsBySize(this.rooms, size).size();
	}

	/**
	 * Attempt change
	 * 
	 * @param dateRange
	 * @param small
	 * @param medium
	 * @param large
	 * @return result
	 */
	public boolean requestChange(LocalDateRange dateRange, int small, int medium, int large) {
		int small_count = Room.getRoomsBySize(this.rooms, Size.SMALL).size();
		int medium_count = Room.getRoomsBySize(this.rooms, Size.MEDIUM).size();
		int large_count = Room.getRoomsBySize(this.rooms, Size.LARGE).size();

		// Check if the venue can accommodate the new booking details
		if (!(this.venue.canBook(dateRange, small, medium, large, small_count, medium_count, large_count))) {
			return false;
		}

		this.dateRange = dateRange;

		this.rooms.clear();

		ArrayList<Room> freeRooms = this.venue.getFreeRooms(dateRange);

		if (small > 0) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.SMALL), small);
		}
		if (medium > 0) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.MEDIUM), medium);
		}
		if (large > 0) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.LARGE), large);
		}

		return true;
	}

	private void addRooms(ArrayList<Room> rooms, int count) {
		for (int i = 0; i < count; i++) {
			this.addRoom(rooms.get(i));
		}
	}

	@Override
	public String toString() {
		return String.format("%s @ %s", this.id, this.venue);
	}
}
