package it.beije.hopper.xml.parser.gruppo5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLAlbero {

	
//		Il parser dovrà leggere e "costruire" in memoria l'alberatura del file XML partendo da un metodo
//
//		public static VostroOggettoDocumento parse(String file) {...}
//
//		che restituirà appunto un VostroOggettoDocumento (nome che deciderete voi).
//
//		I metodi da implementare sono:
//
//		getRootElement() //torna l'elemento root
//		getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
//		getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
//		getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
//		getTagName() //torna il nome del tag
//		getTextContent() //torna il contenuto del tag
//		getAttributes() //torna l'elenco degli attributi dell'elemento
//		getAttribute(String attribute) //torna il valore dell'attributo specificato
		
		
//		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//		<contatti>
//			<contatto>
//				<nome>Pippo</nome>
//				<cognome>Pluto</cognome>
//				<telefono>3331234567</telefono>
//				<email>pippo@pluto.net</email>
//			</contatto>
//			<contatto>
//				<nome>Paolino</nome>
//				<cognome>Paperino</cognome>
//				<telefono>00423803243423</telefono>
//			</contatto>
//		</contatti>
	
	//<domanda id="1" book="OCA Oracle Certified book Associate Java SE 8 [2014]" chapter="1" question="1">
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:\\Users\\caste\\Downloads\\test_parser6.xml");
		XMLReader albero = new XMLReader(file);
		try {									//file3 gestire errore			//file4 gestire commenti
			//albero.getRootElement();
			//albero.stampa();
			//albero.getChildNodes();
			//albero.getChildElements();
			albero.getElementsByTagName("risposteEsatte");
			//albero.getTagName();
			//albero.getTextContent();				//da fixare
			//albero.getAttributes();
			//albero.getAttribute("name");
			
			
			
//			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//			<contatti>
//				<contatto calimero="tastiera">
//					<nome>Pippo</nome>
//					<cognome>Pluto</cognome>
//					<telefono>3331234567</telefono>
//					<email>pippo@pluto.net</email>
//				</contatto>
//				<contatto>
//					<nome>Paolino</nome>
//					<cognome>Paperino</cognome>
//					<telefono>00423803243423</telefono>
//				</contatto>
//			</contatti>
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static XMLReader parse(String file) {
		return null;
			
	}

}
