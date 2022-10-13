package it.beije.xv.esercizi.TestEL;




class A{
    public static void main(String args[]){
        A a = new A();
        B b = new B();
        a = b;  // 1
        b = (B)a;  // 2
        a = (B) b; // 3
        b = (B) a; // 4
    }
}
class B extends A { }

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