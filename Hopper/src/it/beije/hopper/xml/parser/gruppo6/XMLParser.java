package it.beije.hopper.xml.parser.gruppo6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class XMLParser {
	
	
	
	
	public static void main(String[] args) {
		
		String xmlStringDocument = XMLloadFile("C:\\Users\\Michael Angelo\\eclipse-workspace\\Beija-Java\\HopperGIthub\\AcademyJavaXV\\Hopper\\src\\it\\beije\\hopper\\xml\\parser\\gruppo6\\Parser\\src\\xmlFiles\\test_parser1.xml");
	
		System.out.println(xmlStringDocument);
		XMLdocument document = XML_load(xmlStringDocument);
		
		
		System.out.println("--------- ----  ------------ ---- ----  ------------");
		XMLnode root = document.getRoot();
		System.out.println("Document root tag: " + root.getTag());
		
		System.out.println("------------- - ----  ------------- ----  ------------");
		System.out.println("Still needs to be done.");
		
		
		System.out.println("--------- ----  ------------ ---- ----  ------------");
		System.out.println("Roots children are: ");
		for( XMLnode rootChild: root.getChildren() ) {
			System.out.println("> tag: " + rootChild.getTag()  + " inner Text: " + rootChild.getInnerText() );
			
		}
		
		System.out.println("--------- ----  ------------ ---- ----  ------------");
		XMLnode rootChild = root.getChild(0);
		System.out.println("Child tag name: " + rootChild.getTag() + "\nChild parent tag: " + rootChild.getParent().getTag());
		System.out.println("Child's inner node and inner text:");
		for( XMLnode childOfChild: rootChild.getChildren() ) {
			System.out.println(" >" + childOfChild.getTag() + ": " + childOfChild.getInnerText()+"");
		}
		
		System.out.println("------ Second Child -----");
		XMLnode rootChild2 = root.getChild(1);
		System.out.println("Child tag name: " + rootChild2.getTag() + "\nChild parent tag: " + rootChild2.getParent().getTag());
		System.out.println("Child's inner node and inner text:");
		for( XMLnode childOfChild: rootChild2.getChildren() ) {
			System.out.println(" >" + childOfChild.getTag() + ": " + childOfChild.getInnerText()+"");
		}
		
		/*
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<contatti >
			<contatto attributeone="one" attributethree="three">
				<nome>Pippo</nome>
				<cognome>Pluto</cognome>
				<telefono>3331234567</telefono>
				<email>pippo@pluto.net</email>
			</contatto>
			<contatto>
				<nome>Paolino</nome>
				<cognome>Paperino</cognome>
				<telefono>00423803243423</telefono>
			</contatto>
		</contatti>
		*/
	
		
		/*
		<root>
			<inner> childOfRoot <--- root.getChild(0)
				<more>Some text!</more> childOfChildOfRoot <--- childOfRoot.getChild(0)
			</inner>
			<another>This is another node</another> <---- root.getChild(1)
		</root>
	*/
		
		
		
	}
	
	
	public static XMLdocument XML_load(String xmlText) {
		XMLdocument root = new XMLdocument();
		XMLnode currNode = null; // initially null, at first iteration we set root as currNode
		
		int i = 0;

		
		/////////////////////////
		//Main object that we will use to analyse XML string
		StringBuilder container = new StringBuilder();
		
		//NEED TO GET RID OF THE TAG AND FIND A BETTER SOLUTION!
		OUTER_LOOP: while( i< xmlText.length() ) {
			
			if( xmlText.charAt(i) == '<') {
				

				//contains some type of string that could be inner string
				if( container.length() > 0 ) {
					//if the curr node is null then there was an error in XML format
					// example: "sometext<tag>inner text</tag>"
					//that needs to be handled. (The text in front should not be there)
					
					//current node should contain the the inner text
					currNode.setInnerText(container.toString());
					
					//Reset String container
					container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
				}
				
				//End of node
				if( xmlText.charAt(i+1)=='/') {
					//add 2 to curr index --> we end up to the
					//first character of end tag
					i += 2;
					while( xmlText.charAt(i) != '>') {
						container.append(xmlText.charAt(i));
						i++;
					}
						//Error in XML formatting
						//There was nothing before the end tag.
						// NOTEXT</endTag><newTag>MORETEXT</newTag>
						if( currNode == null ) {
							System.out.println("----------------------------");
							System.out.println("Need to add error handling - end tag at beginning");
							System.out.println("----------------------------");
							//throw new Exception("XML FORMAT ERROR");
							break OUTER_LOOP;
						}
						
						
						//we check the tag of the current node.
						//if it doesn't match the string in container
						//Then there was an issue with XML FORMATTING <Tag1> ...</differentTag1>
						//System.out.println("|" + container.toString() +"| == |" + currNode.getTag() + "|");
						//Does not work??
						if( !(container.toString()).equals(currNode.getTag())) {
							System.out.println("---------------------------- ----------- ---- ");
							System.out.println("Need to add error handling - mismatched tag");
							System.out.println("---------------------------- -------");
							//throw new Exception("XML FORMAT ERROR");
							break OUTER_LOOP;
						}
						
						//if statement above does not apply, we found the end tag,
						//and both tags match.
						//we then set the current nodes to the parent of the current node
						currNode = currNode.getParent();
						i++; 
						continue;
					
				}
				
				// Set curr node
				if( currNode == null) {
					currNode = new XMLnode(root.getRoot());
					//root.getRoot() returns null. This is bc root does not have a parent
					root.setRoot(currNode);
				}else {
					currNode = new XMLnode(currNode);
					//The current node we are working on is now the parent of the new node,
					//which is going to be the node we are now working on
					
				}
				
				
				//get tag name (beginning of the tag with no attr)
				i++;
				//XMLAttribute curr_xmlAttr = null;//attribute currently analysing
				XMLAttribute curr_xmlAttr = new XMLAttribute();
				while( xmlText.charAt(i) != '>') {//start Tag loop
					container.append(xmlText.charAt(i));
					i++;
					
					//TAG NAME
					//if char at i is ' ' and no tag is set on, we found the tag
					// and we can set it
					if( xmlText.charAt(i)==' ' && currNode.getTag()==null) {
						//<root key="value"
						currNode.setTag(container.toString());
						//Reset String container
						container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
						i++;
						continue;
					}
					
					//if previous character analysed was ' '.
					//(we came from codeblock with TAG NAME)
					if( xmlText.charAt(i-1) == ' ') {
						//remove space from container(?)??????
						continue;
					}
					
					//Attribute key (key="value")
					//(extracts 'key')
					if(xmlText.charAt(i)=='=') {
						//if we found '=' then we can work on a property
						//and we found a key.
						
						//Set property key
						curr_xmlAttr.setKey(container.toString());
						
						
						//Reset String container
						container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
						
						continue;
					}
					
					//Attribute value (key="value")
					//(extract 'value')
					//Beginning of attribute value. 
					if(xmlText.charAt(i)=='"') {
						
						//XML FORMAT ERROR--> quotes are in a wrong position
						//example: ""value", value"
						//or value has no key
						if(curr_xmlAttr.getKey()==null) {
							System.out.println("----------------------------");
							System.out.println("Need to add error handling - attribute  value error: quotes are in a wrong position.");
							System.out.println("Need to add error handling - value has no key.");
							System.out.println("----------------------------");
							//throw new Exception("XML FORMAT ERROR");
							break OUTER_LOOP;
						}
						
						//Reset String container
						container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
						
						//we can start to analyse the value between the quotes
						i++;
						
						while( xmlText.charAt(i) != '"') {
							container.append(xmlText.charAt(i));
							i++;
						}
						//Attribute value extracted 
						//"value"
						curr_xmlAttr.setValue(container.toString());
						
						//Add to current analysing node new attribute key, value pair just found
						currNode.addXMLAttribute(curr_xmlAttr);
						
						
						//Reset String container
						container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
						
						//reset current attribute being analysing. (all fields are null)
						curr_xmlAttr = new XMLAttribute();
						
						i++;
						continue;
					}
					
					
					
					
				}
				
				
				

				
				/*
				// we want to exclude from the string '<' that is why we use left_idx+1
				currNode.setTag(container.toString());// The tag of the curr node is between '<' and '>'
				*/
				if( currNode.getTag()==null) {
					currNode.setTag(container.toString());
				}
				
				//Reset String container
				container = new StringBuilder();//Clearing Stringbuilder. Need to find a better way to deal with this
				i++; /////
				continue;////
				
			}else {
				//Inner text. (<>Inner Text</>
				container.append(xmlText.charAt(i));
				i++;
			}
		}
		
		
		
		return root;
	}
	
	

	//Reads a file path and returns its contents as a String.
	public static String XMLloadFile(String path) {
		File file = new File(path);
		
		StringBuilder fileToString = new StringBuilder("");
		
		System.out.println("file exists? " + file.exists());
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(file);
		
		
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while( bufferedReader.ready() ) {
				String line = bufferedReader.readLine();
				if( !(line.subSequence(0, 2).equals("<?")) ) {
					fileToString.append(line);
				}
					
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally{
			try {
				fileReader.close();
			}catch(IOException ioeInner) {
				ioeInner.printStackTrace();
			}
		}
			
		return sanitizeString(fileToString.toString());
	}
	
	
	/*
	
	//Given <name>Value</name> --> returns name
	public static String getTagName(String test){
		Pattern pattern = Pattern.compile("<([^\\/>]+)[\\/]*>");
		Matcher matcher = pattern.matcher(test);
		if( matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println("Group count: " + matcher.groupCount());
			return matcher.group(1);
		}
		return null;
	}
	*/
	//////////////////Utilities/////////////////
	//Cleans string from any whitespace character
	public static String sanitizeString(String string) {
		return string.replaceAll("[\\t\\n\\r]+","");
	}

}