package it.beije.xv.esercizi.upcastvsdowncast;

public class Cat extends  Animal{

    @Override
    public void makeNoise(){
        System.out.println("meow meow");
    }

    public void hiss(){
        System.out.println("hisss");
    }
}
