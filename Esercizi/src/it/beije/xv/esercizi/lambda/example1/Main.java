package it.beije.xv.esercizi.lambda.example1;

public class Main {
    public static void main(String[] args){


//        printThing( ()->{
//            System.out.println("Meow");
//        });

//        Printable lambdaPrintable = ()-> System.out.println("Meow");
//        printThing(lambdaPrintable);


//        Printable2 lambdaPrintable2 = (a)->{
//            System.out.println(a+"Meow");
//            return "woof!";
//        };


        Printable2 lambdaPrintable2 = (a) -> {return "woof";};

        printThing2(lambdaPrintable2, 2222);

    }


    static void printThing(Printable thing){
        thing.print();
    }

    static void printThing2(Printable2 thing2, Integer value){
        String ret = thing2.print(value);
        System.out.println("Actually --> " + ret);
    }
}





