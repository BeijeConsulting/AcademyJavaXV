package it.beije.xv.esercizi.TestEL;



class C {
        public static void main(String[] args){
////                new C().crazyLoop();
//                double d = 2.0;
//                int i = 3;
//                boolean bool = d<i;
//                System.out.println(bool);

//
//                boolean b1 = false;
//                boolean b2  = false;
//                if (b2 = b1 == false){
//                        System.out.println("true");
//                } else{
//                        System.out.println("false");
//                }


//                String s = "blooper";
//                StringBuilder sb = new StringBuilder(s);
////                sb.append(s.substring(4)).delete(3, 5);
//                sb.substring(2);
//                System.out.println(sb);
//                Integer i = 0;
//                i++;
//                System.out.println(i);
                Double d = 0.0;
                System.out.println(--d);
        }
//        void crazyLoop(){
//                int c=0;
//                JACK:while(c< 8){
//                        JILL:System.out.println(c);
//                        if(c>3)break JACK;else c++;
//                }
//        }

}

//
//class PE extends Exception{}
//class Game{
//    public void play() throws PE{
//        System.out.println("Playing...");
//    }
//}
//
//class Soccer extends Game{
//    public void play(){
//        System.out.println("Playing Soccer...");
//    }
//    public static void main(String[] args){
//        Game g = new Soccer();
//        try{
//            g.play();
//        }catch(PE pe){
//            System.out.println(pe);
//            pe.printStackTrace();
//        }
//    }
//}


//
//class SomeThrowable extends Throwable {
//}
//
//class MyThrowable extends SomeThrowable {
//}
//
//class TestClass1 {
//    public static void main(String args[]) throws SomeThrowable {
//        try {
//            m1();
//        } catch (SomeThrowable e) {
//            throw e;
//        } finally {
//            System.out.println("Done");
//        }
//    }
//
//    public static void m1() throws MyThrowable {
//        throw new MyThrowable();
//    }
//}


//class A {
//    public int getCode(){ return 2;}
//}
//
//class AA extends A {
//    public long getCode(){ return 3;}
//}
//
//class TestClass2 {
////
////    public static void main(String[] args) throws Exception {
////        A a = new A();
////        A aa = new AA();
////        System.out.println(a.getCode()+" "+aa.getCode());
////    }
////
////    public int getCode() {
////        return 1;
////    }
//
//
////    public static void main(String[] args){
////        boolean b1 = false;
////        boolean b2  = false;
////        if (b2 = b1 != b2){
////            System.out.println("true");
////        } else{
////            System.out.println("false");
////        }
////    }
//
//
//
//}

//abstract class Ball {
//    protected final int size;
//    public Ball(int size) {
//        this.size = size;
//    }
//}
//interface Equipment {}
//class SoccerBall extends Ball implements Equipment {
//    public SoccerBall() {
//        super(5);
//    }
//    public Ball get() { return this; }
//    public static void main(String[] passes) {
//        Equipment equipment = (Equipment)new SoccerBall().get();
//        System.out.print(((SoccerBall)equipment).size);
//    }
//}
//


//abstract class Car {
//    static { System.out.print("1"); }
//    public Car(String name) {
//        super();
//        System.out.print("2");
//    }
//    { System.out.print("3"); }
//}
//class BlueCar extends Car {
//    { System.out.print("4"); }
//    public BlueCar() {
//        super("blue");
//        System.out.print("5");
//    }
//    public static void main(String[] gears) {
//        new BlueCar();
//    }
//}


//class T{
//    public  String eat(){
//        return "[T eats]";
//    }
//    public void startEating(){
//        //System.out.println("Started Eating..." + this.eat());
//        System.out.println("Started Eating..." + eat());
//
//    }
//}
//
//class eT extends T{
//    public String eat(){
//        return super.eat(); //"[Tssss eats]";
//    }
//    public static void main(String[] args){
//        T t = new eT();
//        t.startEating();
//
//    }
//}


//class T{
//    public static  void eat(){
//        System.out.println("T");
//    }
//}
//
//class eT extends T{
//    public static void eat(){
//        System.out.println("Tssss");
//    }
//    public static void main(String[] args){
//        T.eat();
//        new T().eat();
//        new eT().eat();
//    }
//}
//class B {}
//class B1 extends B {}
//class B2 extends B {}
//class ExtendsTest{
//    public static void main(String args[]){
//        B b = new B2();
//        B1 b1 = new B1();
//        B2 b2 = new B2();
//        // insert statement here
//        b2 = b;
//    }
//}


//Consider the following classes :
//interface I{
//}
//class A implements I{
//}
//
//class B extends A {
//}
//
//class C extends B{
//}
//
//class T{
//    public static void main(String[] args){
//        A a = new A();
//        B b = new B();
//        b = (B)(I)a;
//        System.out.println(a);
//        System.out.println(b);
//    }
//}
//    And the following declarations:

//        Identify options that will compile and run without error.
//import java.util.Arrays;

//class TC {
//    public static void main(String args[]) {
//        A[] a, a1;
//        B[] b;
//        a = new A[10];
//        a1 = a;
//        b = new B[20];
//        a = b;  // 1
//        b = (B[]) a;  // 2
//        //b = (B[]) a1; // 3
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//    }
//}
//
//class A {
//}
//
//class B extends A {
//}


//public class Test {
//    public static void main(String[] args) {
//        byte b = 1;
//        char c = 2;
//        short s = 3;
//        int i = 4;
//
//        s+=i;
//        System.out.println(s);
//    }
//}

//class Test{
//    public static void main(String args[]){
//        int c = 0;
//        A: for(int i = 0; i < 2; i++){
//            B: for(int j = 0; j < 2; j++){
//                C: for(int k = 0; k < 3; k++){
//                    c++;
//                    if(k>j) break;
//                }
//            }
//        }
//        System.out.println(c);
//    }
//}

//class Super{static String ID = "QBANK ";}
//
//class Sub extends Super{
//    static {
//        System.out.print("In Sub ");
//    }
//}
//
//
//class A{
//    public A(){}
//    public A(int i){
//        System.out.println(i );
//    }
//}
//
//class B{
//    static A s1 = new A(1);
//    A a = new A(2);
//    public static void main(String[] args){
//        B b = new B();
//        A a = new A(3);
//
//    }
//    static A s2 = new A(4);
//
//}

//public class Test {
//    public static void main(String[] args){
////        Super sup = null;
////        System.out.println(Sub.ID);
////        int c = 9;
////        double d = 9.01;
////        System.out.println(c == d);
//    }
//}
