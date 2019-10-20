package unsw.enrolment;

import java.util.ArrayList;

import unsw.enrolment.grades.Average;
import unsw.enrolment.grades.MarkingStrategy;
import unsw.enrolment.grades.Sum;

public class Grade {

	private int mark;
	private String name;
	private ArrayList<Grade> components;
	private MarkingStrategy strategy;

	public Grade(int mark) {
		this();
		this.setMark(mark);
	}

	public Grade() {
		this.mark = 0;
		this.name = "";
		this.strategy = null;
		this.components = new ArrayList<Grade>();
	}

	private static String getMarkString(int mark) {
		if (mark < 50)
			return "FL";
		else if (mark < 65)
			return "PS";
		else if (mark < 75)
			return "DN";
		else
			return "HD";
	}

	public String getName() {
		return this.name;
	}

	public Grade setName(String name) {
		this.name = name;

		return this;
	}

	public String getGrade() {
		return Grade.getMarkString(this.getMark());
	}

	public int getMark() {
		if (this.components.size() == 0 || this.strategy == null) {
			return this.mark;
		}

		return this.strategy.getMark(this.components);
	}

	public Grade setMark(int mark) {
//		if (this.components.size() != 0 || this.strategy != null) {
//			throw new Error("Grade is a composite!");
//		}

		this.mark = mark;

		return this;
	}

	public boolean isPassing() {
		return this.getMark() >= 50;
	}

	static public Grade newSumGrade() {
		Grade grade = new Grade();
		grade.strategy = new Sum();
		return grade;
	}

	static public Grade newSumGrade(Grade... grades) {
		return newSumGrade().addComponent(grades);
	}

	public Grade addSumComponent() {
		Grade component = newSumGrade();
		this.components.add(component);
		return component;
	}

	static public Grade newAvgGrade() {
		Grade grade = new Grade();
		grade.strategy = new Average();
		return grade;
	}

	public Grade addAvgComponent() {
		Grade component = newAvgGrade();
		this.components.add(component);
		return component;
	}

	public Grade addComponent() {
		Grade component = new Grade();
		this.components.add(component);
		return component;
	}

	public Grade addComponent(int mark) {
		Grade component = addComponent();
		component.setMark(mark);
		return component;
	}

	public Grade addComponent(Grade grade) {
		this.components.add(grade);
		return this;
	}

	public Grade addComponent(Grade... grades) {
		for (Grade grade : grades) {
			this.components.add(grade);
		}
		return this;
	}

	@Override
	public String toString() {
		if (this.components.size() > 0) {
			String grades = "";
			for (Grade component : this.components) {
				grades += component + ", ";
			}
			return String.format("%s(%d)[%s]", getName(), this.getMark(), grades.substring(0, grades.length() - 2));
		} else {
			return String.format("%s(%d)", getName(), this.getMark());
		}
	}
}
