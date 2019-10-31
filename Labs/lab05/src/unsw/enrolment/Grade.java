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

	private ArrayList<GradeObserver> subscribers;
	private GradeObserver thisBubbler;

	public void notifySubscribers() {
		this.notifySubscribers(this);
	}

	private void notifySubscribers(Grade data) {
		for (GradeObserver subscriber : this.subscribers) {
			subscriber.update(this, data);
		}
	}

	public void subscribe(GradeObserver subscriber) {
		if (this.subscribers.contains(subscriber)) {
			return;
		}
		this.subscribers.add(subscriber);
	}

	public void unsubscribe(GradeObserver subscriber) {
		this.subscribers.remove(subscriber);
	}

	private void registerBubblingSubscription(Grade grade) {
		// Anonymous functions change their memory addresses, so set it once.
		if (thisBubbler == null) {
			this.thisBubbler = (parent, data) -> {
				this.notifySubscribers(data);
			};
		}

		grade.subscribe(thisBubbler);
	}

	public Grade(String name, int mark) {
		this();
		this.setName(name);
		this.setMark(mark);
	}

	public Grade() {
		this.mark = 0;
		this.name = "";
		this.strategy = null;
		this.components = new ArrayList<Grade>();
		this.subscribers = new ArrayList<GradeObserver>();
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
		notifySubscribers();

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
		return this.addComponent(newSumGrade());
	}

	static public Grade newAvgGrade() {
		Grade grade = new Grade();
		grade.strategy = new Average();
		return grade;
	}

	public Grade addAvgComponent() {
		return this.addComponent(newAvgGrade());
	}

	public Grade addComponent(Grade grade) {
		if (this == grade) {
			throw new Error("Attempted addComponent to self");
		}

		if (this.strategy == null) {
			this.strategy = new Sum();
		}

		this.components.add(grade);
		registerBubblingSubscription(grade);

		if (grade.strategy == null) {
			notifySubscribers();
		}

		return grade;
	}

	public Grade addComponent(String name, int mark) {
		// return this.addComponent().setMark(mark);
		return this.addComponent(new Grade().setName(name).setMark(mark));
	}

	public Grade addComponent(Grade... grades) {
		for (Grade grade : grades) {
			this.addComponent(grade);
		}
		return this;
	}

	@Override
	public String toString() {
		if (this.strategy != null) {
			String grades = "";
			for (Grade component : this.components) {
				grades += component + ", ";
			}

			if (grades.length() >= 2) {
				grades = grades.substring(0, grades.length() - 2);
			}

			return String.format("%s(%d)[%s]", getName(), this.getMark(), grades);
		} else {
			return String.format("%s(%d)", getName(), this.getMark());
		}
	}
}
