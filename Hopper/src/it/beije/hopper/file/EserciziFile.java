package it.beije.hopper.file;

import it.beije.hopper.Finanze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EserciziFile {

    public static List<Finanze> readRubrica(String path) {
        File file = new File(path);

        System.out.println("file exists? " + file.exists());

        FileReader fileReader = null;

        List<Finanze> finanzeArrayList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
                System.out.println("rows[" + c + "] " + rows.get(c++));
            }

            Finanze finanza = null;
            for (String row : rows) {

                String[] cols = row.split(" ");

                finanza = new Finanze();
                finanza.setNome(cols[0]);
                finanza.setImporto(Float.valueOf(cols[1]));
                finanza.setQuantita(Integer.valueOf(cols[2]));
                if (cols[3].length() == 1) {
                    if (!(cols[3].charAt(0) == 'B' || cols[3].charAt(0) == 'S'))
                        errorList.add(row);
                    else finanza.setOperazione(cols[3].charAt(0));
                } else {
                    errorList.add(row);
                }


                finanzeArrayList.add(finanza);
            }
            calculateBuyAndSell(finanzeArrayList, errorList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException inner) {
                inner.printStackTrace();
            }
        }

        return finanzeArrayList;
    }

    public static void calculateBuyAndSell(List<Finanze> finanzeArrayList, List<String> ee) {
        int bb = 0;
        int ss = 0;
        for (Finanze finanza : finanzeArrayList) {
            if (finanza.getOperazione().equals('B'))
                bb++;
            else ss++;
        }
        System.out.println("Op: " + finanzeArrayList.size() + "Buy: " + bb + "Sell: " + ss);
        System.out.println("Err: " + ee.size());
        for (String row:ee)
            System.out.println(row);
    }
}
