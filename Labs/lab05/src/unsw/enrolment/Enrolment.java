package unsw.enrolment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Enrolment {

	private CourseOffering offering;
	private Grade grade;
	private Student student;
	private List<Session> sessions;
	private Logger logger;

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

		String logName = String.format("%s-%s-%s", this.getCourse().getCourseCode(), this.getTerm(),
				this.getStudent().getZID());
		logger = Logger.getLogger(logName);

		FileHandler fh;

		try {
			fh = new FileHandler(logName + ".txt", true);
			logger.addHandler(fh);

			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}

	public Course getCourse() {
		return offering.getCourse();
	}

	public String getTerm() {
		return offering.getTerm();
	}

	public Student getStudent() {
		return this.student;
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
				logger.info(String.format("Marks updated: %s -> %d", data.getName(), data.getMark()));
			};
		}

		grade.subscribe(thisSubscriber);
	}

	public Grade getGrade() {
		return this.grade;
	}
}
