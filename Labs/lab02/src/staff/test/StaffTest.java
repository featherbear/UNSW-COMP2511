package staff.test;

import staff.Lecturer;
import staff.StaffMember;
import java.time.LocalDate;

public class StaffTest {
	public static void main(String[] args) {

		StaffMember staff1 = new StaffMember("Jane Citizen", 12.50, java.time.LocalDate.of(1970, 1, 1),
				java.time.LocalDate.of(1970, 1, 2));
		StaffMember staff1_copy = new StaffMember("Jane Citizen", 12.50, java.time.LocalDate.of(1970, 1, 1),
				java.time.LocalDate.of(1970, 1, 2));
		StaffMember staff2 = new StaffMember("John Doe", 12.50, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2));

		assert staff1.equals(staff1_copy);
		assert !staff1.equals(staff2);
		
		System.out.println("staff1 - " + staff1);
		System.out.println("staff1_copy - " + staff1_copy);
		System.out.println("staff2 - " + staff2);

		Lecturer lec1 = new Lecturer("Aye Bee", 48.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Sea Ess Eee", 'A');
		Lecturer lec1_copy = new Lecturer("Aye Bee", 48.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Sea Ess Eee", 'A');
		Lecturer lec2 = new Lecturer("Yip E Doo", 190.24, java.time.LocalDate.of(1970, 1, 2),
				java.time.LocalDate.of(1970, 1, 2), "Home", 'X');

		assert lec1.equals(lec1_copy);
		assert !lec1.equals(lec2);
		
		System.out.println("lec1 - " + lec1);
		System.out.println("lec1_copy - " + lec1_copy);
		System.out.println("lec2 - " + lec2);

		System.out.println("WE DID IT!");

	}
}
