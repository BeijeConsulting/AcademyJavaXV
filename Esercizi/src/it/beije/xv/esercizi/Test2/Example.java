package it.beije.xv.esercizi.Test2;

//public class Example {
//
//    public static void main(String[] args) {
//
//        System.out.println( Boolean.valueOf(true) instanceof Boolean);
//        System.out.println( Boolean.valueOf("trUE") instanceof Boolean);
//        System.out.println( Boolean.TRUE instanceof Boolean);
//    }
//
//}

//class Car{
//    public int gearRatio = 8;
//    public String accelerate() {  return "Accelerate : Car";  }
//}
//class SportsCar extends Car{
//    public int gearRatio = 9;
//    public String accelerate() {  return  "Accelerate : SportsCar";  }
//    public static void main(String[] args){
//        Car c = new SportsCar();
//        System.out.println( c.gearRatio+"  "+c.accelerate() );
//    }
//}

//class Ex {
//    public static void main(String[] args) {
//
//        int a = 10;
//        int b = 20;
//        a += (a = 4);
//        b = b + (b = 5);
//        System.out.println(a + ",  " + b);
//
//    }
//}

//class T{
//    public void method(){
//        System.out.println("Object Version");
//    }
//    public void method(Object o){
//        System.out.println("Object Version");
//    }
//    public void method(java.io.FileNotFoundException s){
//        System.out.println("java.io.FileNotFoundException Version");
//    }
//    public void method(java.io.IOException s){
//        System.out.println("IOException Version");
//    }
//    public static void main(String args[]){
//        TestClass tc = new TestClass();
//        tc.method(null);
//    }
//}

//class ArrayTest {
//    public static void main(String[] args) {
//        int ia[][] = {{1, 2}, null};
//        for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) System.out.println(ia[i][j]);
//    }
//}

//class ScopeTest {
//    static int x = 5;
//
//    public static void main(String[] args) {
//
//        System.out.println(("hello" + new String("world")));
//        System.out.println("hello".concat(" world"));
//        System.out.println(new StringBuilder("world").insert(0, "hello ").toString());
////        System.out.println(new StringBuilder("world").append(0, "hello ").toString());
//        System.out.println(new StringBuilder("world").append("hello ", 0 , 6).toString());
////        System.out.println(new StringBuilder("world").add(0, "hello ").toString());
//
//
//    }
//}

//class E1 extends Exception {
//}
//
//class E2 extends E1 {
//}
//
//class Test {
//    public static void main(String[] args) {
//        try {
//            throw new E2();
//        } catch (E1 e) {
//            System.out.println("E1");
//        } catch (Exception e) {
//            System.out.println("E");
//        } finally {
//            System.out.println("Finally");
//        }
//    }
//}


//
//interface MyIface{};
//class A {};
//class B extends A implements MyIface{};
//class C implements MyIface{};
//
//class Tt {
//    public static void main(String[] args){
//        A a = new A();
//        B b = new B();
//        C c = new C();
//
////        b = c;
////        c = b;
////        MyIface i = c;
////        c = (C) b;
////        b = a;
//    }
//}


//
//
//class DateTest {
//    static String j = "";
//
//    public static void method(int i) {
//        try {
//            if (i == 2) {
//                throw new Exception();
//            }
//            j += "1";
//        } catch (Exception e) {
//            j += "2";
//            return;
//        } finally {
//            j += "3";
//        }
//        j += "4";
//    }
//
//    public static void main(String args[]) {
//        method(1);
//        method(2);
//        System.out.println(j);
//    }
//}


//class TestaA {
//    public static void main(String[] args) {
//
////        System.out.println(null + true); //1
////        System.out.println(true + null); //2
////        System.out.println(null + null); //3
//    }
//}

//class Base {
//    void method1() throws java.io.IOException, NullPointerException {
//        someMethod("arguments");       // some I/O operations
//    }
//
//    int someMethod(String str) {
//        if (str == null) throw new NullPointerException();
//        else return str.length();
//    }
//}
//
//class NewBase extends Base {
//    void method1() {
//        someMethod("args");
//    }
//}


//class FinallyTest {
//    public static void main(String args[]) {
//        try {
//            if (args.length == 0) return;
//            else throw new Exception("Some Exception");
//        } catch (Exception e) {
//            System.out.println("Exception in Main");
//        } finally {
//            System.out.println("The end");
//        }
//    }
//}


//class TestClass {
//    public static void main(String[] args) throws Exception {
////        new StringBuilder("aio'")
//        int k = 1;
//        int[] a = {1};
//        System.out.println((k = 4) * (k + 2));
//        k = k + (k = 4) * (k + 2);
//        a[0] += (a[0] = 4) * (a[0] + 2);
//        System.out.println(k + " , " + a[0]);
//
//    }
//
//}
//class BreakTest{
//    public static void main(String[] args){
//        int i = 0, j = 5;
//        lab1 : for( ; ; i++){
//            for( ; ; --j)  if( i >j ) break lab1;
//        }
//        System.out.println(" i = "+i+", j = "+j);
//    }
//}
//
//class Triangle{
//    public int base;
//    public int height;
//    private final double ANGLE;
//
//    public  void setAngle(double a){  ANGLE = a;  }
//
//    public static void main(String[] args) {
//        Triangle t = new Triangle();
//        t.setAngle(90);
//    }
//}
//class Sample{
//    public static void main(String[] args)  {
//        String s1 = new String("java");
//        StringBuilder s2 = new StringBuilder("java");
//        replaceString(s1);
//        replaceStringBuilder(s2);
//        System.out.println(s1 + s2);
//    }
//    static void replaceString(String s) {
//        s = s.replace('j', 'l');
//    }
//    static void replaceStringBuilder(StringBuilder s) {
//        s.append("c");
//    }
//}
//class TestClass{
//    public static void main(String args[]){
//        int i = 0;
//        loop :         // 1
//        {
//            System.out.println("Loop Lable line");
//            try{
//                for (  ;  true ;  i++ ){
//                    if( i >5) break loop;       // 2
//                }
//            }
//            catch(Exception e){
//                System.out.println("Exception in loop.");
//            }
//            finally{
//                System.out.println("In Finally");      // 3
//            }
//        }
//    }
//}

class Super{
    static{ System.out.print("super "); }
}
class One{
    static {  System.out.print("one "); }
}
class Two extends Super{
    static {  System.out.print("two "); }
}
class Test{
    public static void main(String[] args){
        One o = null;
        Two t = new Two();
    }
}