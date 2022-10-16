package it.beije.xv.esercizi.TestEL;

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

class ScopeTest {
    static int x = 5;

    public static void main(String[] args) {
        int x = (x = 3) * 4;  // 1
        System.out.println(x);
    }
}