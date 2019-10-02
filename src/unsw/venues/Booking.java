package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
	private Venue venue;
	private String id;

	private ArrayList<Room> rooms;
	private LocalDate startDate;
	private LocalDate endDate;

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
	 * @param startDate || null
	 * @param endDate   || null
	 * @return ArrayList<Booking>
	 */
	public static ArrayList<Booking> getBookingsByDateRange(ArrayList<Booking> bookings, LocalDate startDate,
			LocalDate endDate) {
		ArrayList<Booking> result = new ArrayList<Booking>();

		for (Booking booking : bookings) {
			if (DateUtils.dateRangeOverlapsDateRange(booking.getStartDate(), booking.getEndDate(), startDate,
					endDate)) {
				result.add(booking);
			}
		}

		return result;
	}

	/**
	 * Get bookings that are within a date range
	 * 
	 * @param bookings
	 * @param dateRange
	 * @return ArrayList<Booking>
	 */
	public static ArrayList<Booking> getBookingsByDateRange(ArrayList<Booking> bookings, LocalDateRange dateRange) {
		return getBookingsByDateRange(bookings, dateRange.getStart(), dateRange.getEnd());
	}

	/**
	 * Creates a booking
	 * 
	 * @param venue
	 * @param id
	 * @param startDate
	 * @param endDate
	 */
	public Booking(Venue venue, String id, LocalDate startDate, LocalDate endDate) {
		this.venue = venue;
		this.id = id;
		this.rooms = new ArrayList<Room>();

		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Creates a booking
	 * 
	 * @param venue
	 * @param id
	 * @param dateRange
	 */
	public Booking(Venue venue, String id, LocalDateRange dateRange) {
		this(venue, id, dateRange.getStart(), dateRange.getEnd());
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
		return this.rooms;
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
		return this.startDate;
	}

	/**
	 * @return Booking date range
	 */
	public LocalDateRange getDateRange() {
		return new LocalDateRange(this.startDate, this.endDate);
	}

	/**
	 * @return Booking end date
	 */
	public LocalDate getEndDate() {
		return this.endDate;
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
		if (!(this.venue._canBook(dateRange, small, medium, large, small_count, medium_count, large_count))) {
			return false;
		}

		this.startDate = dateRange.getStart();
		this.endDate = dateRange.getEnd();

		ArrayList<Room> freeRooms = null;

		// If there are extra rooms, then add extra rooms from the list of free rooms
		// If there are fewer rooms, then remove the extra rooms starting from the end

		if (small > small_count || medium > medium_count || large > large_count) {
			freeRooms = this.venue.getFreeRooms(dateRange);
		}

		if (small > small_count) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.SMALL), small - small_count);
		} else if (small < small_count) {
			this.removeRooms(Size.SMALL, small_count - small);
		}

		if (medium > medium_count) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.MEDIUM), medium - medium_count);
		} else if (medium < medium_count) {
			this.removeRooms(Size.MEDIUM, medium_count - medium);
		}

		if (large > large_count) {
			this.addRooms(Room.getRoomsBySize(freeRooms, Size.LARGE), large - large_count);
		} else if (large < large_count) {
			this.removeRooms(Size.LARGE, medium_count - medium);

		}

		return true;
	}

	private void addRooms(ArrayList<Room> rooms, int count) {
		for (int i = 0; i < count; i++) {
			this.addRoom(rooms.get(i));
		}
	}

	private void removeRooms(Size size, int count) {
		ArrayList<Room> rooms = this.getRoomsBySize(size);

		for (int i = 0; i < count; i++) {
			this.removeRoom(rooms.get(rooms.size() - (i + 1)));
		}
	}

	@Override
	public String toString() {
		return String.format("%s @ %s", this.id, this.venue);
	}
}
