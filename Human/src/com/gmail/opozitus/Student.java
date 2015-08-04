package com.gmail.opozitus;

import java.util.Formatter;

public class Student extends Human implements Comparable<Object> {

	private GroupOfStudent group;
	private String id;
	private String sortMetod;

	public Student(String name, String surname, String birthDay, boolean sex, GroupOfStudent group, String id) {
		super(name, surname, birthDay, sex);
		this.group = group;
		this.id = id;
		this.sortMetod = "a";
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

	public String getSortMetod() {
		return sortMetod;
	}

	public void setSortMetod(String sortMetod) {
		this.sortMetod = sortMetod;
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
		if (st.getSortMetod().equals("b")) {
			return this.birthDay.compareTo(st.getBirthDay());
		} else if (st.getSortMetod().equals("c")) {
			return id.compareToIgnoreCase(st.getId());
		} else {
			return surname.compareToIgnoreCase(st.getSurname());
		}

	}

}