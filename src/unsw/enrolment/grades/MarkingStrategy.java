package unsw.enrolment.grades;

import java.util.ArrayList;

import unsw.enrolment.Grade;

public interface MarkingStrategy {
	public int getMark(ArrayList<Grade> grades);
}
