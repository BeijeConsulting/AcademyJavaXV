package it.beije.hopper.xml.parser.gruppo6;

import java.util.ArrayList;

public class XMLNodeList {
	//replace with linked list?
	ArrayList<XMLnode> data = new ArrayList<>();

	public ArrayList<XMLnode> getData() {
		return data;
	}
	
	public void addData(XMLnode data) {
		this.data.add(data);
	}
	
	public int dataSize() {
		return this.data.size();
	}
	//DELETE THIS LATER
	public void setData(ArrayList<XMLnode> data) {
		this.data = data;
	}
	 
}
