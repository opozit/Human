package com.gmail.opozitus;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Human {
	protected Date birthDay;
	protected boolean sex;
	protected String name;
	protected String surname;

	public Human(String name, String surname, String birthDay, boolean sex) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		try {
			this.sex = sex;
			this.name = name;
			this.surname = surname;
			Date date = sdf.parse(birthDay);
			this.birthDay = date;
		} catch (ParseException e) {
			System.out.println("!!! Wrong date format");
		}
	}

	public Human() {
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		try {
			Date date = sdf.parse(birthDay);
			this.birthDay = date;

		} catch (ParseException e) {
			System.out.println("!!! Wrong date format");
		}
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdfOut = new SimpleDateFormat("dd MMM yyyy");
		return name + " " + surname + " " + sex + " " + sdfOut.format(birthDay);
	}

}
