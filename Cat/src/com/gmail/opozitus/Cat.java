package com.gmail.opozitus;

import java.util.Random;

public class Cat {
	private String name = "";
	private int age = 0;
	private String color = "";
	private boolean gender = false;
	private String breed = "";

	public Cat(String name, int age, String color, boolean gender, String breed) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.gender = gender;
		this.breed = breed;
	}

	public Cat() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	void mew() {
		System.out.println("Мяу-Мяу");
	}

	void olderCat(Cat otherCat) {
		if (this.age < otherCat.getAge()) {
			System.out.println(otherCat.getName() + " старший");
		} else if (this.age > otherCat.getAge()) {
			System.out.println(otherCat.getName() + " старший");
		} else {
			System.out.println("Коти одного віку");
		}
	}

	void print() {
		System.out.println("Кличка: " + this.name);
		System.out.println("Вік: " + this.age);
		System.out.println("Колір: " + this.color);
		System.out.println("Порода: " + this.breed);
		System.out.println("стать: " + (!this.gender ? "Чоловіча" : "Жіноча"));
		System.out.println();
	}

	public Cat makeLove(Cat otherCat) {
		if (this.age == 0) {
			System.out.println(this.name + " ще маленький");
			return null;
		}
		if (otherCat.getAge() == 0) {
			System.out.println(otherCat.getName() + " ще маленький");
			return null;
		}
		if (!this.gender && !otherCat.isGender()) {
			System.out.println("Бійка двох самців");
			return null;
		} else if (this.gender && otherCat.isGender()) {
			System.out.println("мур-мур");
			return null;
		} else {
			Random rnd = new Random(System.currentTimeMillis());
			String newColor = rnd.nextInt() < 0 ? this.color : otherCat.getColor();
			String newBreed = this.breed.equals(otherCat.getBreed()) ? "Чистокровний " + this.breed : "дворняга";
			boolean newGender = rnd.nextBoolean();
			Cat kitten = new Cat("Кошення", 0, newColor, newGender, newBreed);
			return kitten;
		}

	}

}
