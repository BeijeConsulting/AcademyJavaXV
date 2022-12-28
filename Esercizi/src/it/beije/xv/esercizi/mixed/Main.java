package it.beije.xv.esercizi.mixed;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//class Super { static String ID = "QBANK"; }
//
//class Sub extends Super{
//    static { System.out.print("In Sub"); }
//}
//class Test{
//    public static void main(String[] args){
//        System.out.println(Sub.ID);
//    }
//}


//class TestClass {
//    public static void main(String[] args) throws Exception {
//        List list = new ArrayList();
//        list.add("val1"); //1
//        list.add(2, "val2"); //2
//        list.add(1, "val3"); //3
//        System.out.println(list);
//    }
//}


//class Base{
//    public short getValue(){ return 1; } //1
//}
//class Base2 extends Base{
//    public short getValue(){ return 2; } //2
//}
//class TestClass{
//    public static void main(String[] args){
//        Base b = new Base2();
//        System.out.println(b.getValue()); //3
//    }
//}

//class A {
//    public int getCode(){ return 2;}
//}
//
//class AA extends A {
//    public long getCode(){ return 3;}
//}

class Game {
    public void play() throws Exception   {
        System.out.println("Playing...");
    }
}

class Soccer extends Game {
    public void play(String ball)    {
        System.out.println("Playing Soccer with "+ball);
    }
}

class TestClass {
    public static void main(String[] args) throws Exception  {
        Game g = new Soccer();
        System.out.println(g.getClass());
        // 1
        Soccer s = (Soccer) g;
        System.out.println(s.getClass());
        // 2
    }
}