package it.beije.hopper.xml.parser.gruppo3;

import javax.print.Doc;
import java.io.*;
import java.util.*;

public class ParsingXML {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Raffaele\\Desktop\\AcademyJavaXV\\Hopper\\test_files\\xml\\test_parser1.xml";
        parse(path);
    }

    public static Documento parse(String path) throws IOException {

        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> rows = new ArrayList<String>();

        while (bufferedReader.ready()) {
            rows.add(bufferedReader.readLine());
        }

        Stack<Elemento> stack = new Stack<Elemento>();
        ArrayList<Elemento> elementi = new ArrayList<Elemento>();

        ricorsione(rows, elementi, stack,1, null);
        Documento doc = new Documento(elementi);
        return doc;
    }

    public static void ricorsione(List<String> rows, ArrayList<Elemento> elementi, Stack<Elemento> stack, int i, Elemento tagParent){

        boolean chiusura = false;
        String text="";
        String nome1="";
        String nome2="";

        String row = (rows.get(i).toString().replaceAll("\t",""));
        String[] a = row.split(">");  // /(<.[^(><.)]+>)/ regex tag XML

        if(a.length == 1){
            if(a[0].contains("/")){
               chiusura=true;
               nome1 = a[0].replace("</","").toString();
               Elemento tag1 = new Elemento(nome1);
                if(isPair(stack.peek(), tag1)){
                    stack.pop();
                }else{
                    System.out.println("Alert! C'è errore nel file .XML");
                    System.exit(-1);
                }
            }else{
               nome1 = a[0].replace("<","").toString();
               stack.push(new Elemento(nome1));
               Elemento tag = new Elemento(nome1);
               if(stack.size() > 1){
                   Elemento parent = stack.pop();
                   tag.addParent(stack.peek());
                   stack.push(parent);
                   elementi.add(tag);
                   System.out.println(Documento.indentazione(stack.size()-1)+tag.getNome());
               }else{
                   elementi.add(tag);
                   System.out.println(Documento.indentazione(stack.size()-1)+tag.getNome());
               }
            }
        }else if(a.length == 2){
            nome1 = a[0].replace("<","");
            if(a[1].contains("/")){
                nome2 = a[1].substring(a[1].indexOf("<")+2, a[1].length());
                text = a[1].substring(0, a[1].indexOf("<"));

                Elemento tag1 = new Elemento(nome1);
                tag1.addParent(stack.peek());
                tag1.addTexts(text);
                stack.push(tag1);
                System.out.println(Documento.indentazione(stack.size()-1)+tag1.getNome() +" : " + tag1.getTexts().toString());
                elementi.add(tag1);

                Elemento tag2 = new Elemento(nome2);

                if(isPair(tag1, tag2)){
                    stack.pop();
                }else{
                    System.out.println("Alert! C'è errore nel file .XML");
                    System.exit(-1);
                }
            }
        }

        if(i<rows.size()-1){
            ricorsione(rows, elementi, stack,++i, new Elemento(nome1));
        }

        if(!stack.isEmpty()){
            System.out.println("Alert! C'è errore nel file .XML");
            System.exit(-1);
        }
    }

    public static boolean isPair(Elemento e1, Elemento e2){
        if(e1.getNome().equals(e2.getNome())){
            return true;
        }else{
            return false;
        }
    }
}
