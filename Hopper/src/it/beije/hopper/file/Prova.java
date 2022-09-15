package it.beije.hopper.file;

import it.beije.hopper.Contatto;

import java.io.*;
import java.sql.Array;
import java.util.*;


public class Prova {

    public static void main(String[] args) throws IOException {

        String path = "C:/Users/Raffaele/Desktop/Raffaele";
        File file = new File(path);
        int i = 0;
        stampaAlbero(path, i);

    }

    public static boolean containDirectory(String path){
        File file = new File(path);
        String [] contenuto = file.list();
        for (String a: contenuto) {
            File file1 = new File(path+"/" + a);
            if (file1.isDirectory()){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getFiles(String path){
        File file = new File(path);
        String [] contenuto = file.list();
        ArrayList<String> files = new ArrayList<String>();

        for (String a: contenuto) {
            File file1 = new File(path+"/" + a);
            if (!file1.isDirectory()){
                files.add(a);
            }
        }
        return files;
    }

    public static ArrayList<String> getDirs(String path){
        File file = new File(path);
        String [] contenuto = file.list();
        ArrayList<String> files = new ArrayList<String>();

        for (String a: contenuto) {
            File file1 = new File(path+"/" + a);
            if (file1.isDirectory()){
                files.add(a);
            }
        }
        return files;
    }


    public static void stampaAlbero(String path, int i){
        String ind = indentazione(i);
        if(containDirectory(path)){
            ArrayList<String> dirs = getDirs(path);
            for (String a: dirs) {
                System.out.println(ind+a+"(dir)");
                stampaAlbero(path+"/"+a, i+1);
            }
        }else{
            ArrayList<String> files = getFiles(path);
            for (String a: files) {
                System.out.println(ind+"\t"+a);
            }
        }
    }

    public static String indentazione(int i){
        String result="";
        for (int j = 0; j<i; j++){
            result += "\t";
        }
        return result;
    }

}
