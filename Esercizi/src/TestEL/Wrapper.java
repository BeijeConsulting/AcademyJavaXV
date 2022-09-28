package TestEL;

public class Wrapper {
    public static void main(String[] args){
        Integer val1 = new Integer(5);
        int val2 = 9;
        System.out.println(System.identityHashCode(val1));
        System.out.println(System.identityHashCode(val1));
        val1++;
        val2++;
        System.out.println(val1 + " " + val2);
        System.out.println(System.identityHashCode(val1));
    }
}
