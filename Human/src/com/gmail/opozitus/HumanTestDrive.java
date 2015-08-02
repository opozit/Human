package com.gmail.opozitus;

public class HumanTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GroupOfStudent group = new GroupOfStudent("XE-61");
		InputInterface inIn = new InputInterface(group);
		inIn.dialog();
		System.out.println("Роботу завершено");
		System.out.println();

	}

}
