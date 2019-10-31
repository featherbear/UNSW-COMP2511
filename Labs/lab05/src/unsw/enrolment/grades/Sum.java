package unsw.enrolment.grades;

import java.util.ArrayList;

import unsw.enrolment.Grade;

public class Sum implements MarkingStrategy {
	@Override
	public int getMark(ArrayList<Grade> grades) {
		int result = 0;
		for (Grade grade : grades) {
			result += grade.getMark();
		}

		return result;
	}
}
