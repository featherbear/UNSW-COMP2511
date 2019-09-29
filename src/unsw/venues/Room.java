package unsw.venues;

import java.util.ArrayList;

public class Room {
	private String name;
	private Size size;
	private Venue venue;

	/**
	 * Get the room in the venue matching a name
	 * 
	 * @param rooms
	 * @param name
	 * @return Room || null
	 */
	public static Room getRoomByName(ArrayList<Room> rooms, String name) {
		for (Room room : rooms) {
			if (room.getName().equals(name))
				return room;
		}
		return null;
	}

	/**
	 * Get the rooms in the venue that match a size
	 * 
	 * @param rooms
	 * @param size
	 * @return ArrayList<Room>
	 */
	public static ArrayList<Room> getRoomsBySize(ArrayList<Room> rooms, Size size) {
		ArrayList<Room> result = new ArrayList<Room>();

		for (Room room : rooms) {
			if (room.getSize() == size)
				result.add(room);
		}

		return result;
	}

	/**
	 * Create a room
	 * 
	 * @param name
	 * @param size
	 * @param venue
	 */
	Room(String name, Size size, Venue venue) {
		this.name = name;
		this.size = size;
		this.venue = venue;
	}

	// Note: NOT making setter methods, as these don't change

	/**
	 * @return Room name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return Room size
	 */
	public Size getSize() {
		return this.size;
	}

	/**
	 * @return Room's venue
	 */
	public Venue getVenue() {
		return this.venue;
	}
}
