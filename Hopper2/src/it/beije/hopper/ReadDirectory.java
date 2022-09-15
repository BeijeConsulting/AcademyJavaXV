package it.beije.hopper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReadDirectory {

	public static File[] readDirectory(String path) throws IOException {

		File file = new File(path);
		File[] listaFile;
		listaFile = file.listFiles();
		ArrayList<String> listaString = new ArrayList<String>();

		for (File f : listaFile) {
			if (f.isFile()) {
				f.getAbsolutePath();
				listaString.add("" + f);
			} else if (f.isDirectory()) {
				readDirectory(f.getAbsolutePath());
				listaString.add("(dir) " + f.getName());
			}
		}
		Collections.sort(listaString);
		System.out.println(listaString);
		FileWriter fileWriter = new FileWriter("/test/file_scritto.txt", true);
		char sep = '|';
		char sep2 = '\n';

		for (String str : listaString) {
			fileWriter.write(str);
			fileWriter.write(sep);
			fileWriter.write(sep2);
		}

		fileWriter.flush();
		fileWriter.close();
		return listaFile;
	}

	public static void main(String[] args) throws IOException {
		String path = "/test/";
		readDirectory(path);
	}

}
