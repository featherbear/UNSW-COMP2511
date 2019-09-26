package staff.test;

import staff.Lecturer;
import staff.StaffMember;
import java.time.LocalDate;

public class StaffTest {
	public static void printStaffDetails(StaffMember s) {
		System.out.println(s.toString());
	}

	public static void main(String[] args) {

		StaffMember staff1 = new StaffMember("Jane Citizen", 12.50, java.time.LocalDate.of(1970, 1, 1),
				java.time.LocalDate.of(1970, 1, 2));
		StaffMember staff1_copy = new StaffMember("Jane Citizen", 12.50, java.time.LocalDate.of(1970, 1, 1),
				java.time.LocalDate.of(1970, 1, 2));
		StaffMember staff2 = new StaffMember("John Doe", 12.50, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2));

		assert staff1.equals(staff1_copy);
		assert !staff1.equals(staff2);
		assert !staff1.equals(null);
		assert !staff2.equals(null);

		printStaffDetails(staff1);
		printStaffDetails(staff1_copy);
		printStaffDetails(staff2);
		
		Lecturer lec1 = new Lecturer("Aye Bee", 48.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Sea Ess Eee", 'A');
		Lecturer lec1_copy = new Lecturer("Aye Bee", 48.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Sea Ess Eee", 'A');
		Lecturer lec2 = new Lecturer("Yip E Doo", 190.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Home", 'X');

		assert lec1.equals(lec1_copy);
		assert !lec1.equals(lec2);

		assert !lec1.equals(null);
		assert !lec2.equals(null);

		printStaffDetails(lec1);
		printStaffDetails(lec1_copy);
		printStaffDetails(lec2);
		
		assert (!lec1.equals(staff1));
		assert (!staff1.equals(lec1));

		assert (!lec1.equals(staff1));
		assert (!staff1.equals(lec1));

		{
			assert (staff1.toString().contentEquals(staff2.toString()));
		}

		System.out.println("WE DID IT!");

	}
}
