package com.gmail.opozitus;

public class CatTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat("Пені", 1, "Сіра", true, "Шотландська висловуха");
		Cat cat2 = new Cat("Леонард", 2, "Чорний", false, "дворова");
		Cat cat3 = new Cat("Воловіц", 2, "Рудий", false, "Шотландська висловуха");
		cat1.print();
		cat2.print();
		Cat cat4 = cat1.makeLove(cat2);
		if (cat4 != null) {
			cat4.print();
		}
		Cat cat5 = cat2.makeLove(cat3);
		if (cat5 != null) {
			cat5.print();
		}
	}

}
