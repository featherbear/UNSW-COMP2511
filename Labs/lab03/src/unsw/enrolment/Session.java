package unsw.enrolment;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Session {

	private String location;
	private DayOfWeek day;
	private LocalTime start;
	private LocalTime end;

	public Session(String location, DayOfWeek day, LocalTime start, LocalTime end) {
		this.location = location;
		this.day = day;
		this.start = start;
		this.end = end;
	}

	public String getLocation() {
		return location;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public String getDayString() {
		switch (this.day) {
		case MONDAY:
			return "Monday";
		case TUESDAY:
			return "Tuesday";
		case WEDNESDAY:
			return "Wednesday";
		case THURSDAY:
			return "Thursday";
		case FRIDAY:
			return "Friday";
		default:
			return "---";
		}
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getEnd() {
		return end;
	}

}
