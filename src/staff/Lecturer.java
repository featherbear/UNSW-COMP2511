package staff;

import java.util.Date;

public class Lecturer extends StaffMember {
	private String school;
	private char status;

	Lecturer(String name, float salary, Date hireStart, Date endDate, String school, char status) {
		super(name, salary, hireStart, endDate);
		this.school = school;
		this.status = status;
	}

	public String getSchool() {
		return this.school;
	}

	public char getStatus() {
		return this.status;
	}

	public void setStatus(char new_status) {
		this.status = new_status;
	}

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
		Lecturer l = (Lecturer) obj;
		return ((StaffMember) l).equals((StaffMember) this) && l.getSchool().equals(this.school)
				&& l.getStatus() == this.status;

	}

}
