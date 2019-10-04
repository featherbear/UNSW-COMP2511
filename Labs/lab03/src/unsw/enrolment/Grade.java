package unsw.enrolment;

public class Grade {
	private int mark;
	private String specialGrade;

	public Grade(int mark) {
		// Only allow 0 <= mark <= 100
		if (!(0 <= mark && mark <= 100))
			throw new Error("Invalid mark");
		this.mark = mark;
		this.specialGrade = null;

	}

	public Grade() {
		this(0);
	}

	/**
	 * Set the mark
	 * 
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * Set the custom grade
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.specialGrade = grade;
	}

	/**
	 * @return grade representation of the mark
	 */
	public String getGrade() {
		if (this.specialGrade != null)
			return this.specialGrade;
		if (mark >= 85)
			return "HD";
		if (mark >= 75)
			return "D";
		if (mark >= 65)
			return "CR";
		if (mark >= 50)
			return "P";
		return "F";
	}

	/**
	 * @return mark
	 */
	public int getMark() {
		return this.mark;
	}

	@Override
	public String toString() {
		return String.format("%d (%s)", this.mark, this.getGrade());
	}
}
