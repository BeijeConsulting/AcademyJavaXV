package it.beije.hopper.xml.parser.gruppo6;

import java.util.ArrayList;

public class XMLdocument {
	private XMLnode root;
	
	public XMLnode getRoot() {
		return root;
	}

	public void setRoot(XMLnode root) {
		this.root = root;
	}
	
	///metodi challenge
	//DA Testare
	//torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
	public ArrayList<XMLnode> getChildElements(XMLnode parent){
		ArrayList<XMLnode> rootChildren = root.getChildren();
		return rootChildren;
	}
	
	//torna il nome del tag//
	public String getTagName(XMLnode node) {
		return node.getTag();
	}
	
	
	//torna il contenuto del tag DONE???
	public String getTextContent(XMLnode node) {
		return node.getInnerText();
	}
	
	
	
}
