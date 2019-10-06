package unsw.enrolment;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Lecture extends Session {

	private String lecturer;

	public Lecture(String location, DayOfWeek day, LocalTime start, LocalTime end, String lecturer) {
		super(location, day, start, end);
		this.lecturer = lecturer;
	}

	public String getLecturer() {
		return lecturer;
	}

	@Override
	public String toString() {
		return String.format("Lecture | %s %s-%s @ %s w/ %s", super.getDayString(), super.getStart(), super.getEnd(),
				super.getLocation(), this.lecturer);
	}
}
