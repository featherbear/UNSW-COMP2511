package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;

public class Enrolment {

	private CourseOffering offering;
	private Grade grade;
	private Student student;
	private List<Session> sessions;

	public Enrolment(CourseOffering offering, Student student, Session... sessions) {
		this.offering = offering;
		this.student = student;
		this.grade = null; // Student has not completed course yet.
		student.addEnrolment(this);
		offering.addEnrolment(this);
		this.sessions = new ArrayList<>();
		for (Session session : sessions) {
			this.sessions.add(session);
		}
	}

	public Course getCourse() {
		return offering.getCourse();
	}

	public String getTerm() {
		return offering.getTerm();
	}

	public boolean hasPassed() {
		return grade != null && grade.isPassing();
	}

	public Grade assignMark(int mark) {
		if (this.grade == null) {
			this.grade = new Grade(mark);
		} else {
			this.grade.setMark(mark);
		}

		return this.grade;
	}

	public Grade assignGrade(Grade... grades) {
		Grade newGrade = new Grade().addSumComponent();
		for (Grade grade : grades) {
			newGrade.addComponent(grade);
		}
		this.grade = newGrade;
		return newGrade;

	}

	public Grade getGrade() {
		return this.grade;
	}
}
