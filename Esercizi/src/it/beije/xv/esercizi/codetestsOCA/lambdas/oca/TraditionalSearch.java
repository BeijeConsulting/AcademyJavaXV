package lambdas.oca;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class TraditionalSearch {

    public static void main(String[] args){
        /*
        Animal shark = new Animal("shark", false, true );
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true ));
        animals.add(new Animal("kangarooo", true, false ));
        animals.add(new Animal("rabbit", true, false ));
        animals.add(new Animal("turtle", false, true ));


        print("stradr" , a -> a.startsWith("str"));

        //        print(animals, a-> a.canHop());
        */


        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);

        bunnies.removeIf( a -> !a.startsWith("h"));
        System.out.println(bunnies);
    }

    private static void print(List<Animal> animals, Predicate<Animal> checker){
        for( Animal animal: animals ){
            if( checker.test(animal )){
                System.out.println(animal + " ");
            }
            System.out.println();
        }
    }

    private static void print(String str, Predicate<String>  strCheck){
        System.out.println( "Lambda: " + strCheck.test(str) );
    }
}
