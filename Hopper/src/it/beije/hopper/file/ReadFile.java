package it.beije.hopper.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class ReadFile {

    static FileWriter writer;
    static File file;

    public static void findFilesInFolder(File folder, String tab) {
        try {
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    writer.write(tab + file.getName() + "\n");
                } else {
                    writer.write(tab + file.getName() + ".dir \n");
                    tab += "\t";
                    findFilesInFolder(file, tab);
                    tab = tab.substring(0, tab.length() - 1);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void createNewFile(String path) {
        try {
            file = new File(path + "filename.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());

            } else {
                System.out.println("File already exists.");
            }
            writer = new FileWriter(file.getPath());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ParseException, IOException {
        File folder = new File("C:\\Users\\emanu\\Desktop\\java");
        String path = "C:\\Users\\emanu\\Desktop\\";
        createNewFile(path);
        findFilesInFolder(folder, "");
        writer.close();
    }
}
