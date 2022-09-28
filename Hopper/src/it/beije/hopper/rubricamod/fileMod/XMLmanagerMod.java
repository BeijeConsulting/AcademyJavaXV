package it.beije.hopper.rubricamod.fileMod;

import it.beije.hopper.Contatto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLmanagerMod {

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}


	public static List<Contatto> readRubricaXML(String path) {

		List<Contatto> contatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(path);
			
			Element element = document.getDocumentElement();
			System.out.println("DocumentElement : " + element.getNodeName());
			
//			NodeList contatti = element.getElementsByTagName("contatto");
//			System.out.println("num contatti : " + contatti.getLength());

			NodeList nodeList = element.getChildNodes();
			System.out.println("tot nodi : " + nodeList.getLength());
			List<Element> elements = getChildElements(element);


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
				
//				System.out.println("COGNOME : " + contatto.getCognome());
//				System.out.println("NOME : " + contatto.getNome());
//				System.out.println("TELEFONO : " + contatto.getTelefono());
//				System.out.println("EMAIL : " + contatto.getEmail());
//				System.out.println("NOTE : " + contatto.getNote());
//				System.out.println();
				
				contatti.add(contatto);
			}
			
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		
		return contatti;
	}
	
	public static void writeXML(String path, ArrayList<Contatto> contattiList ) throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();

		Element contatti = doc.createElement("contatti");
		doc.appendChild(contatti);//root element

		for( Contatto cont : contattiList ){
			Element contatto = doc.createElement("contatto");
			//contatto.setAttribute("eta", "25");
			//contatto.setAttribute("eta", cont.getCognome());

			Element cognome = doc.createElement("cognome");
			//cognome.setTextContent("Marrone");//<cognome>Marrone</cognome>
			cognome.setTextContent(cont.getCognome());
			contatto.appendChild(cognome);

			Element nome = doc.createElement("nome");
			//nome.setTextContent("Emma");//<nome>Emma</nome>
			nome.setTextContent(cont.getNome());
			contatto.appendChild(nome);

			Element telefono = doc.createElement("telefono");
			//telefono.setTextContent("432423");
			telefono.setTextContent(cont.getTelefono());
			contatto.appendChild(telefono);

			Element email = doc.createElement("email");
			//email.setTextContent("emma@marrone.it");
			email.setTextContent(cont.getEmail());
			contatto.appendChild(email);

			Element note = doc.createElement("note");
			//note.setTextContent("la nota cantante");
			note.setTextContent(cont.getNote());
			contatto.appendChild(note);

			contatti.appendChild(contatto);
		}




		System.out.println("contatti : " + contatti.getElementsByTagName("contatto").getLength());
		
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
		String pathToXml = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\xml\\test_parser.xml";
		ArrayList<Contatto> contatti = (ArrayList<Contatto>) readRubricaXML(pathToXml);
		String outputPath = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\output\\testouput.xml";
		writeXML(outputPath, contatti);
		
	}

}
