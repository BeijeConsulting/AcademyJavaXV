package it.beije.xv.esercizi.TestEL;

class T{
    public  String eat(){
        return "[T eats]";
    }
    public void startEating(){
        //System.out.println("Started Eating..." + this.eat());
        System.out.println("Started Eating..." + eat());

    }
}

class eT extends T{
    public String eat(){
        return super.eat(); //"[Tssss eats]";
    }
    public static void main(String[] args){
        T t = new eT();
        t.startEating();

    }
}


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
