package com.gmail.opozitus;

public class GroupOfStudent {
	private String groupName;
	private Student[] group;

	public GroupOfStudent(String groupName) {
		this.groupName = groupName;
		group = new Student[0];
	}

	public GroupOfStudent() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getGroup() {
		return group;
	}

	public Student findStudent(String surname) {
		Student out = null;
		for (Student student : group) {
			if (student.getSurname().equalsIgnoreCase(surname)) {
				out = student;
			}
		}
		if (out == null) {
			System.out.println("Студента не знайдено в групі " + this.groupName);
		}
		return out;
	}

	public void addStudent(Student newStudent) throws GroupFullException {
		if (group.length == 10)
			throw new GroupFullException();
		if (newStudent != null) {
			Student[] tGroup = new Student[group.length + 1];
			System.arraycopy(group, 0, tGroup, 0, group.length);
			tGroup[tGroup.length - 1] = newStudent;
			group = tGroup;
			newStudent.setGroup(this);
		}
	}

	public void listGroup() {
		if (group.length == 0) {
			System.out.println("Група порожня. Додайте студентів у групу " + this.groupName);
		}
		for (Student student : group) {
			System.out.println(student.toString());
		}

	}

	public int groupLength() {
		return group.length;
	}



}
