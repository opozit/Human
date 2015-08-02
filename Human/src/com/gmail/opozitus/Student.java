package com.gmail.opozitus;

import java.util.Formatter;

public class Student extends Human implements Comparable<Object> {

	private GroupOfStudent group;
	private String id;

	public Student(String name, String surname, String birthDay, boolean sex, GroupOfStudent group, String id) {
		super(name, surname, birthDay, sex);
		this.group = group;
		this.id = id;
	}

	public Student() {
		super();
	}

	public GroupOfStudent getGroup() {
		return group;
	}

	public void setGroup(GroupOfStudent group) {
		this.group = group;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		Formatter f = new Formatter();
		f.format("%10.12s	%10.12s	%5.7s %10.15s   %td.%tm.%tY", name, surname, group.getGroupName(), id, birthDay,
				birthDay, birthDay);
		String st = f.toString();
		f.close();
		return st;

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Student st = (Student) o;
		if (surname.charAt(0) > st.getSurname().charAt(0)) {
			return 1;
		} else if (surname.charAt(0) < st.getSurname().charAt(0)) {
			return -1;
		} else {
			return 0;
		}
	}

}