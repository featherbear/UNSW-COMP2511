package unsw.enrolment;

public class Enrolment {

	private CourseOffering offering;
	private Grade grade;
	private Student student;

	public Enrolment(CourseOffering offering, Student student) {
		this.offering = offering;
		this.student = student;
		this.grade = new Grade();
	}

	public Course getCourse() {
		return offering.getCourse();
	}

	public String getTerm() {
		return offering.getTerm();
	}

	public Grade getGrade() {
		return this.grade;
	}

	public int getMark() {
		return this.grade.getMark();
	}

	public void setMark(int mark) {
		this.grade.setMark(mark);
	}

}
