package it.beije.xv.esercizi.upcastvsdowncast;

public class Dog extends  Animal{

    @Override
    public void makeNoise(){
        System.out.println("Woof Woof");
    }

    public void growl(){
        System.out.println("Grrrr");
    }
}
