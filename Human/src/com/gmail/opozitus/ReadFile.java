package com.gmail.opozitus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	private String filePath;

	public ReadFile(String filePath) {
		super();
		this.filePath = filePath;
	}

	public ReadFile() {
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean readFromFile(GroupOfStudent newGroup) {
		boolean res = true;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String temp = "";
			for (; ((temp = br.readLine()) != null);) {
				String[] columns = temp.trim().split("\\s+");
				Student tStd = new Student(columns[0], columns[1], columns[2], columns[3].equalsIgnoreCase("true"),
						newGroup, columns[4]);
				try {
					newGroup.addStudent(tStd);
				} catch (GroupFullException e) {
					System.out.println(e);

				}
			}

		} catch (IOException e) {
			System.out.println("!!! File reading error");
			res = false;
		}
		return res;

	}

}
