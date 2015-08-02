package com.gmail.opozitus;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class InputInterface {
	private Scanner sc = new Scanner(System.in);
	private GroupOfStudent group;

	public InputInterface(GroupOfStudent group) {
		super();
		this.group = group;
	}

	public void dialog() {
		String answ = "";
		help();

		do {
			System.out.println("Введіть код");
			answ = sc.nextLine();

			if (answ.equalsIgnoreCase("a")) {
				if (group.groupLength() < 10) {
					Student st = add();
					try {
						group.addStudent(st);
						System.out.println("Студента додано");
						System.out.println();
					} catch (GroupFullException e) {
						System.out.println(e);
					}
				} else {
					System.out.println("Група вже заповнена");
				}
			} else if (answ.equalsIgnoreCase("f")) {
				System.out.println("Введіть прізвище студента");
				String surname = sc.nextLine();
				Student st = new Student();
				st = group.findStudent(surname);
				if (st != null) {
					System.out.println(st.toString());
				}
			} else if (answ.equalsIgnoreCase("l")) {
				group.listGroup();
			} else if (answ.equalsIgnoreCase("s")) {
				System.out.println("Введіть назву файлу");
				answ = sc.nextLine();
				saveToFile("src/com/gmail/opozitus/" + answ, group.getGroup());
				System.out.println("Файл успішно збережено");
			} else if (answ.equalsIgnoreCase("r")) {
				System.out.println("Введіть назву файлу");
				answ = sc.nextLine();
				ReadFile rf = new ReadFile("src/com/gmail/opozitus/" + answ);
				if (rf.readFromFile(group)) {
					System.out.println("Файл прочитано успішно");
				}

			} else if (answ.equalsIgnoreCase("h")) {
				help();
			} else if (answ.equalsIgnoreCase("sort")) {
				Arrays.sort(group.getGroup());
				System.out.println("Студентів у групі відсортовано");

			} else {
				if (!answ.equalsIgnoreCase("x")) {
					System.out.println("Невірно введено код");
				}
			}

		} while (!answ.equalsIgnoreCase("x"));
	}

	public Student add() {
		Student newStudent = new Student();
		System.out.println("Введіть прізвище ");
		newStudent.setSurname(sc.nextLine());
		System.out.println("Введіть ім’я ");
		newStudent.setName(sc.nextLine());
		System.out.println("Введіть дату народження");
		newStudent.setBirthDay(sc.nextLine());
		System.out.println("Введіть стать (ч/ж)");
		newStudent.setSex(sc.nextLine().equalsIgnoreCase("ч") ? true : false);
		System.out.println("Введіть номер залікової книжки");
		newStudent.setId(sc.nextLine());
		return newStudent;
	}

	public void help() {
		System.out.println("a - додати студента ");
		System.out.println("f - знайти студента ");
		System.out.println("l - вивести список групи ");
		System.out.println("s - Зберегти список групи у файл");
		System.out.println("r - Прочитати список групи з файлу");
		System.out.println("h - допомога по кодах  ");
		System.out.println("x - завершити роботу  ");
		System.out.println("sort - сортувати список групи ");
		System.out.println();
	}

	public void saveToFile(String filePath, Student[] group) {
		WriteFile wf = new WriteFile(filePath);
		for (Student student : group) {
			Formatter f = new Formatter();
			f.format("%10.12s	%10.12s	%td.%tm.%ty %b %10.15s   ", student.getName(), student.getSurname(),
					student.getBirthDay(), student.getBirthDay(), student.getBirthDay(), student.isSex(),
					student.getId());
			wf.writeLine(f.toString());
			f.close();
		}

	}

}
