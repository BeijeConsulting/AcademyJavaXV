package it.beije.hopper.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.hopper.Contatto;

public class TestRubrica {

	public static void main(String[] args) throws IOException {
Scanner scanner = new Scanner(System.in);
System.out.println("Cosa vuoi fare? 0 - cerca contatto");
WriteRubrica writeRubrica = new WriteRubrica();
String path = "/test/rubrica.csv";
String sep = ";";
List<Contatto> contatti = new ArrayList<Contatto>();

String scelta= scanner.nextLine();
switch (scelta) {
case "0": {
	
	
}
default:
	throw new IllegalArgumentException("Unexpected value: " + scelta);
}


	}

}
