package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
	private Venue venue;
	private String id;

	private ArrayList<Room> rooms;
	private LocalDate startDate;
	private LocalDate endDate;

	private int small_count;
	private int medium_count;
	private int large_count;

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

		this.small_count = 0;
		this.medium_count = 0;
		this.large_count = 0;
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

		// Increase the room count
		switch (room.getSize()) {
		case SMALL:
			this.small_count++;
			break;
		case MEDIUM:
			this.medium_count++;
			break;
		case LARGE:
			this.large_count++;
			break;
		}
	}

	public void removeRoom(Room room) {
		// Assume `room` inside `this.rooms`

		this.rooms.remove(room);

		// Update the room count
		switch (room.getSize()) {
		case SMALL:
			this.small_count--;
			break;
		case MEDIUM:
			this.medium_count--;
			break;
		case LARGE:
			this.large_count--;
			break;
		}
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
		switch (size) {
		case SMALL:
			return this.small_count;
		case MEDIUM:
			return this.medium_count;
		case LARGE:
			return this.large_count;
		default:
			// Assume safe input
			return 0;
		}

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
		// Check if the venue can accommodate the new booking details
		if (!(this.venue._canBook(dateRange, small, medium, large, this.small_count, this.medium_count,
				this.large_count))) {
			return false;
		}

		this.startDate = dateRange.getStart();
		this.endDate = dateRange.getEnd();

		// If there are extra rooms, then add extra rooms from the list of free rooms
		if (small > this.small_count || medium > this.medium_count || large > this.large_count) {
			ArrayList<Room> freeRooms = this.venue.getFreeRooms(dateRange);

			if (small > this.small_count) {
				ArrayList<Room> freeSmallRooms = Room.getRoomsBySize(freeRooms, Size.SMALL);
				for (int i = 0; i < small - this.small_count; i++) {
					this.addRoom(freeSmallRooms.get(i));
				}
				this.small_count = small;
			}
			if (medium > this.medium_count) {
				ArrayList<Room> freeMediumRooms = Room.getRoomsBySize(freeRooms, Size.MEDIUM);
				for (int i = 0; i < medium - this.medium_count; i++) {
					this.addRoom(freeMediumRooms.get(i));
				}
				this.medium_count = medium;
			}

			if (large > this.large_count) {
				ArrayList<Room> freeLargeRooms = Room.getRoomsBySize(freeRooms, Size.LARGE);
				for (int i = 0; i < large - this.large_count; i++) {
					this.addRoom(freeLargeRooms.get(i));
				}
				this.large_count = large;
			}
		}

		// If there are fewer rooms, then remove the extra rooms (from the end) from the
		// list
		if (small < this.small_count) {
			ArrayList<Room> smallRooms = this.getRoomsBySize(Size.SMALL);

			for (int i = 0; i < this.small_count - small;) {
				this.removeRoom(smallRooms.get(smallRooms.size() - (i + 1)));
			}
			this.small_count = small;
		}

		if (medium < this.medium_count) {
			ArrayList<Room> mediumRooms = this.getRoomsBySize(Size.SMALL);

			for (int i = 0; i < this.medium_count - medium;) {
				this.removeRoom(mediumRooms.get(mediumRooms.size() - (i + 1)));
			}
			this.medium_count = medium;
		}

		if (large < this.large_count) {

			ArrayList<Room> largeRooms = this.getRoomsBySize(Size.LARGE);

			for (int i = 0; i < this.large_count - large;) {
				this.removeRoom(largeRooms.get(largeRooms.size() - (i + 1)));
			}
			this.large_count = large;

		}

		return true;
	}

	@Override
	public String toString() {
		return String.format("%s @ %s", this.id, this.venue);
	}
}
