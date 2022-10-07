package ecommerceMod.functionality;

import java.util.Scanner;

public class Store {
    private Scanner scanner;

    public Store(Scanner scanner){
        this.scanner = scanner;
    }



    public void start(){

        System.out.println("Ecommerce Jpa...");
        System.out.println("New user? ('yes' or 'no')");
        if(scanner.nextLine().equalsIgnoreCase("yes")){
            //Insert new user..
        }else{
            //Extract Existing user and use that user
        }
    }




}
