package staff;

import java.time.LocalDate;

public class Lecturer extends StaffMember {
	private String school;
	private char status;

	public Lecturer(String name, double salary, LocalDate hireStart, LocalDate endDate, String school, char status) {
		super(name, salary, hireStart, endDate);
		this.school = school;
		this.status = status;
	}

	/**
	 * Returns the school that the lecturer works in
	 * @return String
	 */
	public String getSchool() {
		return this.school;
	}

	/**
	 * Returns the academic status of the lecturer
	 * @return char
	 */
	public char getStatus() {
		return this.status;
	}

	
	/**
	 * Sets the academic status of the lecturer
	 * @param new_status
	 */
	public void setStatus(char new_status) {
		this.status = new_status;
	}

	/**
	 * Eh.
	 * @return success: true/false
	 */
	public boolean PROMOTE_YAY() {
		switch (this.status) {
		case 'A':
			this.status = 'B';
			return true;
		case 'B':
			this.status = 'C';
			return true;
		default:
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " This person works at " + this.school + " with status " + this.status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Lecturer l = (Lecturer) obj;
		return ((StaffMember) l).equals((StaffMember) this) && l.getSchool().equals(this.school)
				&& l.getStatus() == this.status;

	}

}
