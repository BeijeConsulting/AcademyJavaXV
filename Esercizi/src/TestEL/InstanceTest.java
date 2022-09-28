package TestEL;

public class InstanceTest {


    public static void main(String[] args){
        Chicken chicken = new Chicken();
        chicken.setName("George");
        System.out.println(chicken.toString());
        System.out.println("Name " + chicken.getName());
        System.out.println();
        printInstance(chicken);
        System.out.println();
        System.out.println(chicken);
        System.out.println("Name " + chicken.getName());
        System.out.println();
    }

    public static void printInstance( Chicken c ){
        System.out.println(c.getName());
        c.setName("Giovanni");
        System.out.println( c.toString());
        System.out.println(c.getName());
        c = new Chicken();
        c.setName("Alexander");

    }
}

class Chicken{
    private String name;
    public void setName(String name ){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
