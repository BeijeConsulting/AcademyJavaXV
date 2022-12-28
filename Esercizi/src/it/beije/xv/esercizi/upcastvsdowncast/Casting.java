package it.beije.xv.esercizi.upcastvsdowncast;

public class Casting {
    public static void main(String[] args){
        Animal myAnimal = new Dog();

//        Dog dog = new Animal();
//        Dog dog = (Dog)new Animal(); // ClassCast Exception --> RUNTIME EXC

        ((Animal)myAnimal).makeNoise();
        doAnimalStuff( myAnimal);

        Animal myAnimal2 = new Cat();
        doAnimalStuff(myAnimal2);
    }

    public static void doAnimalStuff(Animal animal){
        System.out.println(animal.getClass());
        animal.makeNoise();

        if( animal instanceof Dog){
            System.out.println(((Dog)animal).getClass());
            Dog dog = (Dog)animal;
            System.out.println(dog.getClass());
            dog.growl();
        }

        if( animal instanceof Cat){
            ((Cat)animal).hiss()  ;
        }

    }
}
