package it.beije.xv.esercizi.TestEL;

class Doll{
    String name;
    Doll(String nm){
        this.name = nm;
        System.out.println("Doll consturctor");
    }
}

class Barbie extends Doll{
    Barbie(){
        //1
        //this("unkown");
        super("unkown");
        System.out.println("Barbie default constructor");
    }
    Barbie(String nm){
        //2
        super(nm);
        System.out.println("Barbie constructor");
    }
}
class TestClass {
    public static void main(String[] args) {
        Barbie b = new Barbie("mydoll");
    }
}