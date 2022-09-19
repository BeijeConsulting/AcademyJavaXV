package it.beije.hopper.xml.parser.gruppo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser2 {


    //true se XML è ben formato
    public static boolean checkXML(List<String> rows) {
        for (int i = 1; i < rows.size() - 1; i++) {
            if (rows.get(i).contains("</")) {
                if (rows.get(i).substring(rows.get(i).indexOf("<") + 1).contains("<"))
                    if (rows.get(i).indexOf("<") == rows.get(i).indexOf("</")) {
                        return false;
                    }
                String name = rows.get(i).trim().substring(rows.get(i).trim().indexOf('<') + 1, (rows.get(i).trim().indexOf('=') > 0 ? rows.get(i).trim().indexOf(' ') : rows.get(i).trim().indexOf('>')));
                if (!(rows.get(i).trim().contains("</" + name + ">")) && !rows.get(i).trim().startsWith("</")) {
                    return false;
                }
            } else {
                if (rows.get(i).trim().indexOf('>') + 1 != rows.get(i).trim().length()) {
                    return false;
                }
            }
        }
        return true;
    }


    public static XmlElement readXML(String path) {

        File file = new File(path);

        System.out.println("file exists? " + file.exists());

        FileReader fileReader = null;

        XmlElement xmlElement = new XmlElement();

        try {
            fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
            }

            for (int i = 2; i < rows.size() - 1; i++) {
                if (rows.get(i).trim().isEmpty()) {
                    rows.remove(i);
                }

                if (rows.get(i).contains("<!--")) {

                    while (!rows.get(i).endsWith("-->")) {
                        rows.remove(rows.get(i));

                    }

                }
            }

            if (!checkXML(rows)) {
                System.err.println("XML format is not valid");
                System.exit(1);
            }


            xmlElement.setRoot(rows.get(1).split(" ", 3)[0].substring(1).replace(">", ""));

            for (int i = 2; i < rows.size() - 1; i++) {

                if (rows.get(i).contains("/") && rows.get(i).trim().indexOf('/') != 1) {
                    XmlElement e = new XmlElement();
                    if (rows.get(i).contains("\"/")) {
                        String[] temp = rows.get(i).split(" ");
                        e.setNome(temp[0].substring(1).trim().replace("<", ""));
                        for (int j = 1; j < temp.length; j++) {
                            e.add(new XmlElement(temp[j].trim().substring(0, temp[j].trim().indexOf('=')), temp[j].trim().substring(temp[j].trim().indexOf('=') + 1).replace("\"", "").replace(">", "")));
                        }


                    } else if (rows.get(i).trim().charAt(rows.get(i).trim().indexOf('/') + 1) != '>') {
                        e.setNome(rows.get(i).substring(rows.get(i).indexOf('<') + 1, rows.get(i).indexOf('>')));
                        e.setValore(rows.get(i).substring(rows.get(i).indexOf('>') + 1, rows.get(i).indexOf("</")));
                    } else {
                        e.setNome(rows.get(i).substring(rows.get(i).indexOf('<') + 1, rows.get(i).indexOf('/')));
                    }
                    xmlElement.add(e);
                } else if (!(rows.get(i).contains("/"))) {
                    if (rows.get(i).indexOf('"') > 0) {
                        String[] temp = rows.get(i).split(" ", 3);
                        xmlElement.setNome(temp[0].substring(1).trim().replace("<", ""));
                        for (int j = 1; j < temp.length; j++) {
                            xmlElement.add(new XmlElement(temp[j].trim().substring(0, temp[j].trim().indexOf('=')), temp[j].trim().substring(temp[j].trim().indexOf('=') + 1).replace("\"", "").replace(">", "")));
                        }
                    } else {
                        xmlElement.setNome(rows.get(i).trim().substring(rows.get(i).trim().indexOf('<') + 1, rows.get(i).trim().indexOf('>')));
                    }
                }

            }


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
        return xmlElement;

    }

    public static void main(String... args) {
        XmlElement e = readXML("C:\\Users\\emanu\\Desktop\\test_parser4.xml"); // path del xml
        System.out.println(e.getRoot());
        System.out.println(e.getElementsByTagName("nome"));

        ArrayList<XmlElement> e2 = e.getChildNodes();
        for (XmlElement element : e2) {
            System.out.println(element);
        }
        ArrayList<XmlElement> e3 = e.getChildElements();
        for (XmlElement element : e3) {
            System.out.println(element);
        }
        System.out.println(e.getTagName());
        System.out.println((e.getAttributes()));
        System.out.println(e.getAttribute("nome"));
    }

}
