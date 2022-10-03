package it.beije.xv.esercizi.TestEL;

class TClass implements T1, T2 {
    public void m1() {
    }
    public static void main(String[] args){
        System.out.println(T1.VALUE);
        System.out.println(T2.VALUE);
    }
}

interface T1 {
    int VALUE = 1;

    void m1();
}

interface T2 {
    int VALUE = 2;

    void m1();
}

//class ForSwitch{
//    public static void main(String args[]){
//        char i;
//        LOOP: for (i=0;i<5;i++){
//            switch(i++){
//                case '0': System.out.println("A");
//                case 1: System.out.println("B"); break LOOP;
//                case 2: System.out.println("C"); break;
//                case 3: System.out.println("D"); break;
//                case 4: System.out.println("E");
//                case 'E' : System.out.println("F");
//            }
//        }
//    }
//}

//class Super { static String ID = "QBANK"; }

//class Sub extends Super{
//    static int x =2 ;
//    static { System.out.print("In Sub"); }
//}
//class Test2{
//    public static void main(String[] args){
////        System.out.println(Sub.x);
////        int y = Sub.x;
//        System.out.println(Sub.ID);
//    }
//}

//class TClass {
//
//    public static int m1(int i){
//        return ++i;
//    }
//
//    public int sum(int i1, int i2) { return i1 + i2; }
//    public long sum(long i1, int i2) { return i1 + i2; }
//    public static void main(String[] args) {
//
//        int k = m1(args.length);
//        k += 3 + ++k;
//        System.out.println(k);
//    }
//
//}

//class B {}
//class B1 extends B {}
//class B2 extends B {}
//
//class ExtendsTest{
//    public static void main(String args[]){
//        B b = new B();
//        B1 b1 = new B1();
//        B2 b2 = new B2();
//        // insert statement here
//        //b1 = (B1) b;
////        b2 = b;
////        b2 =  b;
//    }
//}
//
//class X {
//    public X() {
//        System.out.println("In X");
//    }
//}
//
//class Y extends X {
//    public Y() {
//        super();
//        System.out.println("In Y");
//    }
//}
//
//class Z extends Y {
//    public Z() {
//        System.out.println("In Z");
//    }
//}
//
//class Test2 {
//    public static void main(String[] args) {
//        Y y = new Z();
//    }
//}

//class TClass {
//    public static void main(String[] args) {
////        String str = "111";
////        boolean[] bA = new boolean[1];
////        if (bA[0]) str = "222";
////        System.out.println(str);
//
//        int count = 0, sum = 0;
//        do{
//            if(count % 3 == 0) continue;
//            sum+=count;
//        }
//        while(count++ < 11);
//        System.out.println(sum);
//
//    }
//}

//
//Consider the following method...
//public class ifTest{
//
//    public static void main(String[] args){
//        new ifTest().ifTest(true);
//    }
//
//    public void ifTest(boolean flag){
//        if (flag)   //1
//            if (flag)   //2
//                System.out.println("True False");
//            else        // 3
//                System.out.println("True True");
//        else        // 4
//            System.out.println("False False");
////    }
//}


//
//        Which of the following statements are correct ?
//


//
////    What would be the result of compiling and running the following program?
//
//class SomeClass{
//    public static void main(String args[]){
//        int size = 10;
//        int[] arr = new int[size];
//        for (int i = 0 ; i < size ; ++i) System.out.println(arr[i]);
//    }
//}

