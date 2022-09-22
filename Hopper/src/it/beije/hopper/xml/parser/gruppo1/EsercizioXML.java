

/*

Il parser dovrà leggere e "costruire" in memoria l'alberatura del file XML partendo da un metodo

public static VostroOggettoDocumento parse(String file) {...}

che restituirà appunto un VostroOggettoDocumento (nome che deciderete voi).

I metodi da implementare sono:

getRootElement() //torna l'elemento root
getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
getTagName() //torna il nome del tag
getTextContent() //torna il contenuto del tag
getAttributes() //torna l'elenco degli attributi dell'elemento
getAttribute(String attribute) //torna il valore dell'attributo specificato
*/


package it.beije.hopper.xml.parser.gruppo1;

import java.io.File;
import java.io.IOException;

public class EsercizioXML {
	

	
	


	public static void main(String[] args) throws IOException {
		//parse("/Users/filippobassani/Desktop//xml/test_parser1.xml");
		File file = new File("/Users/filippobassani/Desktop/xml/test_parser1.xml");
		VostroOggettoDocumento ogg = new VostroOggettoDocumento(file);
		//ogg.getRootElement();
		//System.out.println();
		//ogg.getChildNodes();
		//System.out.println();
		//ogg.getChildElements();
		//ogg.getElementsByTagName("telefono");
		ogg.getTagName("Pluto");

	}

}
