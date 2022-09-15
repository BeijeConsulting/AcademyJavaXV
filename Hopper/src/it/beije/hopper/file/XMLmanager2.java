package it.beije.hopper.file;
/*
<?xml version="1.0" encoding="UTF-8"?>
<rubrica>
    <contatto eta="30">
		<nome>Mario</nome>
		<cognome>Rossi</cognome>
		<telefono>3337658390</telefono>
		<email>mario.rossi@tim.it</email>
		<note>compagno di squadra</note>
	</contatto>
	<contatto eta="35">
		<nome>Claudio</nome>
		<cognome>Bianchi</cognome>
		<telefono>3352672537</telefono>
		<email>claudio.white@virgilio.it</email>
	</contatto>
</rubrica>
*/

import java.io.File;
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

import it.beije.hopper.Contatto;


public class XMLmanager2 {

	static List<Contatto> contatti = new ArrayList<Contatto>();

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}


	public static List<Contatto> readRubricaXML(String path) {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(path);
			
			Element element = document.getDocumentElement();
			System.out.println("DocumentElement : " + element.getNodeName());

			NodeList nodeList = element.getChildNodes();
			System.out.println("tot nodi : " + nodeList.getLength());
			List<Element> elements = new ArrayList<Element>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				//System.out.println(nodeList.item(i).getNodeName() + " instanceof Element? " + (nodeList.item(i) instanceof Element));
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
				contatto.setNote(tags.getLength() > 0 ? tags.item(0).getTextContent() : null);
				
				System.out.println("COGNOME : " + contatto.getCognome());
				System.out.println("NOME : " + contatto.getNome());
				System.out.println("TELEFONO : " + contatto.getTelefono());
				System.out.println("EMAIL : " + contatto.getEmail());
				System.out.println("NOTE : " + contatto.getNote());
				
				contatti.add(contatto);
			}
			
		} catch (ParserConfigurationException | IOException | SAXException pcEx) {
			pcEx.printStackTrace();
		}

		return contatti;
	}
	
	public static void writeXML(String path) throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();

		Element element = doc.createElement("contatti");
		doc.appendChild(element);//root element
		for(Contatto contatto: contatti)
		{
			Element element1 = doc.createElement("contatto");
			element1.setAttribute("eta", "25");
			
			Element cognome = doc.createElement("cognome");
			cognome.setTextContent(contatto.getCognome());//<cognome>Marrone</cognome>
			element1.appendChild(cognome);
	
			Element nome = doc.createElement("nome");
			nome.setTextContent(contatto.getNome());//<nome>Emma</nome>
			element1.appendChild(nome);
	
			Element telefono = doc.createElement("telefono");
			telefono.setTextContent(contatto.getTelefono());
			element1.appendChild(telefono);
	
			Element email = doc.createElement("email");
			email.setTextContent(contatto.getEmail());
			element1.appendChild(email);
	
			Element note = doc.createElement("note");
			note.setTextContent(contatto.getNote());
			element1.appendChild(note);
			
			element.appendChild(element1);
		}
		System.out.println("contatti : " + element.getElementsByTagName("contatto").getLength());
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(path));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);

		//System.out.println("File saved!");	

	}

	public static void main(String[] args) throws Exception {
		
		//readRubricaXML("/temp/rubrica.xml");
		writeXML("/temp/new_rubrica.xml");
		
	}

}
