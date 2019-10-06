package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;

/**
 * A course in the enrolment system.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Course {

	private String courseCode;
	private String title;
	private int uoc;
	private List<Course> prereqs;
	private List<CourseOffering> courseOfferings;

	public Course(String courseCode, String title, int uoc) {
		this.courseCode = courseCode;
		this.prereqs = new ArrayList<Course>();
		this.courseOfferings = new ArrayList<CourseOffering>();
		this.title = title;
		this.uoc = 6;
	}

	public Course(String courseCode, String title) {
		this(courseCode, title, 6);
	}

	public void addPrereq(Course course) {
		prereqs.add(course);
	}

	public ArrayList<Course> getPrereq() {
		ArrayList<Course> result = new ArrayList<Course>();
		for (Course c : this.prereqs) {
			result.add(c);
		}

		return result;
	}

	public void addOffering(CourseOffering offering) {
		courseOfferings.add(offering);
	}

	public ArrayList<CourseOffering> getOfferings() {
		ArrayList<CourseOffering> result = new ArrayList<CourseOffering>();
		for (CourseOffering c : this.courseOfferings) {
			result.add(c);
		}

		return result;
	}

	public String getTitle() {
		return this.title;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setUOC(int uoc) {
		this.uoc = uoc;
	}

	public int getUOC() {
		return uoc;
	}

	@Override
	public String toString() {
		return String.format("(%s) %s - %d UOC", this.courseCode, this.title, this.uoc);
	}

}
