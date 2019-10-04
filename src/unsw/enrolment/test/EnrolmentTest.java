package unsw.enrolment.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.Lab;
import unsw.enrolment.Lecture;
import unsw.enrolment.Student;
import unsw.enrolment.Tutorial;

public class EnrolmentTest {

	public static void main(String[] args) {

		// Create courses
		Course comp1511 = new Course("COMP1511", "Programming Fundamentals");
		System.out.println(comp1511);

		Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals");
		comp1531.addPrereq(comp1511);
		System.out.println(comp1531);

		Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms");
		comp2521.addPrereq(comp1511);
		System.out.println(comp2521);

		Course comp2511 = new Course("COMP2511", "Object-Oriented Design & Programming");
		comp2511.addPrereq(comp1531);
		comp2511.addPrereq(comp2521);
		System.out.println(comp2511);

		CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
		{
			Lecture lecM9 = new Lecture("Online", DayOfWeek.MONDAY, LocalTime.of(9, 00), LocalTime.of(11, 00),
					"One of the Andrews");
			Lecture lecM11 = new Lecture("Online", DayOfWeek.MONDAY, LocalTime.of(11, 00), LocalTime.of(13, 00),
					"One of the Andrews");
			Tutorial tutM13 = new Tutorial("Online", DayOfWeek.MONDAY, LocalTime.of(13, 00), LocalTime.of(14, 00),
					"One of the Andrews");
			Lab labM14 = new Lab("Online", DayOfWeek.MONDAY, LocalTime.of(14, 00), LocalTime.of(16, 00), "Andrew 1",
					"Andrew 2");

			comp1511Offering.addSession(lecM9);
			comp1511Offering.addSession(lecM11);
			comp1511Offering.addSession(tutM13);
			comp1511Offering.addSession(labM14);
		}
		System.out.println(comp1511Offering);

		CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
		comp1531Offering.addSession(
				new Lecture("There", DayOfWeek.FRIDAY, LocalTime.of(9, 00), LocalTime.of(13, 00), "Art Thee"));
		System.out.println(comp1531Offering);

		CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");
		comp2521Offering.addSession(new Lecture("Ainsworth G03", DayOfWeek.THURSDAY, LocalTime.of(11, 00),
				LocalTime.of(13, 00), "Jam Stack"));
		System.out.println(comp2521Offering);

		CourseOffering comp2511Offering = new CourseOffering(comp2511, "19T3");
		{
			Lecture lecT14 = new Lecture("CLB 7", DayOfWeek.TUESDAY, LocalTime.of(16, 00), LocalTime.of(18, 00),
					"Ashesh");
			Lecture lecW14 = new Lecture("CLB 7", DayOfWeek.WEDNESDAY, LocalTime.of(16, 00), LocalTime.of(18, 00),
					"Ashesh");
			Lab labH10 = new Lab("J17-305", DayOfWeek.THURSDAY, LocalTime.of(10, 00), LocalTime.of(12, 00),
					"James O'Brien", "Victor Fang");

			comp2511Offering.addSession(lecT14);
			comp2511Offering.addSession(lecW14);
			comp2511Offering.addSession(labH10);
		}
		System.out.println(comp2511Offering);

		// Create student
		Student s = new Student("z5206677");
		System.out.println(s);

		// TODO Enrol the student in COMP1511 for T1 (this should succeed)
		Enrolment comp1511Enrolment = s.enrol(comp1511Offering);
		System.out.println(comp1511Enrolment);

		// TODO Enrol the student in COMP1531 for T1 (this should fail as they
		// have not met the prereq)
		{
			boolean expected = false;
			try {
				Enrolment comp1531Enrolment = s.enrol(comp1531Offering);
			} catch (Error e) {
				expected = true;
			}
			assert (expected);
		}

		// TODO Give the student a passing grade for COMP1511
		comp1511Enrolment.setMark(50);
		System.out.println(comp1511Enrolment);

		// TODO Enrol the student in 2521 (this should succeed as they have met
		// the prereqs)
		Enrolment comp2521Enrolment = s.enrol(comp2521Offering);
		comp2521Enrolment.setMark(50);
		System.out.println(comp2521Enrolment);

		// Oh no they failed!
		Enrolment comp1531Enrolment = s.enrol(comp1531Offering);
		comp1531Enrolment.setMark(40);
		System.out.println(comp1531Enrolment);

		// Pass this time!
		Enrolment comp1531Enrolment2 = s.enrol(comp1531Offering);
		// Okay so technically s should be trying to enrol in a different offering
		// but...
		comp1531Enrolment2.setMark(51);
		System.out.println(comp1531Enrolment2);

		Enrolment comp2511Enrolment = s.enrol(comp2511Offering);
		comp2511Enrolment.setMark(97);
		System.out.println(comp2511Enrolment);

	}
}
