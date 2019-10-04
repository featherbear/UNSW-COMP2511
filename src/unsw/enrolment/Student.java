package unsw.enrolment;

import java.util.ArrayList;

public class Student {

	private String zid;
	private ArrayList<Enrolment> enrolments;

	public Student(String zid) {
		this.zid = zid;
		this.enrolments = new ArrayList<>();
	}

	public String getZID() {
		return zid;
	}

	public boolean canEnrol(Course c) {
		for (Course p : c.getPrereq()) {
			// Find enrolments for that course (student might have failed previously)
			ArrayList<Enrolment> enrolmentsForCourse = new ArrayList<Enrolment>();

			for (Enrolment e : this.enrolments) {
				if (e.getCourse() == p)
					enrolmentsForCourse.add(e);
			}

			boolean passed = false;
			for (Enrolment e : enrolmentsForCourse) {
				if (e.getMark() >= 50) {
					passed = true;
					break;
				}
			}

			if (!passed)
				return false;

		}
		return true;

	}

	public boolean canEnrol(CourseOffering co) {
		return this.canEnrol(co.getCourse());
	}

	public Enrolment enrol(CourseOffering offering) {
		if (!this.canEnrol(offering.getCourse()))
			throw new Error("Prerequisites not met");

		Enrolment enrolment = new Enrolment(offering, this);
		this.enrolments.add(enrolment);

		return enrolment;
	}

}
