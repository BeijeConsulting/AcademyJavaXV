package parser.items;

import java.util.ArrayList;

public class XMLnode {
	private String tag;
	private String innerText;
	private XMLnode parent;
	private ArrayList<XMLAttribute> xmlAttributeList = new ArrayList<>();
	private XMLNodeList children = new XMLNodeList();
	
	
	
	
	public XMLnode() {
		
	}
	
	public XMLnode( XMLnode parent ) {
		this.parent = parent;
		if( parent != null) {//if parent exists
			// New node is instantiated
			// parent is passed as an external object ref.s
			// parent is set as parent of the new instantiated nodes
			// new instantiated node (this) is added to the children of the newly added parent node
			this.parent.addChildtoParent(this);
			
		}
		
	}

	
	public ArrayList<XMLAttribute> getAttributes(){
		return this.xmlAttributeList;
	}

	public String getAttribute(String attribute) {
		for( XMLAttribute attr: xmlAttributeList) {
			if( attr.getKey().equals(attribute) ) {
				return attr.getValue();
			}
		}
		
		return null;
	}
	
	public ArrayList<XMLnode> getChildren() {
		return children.getData();
	}
	
	public XMLnode getChild(int index) {
		//list of xml children
		ArrayList<XMLnode> childrenNodes = children.getData(); // replace with getChildren() 
		return childrenNodes.get(index);
	}

	public void addChildtoParent(XMLnode child) {
		this.children.addData(child);
	}




	public ArrayList<XMLAttribute> getXmlAttributeList() {
		return xmlAttributeList;
	}

	public void addXMLAttribute(XMLAttribute attribute) {
		this.xmlAttributeList.add(attribute);
	}
	/*
	public void setXmlAttributeList(ArrayList<XMLAttribute> xmlAttributeList) {
		this.xmlAttributeList = xmlAttributeList;
	}
	*/

	public XMLnode getParent() {
		return parent;
	}


	public void setParent(XMLnode parent) {
		this.parent = parent;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getInnerText() {
		return innerText;
	}


	public void setInnerText(String innerText) {
		this.innerText = innerText;
	}
	
	
	
}
