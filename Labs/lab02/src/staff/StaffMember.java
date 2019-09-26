package staff;

import java.time.LocalDate;

/**
 * A staff member
 * 
 * @author Robert Clifton-Everest
 *
 */
public class StaffMember {
	private String name;
	private double salary;
	private LocalDate hireStart;
	private LocalDate endDate;

	public StaffMember(String name, double salary, LocalDate hireStart, LocalDate endDate) {
		this.name = name;
		this.salary = salary;
		this.hireStart = hireStart;
		this.endDate = endDate;
	}

	/**
	 * Returns the staff member's name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the staff's salary
	 * 
	 * @return double
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Returns the date when the staff was hired
	 * 
	 * @return java.time.LocalDate
	 */
	public LocalDate getHireStart() {
		return hireStart;
	}

	/**
	 * Returns the date the staff finished working
	 * 
	 * @return java.time.LocalDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/* No */

	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public void setSalary(float salary) {
	// this.salary = salary;
	// }
	//
	// public void setHireStart(Date hireStart) {
	// this.hireStart = hireStart;
	// }
	//
	// public void setEndDate(Date endDate) {
	// this.endDate = endDate;
	// }

	@Override
	public String toString() {
		return this.name + " (" + this.hireStart + " => " + this.endDate + ") has a salary of $" + this.salary;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		StaffMember s = (StaffMember) obj;
		return s.getName().equals(this.name) && s.getEndDate().equals(this.endDate)
				&& s.getHireStart().equals(this.hireStart) && s.getSalary() == this.salary;
	}
}
