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

//class Super{
//    static{ System.out.print("super "); }
//}
//class One{
//    static {  System.out.print("one "); }
//}
//class Two extends One{
//    static {  System.out.print("two "); }
//}
//class Test{
//    public static void main(String[] args){
////        One o = null;
////        Two t = new Two();
//
////        Two two = (Two)new One();
//        One one = (One)new Two();
//        Two two = (Two)one;
//s
//
//    }
//}

//class TestClass {
//    public static void main(String[] args) {
//        int i = 0;
//        loop:         // 1
//
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
//
//    }
//}
//class Wrapper{
//    int w = 10;
//}
//
//class TestClass{
//
//    static Wrapper changeWrapper(Wrapper w){
//        w = new Wrapper();
//        w.w += 9;
//        return w;
//    }
//
//
//
////    public long methodX( byte by){
////        double d = 10.0;
////        return (long) by/d*3;
////    }
//
//    public static void main(String[] args){
//        byte b = 2;
//        double d = 31.2;
//        long d2 = (long) ( d/b);
//        System.out.println();
//    }
//}

//class DatabaseWrapper {
//    static String url = "jdbc://derby://localhost:1527//mydb";
//
//    static DatabaseWrapper getDatabase() {
//        System.out.println("Getting DB");
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getDatabase().url);
//    }
//}

//class TestClass{
//    public static void main(String[] args){
//        new TestClass().sayHello(); }   //1
//
//    public static void sayHello(){
//        System.out.println("Static Hello World"); }  //2
//
//    public void sayHello() { System.out.println("Hello World "); }  //3
//}

//class InitTest{
//    public InitTest(){
//        s1 = sM1("1");
//    }
//    static String s1 = sM1("a");
//    String s3 = sM1("2");{
//        s1 = sM1("3");
//    }
//    static{
//        s1 = sM1("b");
//        System.out.println("Fanculo!");
//    }
//    static String s2 = sM1("c");
//    String s4 = sM1("4");
//    public static void main(String args[]){
//        InitTest it = new InitTest();
//    }
//    private static String sM1(String s){
//        System.out.println(s);  return s;
//    }
//}


//class TestClass{
//    char c;
//    public void m1(){
//        char[ ] cA = { 'a' , 'b'};
//        m2(c, cA);
//        System.out.println( ( (int)c)  + "," + cA[1] );
//    }
//    public void m2(char c, char[ ] cA){
//        c = 'b';
//        cA[1] = cA[0] = 'm';
//    }
//    public static void main(String args[]){
//        new TestClass().m1();
//    }
//}


//class TestClass {
//    static TestClass ref;
//    String[] arguments;
//
//
//    public void tester(int a){
//        System.out.println("Awoos");
//    }
////    public void tester(int a){
////        System.out.println("Awoos222");
////    }
//    public static void main(String args[]) {
//        ref = new TestClass();
//        ref.func(args);
//    }
//
//    public void func(String[] args) {
//        ref.arguments = args;
//    }
//}

//class XXX {
//    public void m() throws Exception {
//        throw new Exception();
//    }
//}
//
//class YYY extends XXX {
//    public void m() {
//    }
//    public int m(int a){
//        return 1;
//    }
//
//    public static void main(String[] args) {
//        XXX obj = new YYY();
//        try{
//            obj.m();
//        }catch(Exception exc){
//            System.out.println("sssss");
//        }
//
//    }
//}


//class Holder{
//    int value = 1;
//    Holder link;
//    public Holder(int val){ this.value = val; }
//    public static void main(String[] args){
//        final Holder a = new Holder(5);
//        Holder b = new Holder(10);
//        a.link = b;
//        b.link = setIt(a, b);
//        System.out.println(a.link.value+" "+b.link.value);
//    }
//
//    public static Holder setIt(final Holder x, final Holder y){
//        x.link = y.link;
//        return x;
//    }
//
//}

abstract class A {

    public abstract void yo();

    public abstract void yo2();

    public void yo3(){
        System.out.println("Yo 3");
    }

}

abstract class  AA extends A {
    public abstract void yo4();
}
class B extends AA{
//    public static void yo(){
//        System.out.println("Wazzup 2");
//    }

    public void yo(){
        System.out.println("Wazzup");
    }

    @Override
    public void yo2() {

    }
    @Override
    public void yo4() {

    }
    public static void main(String[] args){
       new B().yo3();
    }


}