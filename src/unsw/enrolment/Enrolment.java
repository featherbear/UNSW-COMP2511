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
			this.grade = new Grade().setName("course");
			subscribeToGrade(this.grade);
		}

		this.grade.setMark(mark);

		return this.grade;

	}

	public Grade assignGrade(Grade... grades) {
		this.grade = Grade.newSumGrade(grades).setName("course");
		subscribeToGrade(this.grade);
		return this.grade;
	}

	private GradeObserver thisSubscriber;

	private void subscribeToGrade(Grade grade) {
		if (thisSubscriber == null) {
			thisSubscriber = (g, data) -> {
				System.out.println("Update!!!");
				System.out.println("Parent: " + String.format("%s - %d", g.getName(), g.getMark()));
				System.out.println("Data: " + data);
				System.out.println("\n\n");
			};
		}

		grade.subscribe(thisSubscriber);
	}

	public Grade getGrade() {
		return this.grade;
	}
}
