package it.beije.hopper.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddsInRows {
    public static String addsInRow(int indexOfRow) {
        String path = "";
        File file = new File(path);

        StringBuilder returnString = new StringBuilder();

        System.out.println("file exists? " + file.exists());

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<String>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
                System.out.println("rows[" + c + "] " + rows.get(c++));
            }

            String row = rows.get(indexOfRow);
            String[] cols = row.split("\t");
            int addResult = 0;
            for (String col : cols) {
                addResult += Integer.parseInt(col);
                returnString.append(col).append(" + ");
            }
            returnString.delete(returnString.length() - 2, returnString.length()).append("= ").append(addResult);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException inner) {
                inner.printStackTrace();
            }
        }

        return returnString.toString();
    }

    public static void caffeina(int n) {
        if (n % 3 == 0 && n % 4 == 0) {
            System.out.print("Coffee Script");
        } else if (n % 3 == 0) {
            System.out.print("Java ");
            if (n % 2 == 0) System.out.print("Script");
        } else System.out.print("match_missed!");
    }

    public static void main(String[] args) {
        //   addsInRow(2);
        System.out.println(Arrays.toString(shadesOfGrey(5555)));
    }

    static String[] shadesOfGrey(int num) {
        if (num <= 0) return new String[0];
        if (num >= 256) {
            num = 256;
        }
        String[] gray = new String[num];

        for (int i = 0; i < num; i++) {
            if (i < 16)
                gray[i] = "#" + 0 + Integer.toHexString(i).toUpperCase() + 0 + Integer.toHexString(i).toUpperCase() + 0 + Integer.toHexString(i).toUpperCase();
            else
                gray[i] = "#" + Integer.toHexString(i).toUpperCase() + Integer.toHexString(i).toUpperCase() + Integer.toHexString(i).toUpperCase();
        }
        return gray;
    }

}
