package com.gmail.opozitus;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class WriteFile {
	private String filePath;

	public WriteFile(String filePath) {
		super();
		this.filePath = filePath;

	}

	public void writeLine(String line) {
		File outFile = new File(filePath);
		try {
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("Не вдалося стоврити файл для збереження списку групи");
		}
		try (FileWriter fw = new FileWriter(outFile, true)) {
			fw.write(line);
			fw.write("\n");
		} catch (IOException e) {
			System.out.println("!!! File writing error");
		}

	}

}
