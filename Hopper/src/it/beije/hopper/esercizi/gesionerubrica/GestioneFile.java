package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GestioneFile {
	
	//Gestione Rubrica FILE XML
	public static List<Contatto> importFromXML() {

		String path = "ExportRubrica.xml";
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		List<Contatto> contatti = new ArrayList<>();
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(path);

			Element element = document.getDocumentElement();

			NodeList nodeList = element.getChildNodes();

			List<Element> elements = new ArrayList<Element>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				if (nodeList.item(i) instanceof Element) {
					elements.add((Element)nodeList.item(i));
				}
			}

			Contatto contatto = null;
			NodeList tags = null;
			for (Element el : elements) {
				contatto = new Contatto();
				tags = el.getElementsByTagName("cognome");
				contatto.setCognome(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);

				tags = el.getElementsByTagName("nome");
				contatto.setNome(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);

				tags = el.getElementsByTagName("telefono");
				contatto.setTelefono(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);

				tags = el.getElementsByTagName("email");
				contatto.setEmail(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);
				
				tags = el.getElementsByTagName("note");
				contatto.setEmail(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);
				
				contatti.add(contatto);
			}

			System.out.println("Rubrica caricata correttamente da file XML.");

		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		
		return contatti;

	}

	public  static void exportFromXML(List<Contatto> contatti) throws Exception {
		String path = "ExportRubrica.xml";
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		Document doc = documentBuilder.newDocument();

		
		
		Element contattiEl = doc.createElement("contatti");
		doc.appendChild(contattiEl);//root element
		
		for(Contatto contatto : contatti) {
			Element contattoEl = doc.createElement("contatto");
			contattiEl.appendChild(contattoEl);
			
			Element cognome = doc.createElement("cognome");
			cognome.setTextContent( contatto.getCognome() );//<cognome>Marrone</cognome>
			contattoEl.appendChild(cognome);
			
			Element nome = doc.createElement("nome");
			nome.setTextContent( contatto.getNome() );//<cognome>Marrone</cognome>
			contattoEl.appendChild(nome);
			
			Element telefono = doc.createElement("telefono");
			telefono.setTextContent( contatto.getTelefono() );//<cognome>Marrone</cognome>
			contattoEl.appendChild(telefono);
			
			Element email = doc.createElement("email");
			email.setTextContent( contatto.getEmail() );//<cognome>Marrone</cognome>
			contattoEl.appendChild(email);
			
			Element note = doc.createElement("note");
			note.setTextContent( contatto.getNote() );//<cognome>Marrone</cognome>
			contattoEl.appendChild(note);
		}
		

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(path));

		transformer.transform(source, result);

		System.out.println("Esportazione eseguita con successo!");	

	}
	
	
	//Gestione Rubrica FILE CVS
	public static List<Contatto> importFromCSV() {
		String path = "ExportRubrica.csv";
		
		File file = new File(path);
		FileReader fileReader = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			List<String> rows = new ArrayList<String>();
			while (bufferedReader.ready()) {
				rows.add(bufferedReader.readLine());
			}
			
			Contatto contatto = null;
			for (String row : rows) {

				String[] cols = row.split(";");
				
				contatto = new Contatto();
				contatto.setCognome(cols[0]);
				contatto.setNome(cols[1]);	
				contatto.setTelefono(cols[2]);
				contatto.setEmail(cols[3]);
				contatto.setNote(cols[4]);		
		
				contatti.add(contatto);
				
			}
			
			System.out.println("Rubrica caricata correttamente da file CSV");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException inner) {
				inner.printStackTrace();
			}
		}
		return contatti;
	}
	
	public static void exportFromCSV(List<Contatto> contatti) throws IOException {
		String path = "ExportRubrica.csv";
		
		FileWriter fileWriter = new FileWriter(path);
		
		char sep = ';';
		for (Contatto contatto : contatti) {
			
			//fileWriter.write(contatto.getCognome());
			fileWriter.write(contatto.getCognome() != null ? contatto.getCognome() : ""); 	
			fileWriter.write(sep);
			
			fileWriter.write(contatto.getNome() != null ? contatto.getNome() : "");
			fileWriter.write(sep);
			
			fileWriter.write(contatto.getTelefono() != null ? contatto.getTelefono() : "");
			fileWriter.write(sep);
			
			fileWriter.write(contatto.getEmail() != null ? contatto.getEmail() : "");
			fileWriter.write(sep);
			
			fileWriter.write(contatto.getNote() != null ? contatto.getNote() : "null");
			fileWriter.write('\n');
		}

		fileWriter.flush();
		fileWriter.close();
		System.out.println("Esportazione eseguita con successo!");
	}

	
	

}
