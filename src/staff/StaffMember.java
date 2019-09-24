package staff;

import java.util.Date;

/**
 * A staff member
 * 
 * @author Robert Clifton-Everest
 *
 */
public class StaffMember {
	private String name;
	private float salary;
	private Date hireStart;
	private Date endDate;

	public StaffMember(String name, float salary, Date hireStart, Date endDate) {
		this.name = name;
		this.salary = salary;
		this.hireStart = hireStart;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	public Date getHireStart() {
		return hireStart;
	}

	public Date getEndDate() {
		return endDate;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setSalary(float salary) {
//		this.salary = salary;
//	}
//
//	public void setHireStart(Date hireStart) {
//		this.hireStart = hireStart;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}

	@Override
	public String toString() {
		return this.name + " (" + this.hireStart + " => " + this.endDate + ") has a salary of $" + this.salary;

	}

	@Override
	public boolean equals(Object cmp) {
		StaffMember s = (StaffMember) cmp;
		return s.getName().equals(this.name) && s.getEndDate().equals(this.endDate)
				&& s.getHireStart().equals(this.hireStart) && s.getSalary() == this.salary;
	}
}
