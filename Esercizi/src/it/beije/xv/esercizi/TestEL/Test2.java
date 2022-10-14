package it.beije.xv.esercizi.TestEL;



class A{
    public void m1() {
        System.out.println("Class A");
    }
}
class B extends A{
    public void m1() {
        System.out.println("Class B");
    }
}
class C extends B{
    public void m1(){
      /*  //1
      ... lot of code.
      */

    }
}

class T {
    public static void main(String[] args){

    }
}
//class Baap {
//    public int h = 4;
//
//    public int getH() {
//        System.out.println("Baap " + h);
//        return h;
//    }
//}
//
//class Beta extends Baap {
//    public int h = 44;
//
//    public int getH() {
//        System.out.println("Beta " + h);
//        return h;
//    }
//
//    public static void main(String[] args) {
//        Baap b = new Beta();
//        System.out.println(b.h + " " + b.getH());
//        Beta bb = (Beta) b;
//        System.out.println(bb.h + " " + bb.getH());
//    }
//}

//interface Movable {
//    int location = 0;
//
//    void move(int by);
//
//    public void moveBack(int by);
//}
//
//class Donkey implements Movable {
//    int location = 200;
//
//    public void move(int by) {
//        location = location + by;
//    }
//
//    public void moveBack(int by) {
//        location = location - by;
//    }
//}
//
//class TestC {
//    public static void main(String[] args) {
//        Movable m = new Donkey();
//        m.move(10);
//        m.moveBack(20);
//        System.out.println(m.location);
//    }
//}