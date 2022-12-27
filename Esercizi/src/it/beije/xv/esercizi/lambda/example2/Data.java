package it.beije.xv.esercizi.lambda.example2;

import java.util.ArrayList;

public class Data {
    int value;
    Data(int value){
        this.value = value;
    }


    public static void processList(ArrayList<Data> dataList, Process p){
        for( Data d: dataList){
            p.process(d.value, d.value);
        }
    }


    public static void main(String[] args){
        ArrayList<Data> a1 = new ArrayList<Data>();
        a1.add(new Data(1));
        a1.add(new Data(2));
        a1.add(new Data(3));

        processList(a1, (int a, int b)-> System.out.println(a*b));
//        processList(a1, (a,b)-> System.out.println(a*b));

    }

}
