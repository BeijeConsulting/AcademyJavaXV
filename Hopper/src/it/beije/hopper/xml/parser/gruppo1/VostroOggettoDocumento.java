package it.beije.hopper.xml.parser.gruppo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class VostroOggettoDocumento {

	File file;
	public VostroOggettoDocumento(File file) {
		this.file=file;
	}
	
	
	public String getRootElement() throws IOException
	{
		
	    FileReader fileReader= new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    int count = 0;
	    while (bufferedReader.ready())
	    {
	        //System.out.print((char)fileReader.read()); 
	        String linea = bufferedReader.readLine();
	        if (linea.charAt(0) == '<')
	        {
	            count++;
	            if (count == 1)
	            {
	                String line = ""; 
	                line = bufferedReader.readLine().trim();
	               
	                line = line.substring(1,line.length()-1);
	                System.out.println(line);
	            }
	        }
	    }
	   return null;
	}



	public String getChildNodes() throws IOException {
	 FileReader fileReader= new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    int count = 0;
    String line = "";
  while (bufferedReader.ready())
    {
        String linea = bufferedReader.readLine();
          if (linea.charAt(0) == '<' || linea.charAt(1) == '<' )
        {
           count++;
        
             while (count >= 2 && count < 9) {    
                 count++;             
                 line = bufferedReader.readLine().trim();
    
                 line = line.substring(1,line.indexOf('>'));
                 
                 if (line.charAt(0) != '/'  )
                 {
                 System.out.println(line);
                 }else {
                	 break;              	
                 }         
             }
            
           }
         
        } 
   return null;    
	}

	
	public String getChildElements() throws IOException {
		 FileReader fileReader= new FileReader(file);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    int count = 0;
		    String line = "";
		  while (bufferedReader.ready())
		    {
		        String linea = bufferedReader.readLine();
		        
		          if (linea.charAt(0) == '<' || linea.charAt(1) == '<' )
		        {
		           count++;
		        
		             while (count >= 3 && count < 7) {    
		                 count++;             
		                 line = bufferedReader.readLine().trim();
		    
		                 
		                 
		                 if (line.charAt(0) != '/'  )
		                 {
		                 System.out.println(line);
		                 }else {
		                	 break;              	
		                 }         
		             }
		            
		           }
		         
		        } 
		   return null;    
			}
	
	public String getElementsByTagName(String tagName) throws IOException {
		 FileReader fileReader= new FileReader(file);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    int count = 0;
		    String line = "";
		    String linea2 = "";
		  while (bufferedReader.ready())
		    {
		        String linea = bufferedReader.readLine();
		          if (linea.charAt(0) == '<' || linea.charAt(1) == '<' )
		        {
		        	 
		          
		        
		             while (count >= 0 && count < 100) {    
		                             
		                 line = bufferedReader.readLine().trim();
		                linea2 = line;
		 
		                line = line.substring(1,line.indexOf('>'));  
		                
		                if (line.equals(tagName)) {
			        		  System.out.println( linea2);
		                } 
		                 
		                    
		             }
		            
		           }
		         
		        } 
		   return null;    
			}	
	
	
	public String getTagName(String tagName) throws IOException {
		 FileReader fileReader= new FileReader(file);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    int count = 0;
		    String line = "";
		    String linea2 = "";
		   
		  while (bufferedReader.ready())
		    {
		        String linea = bufferedReader.readLine();
		          if (linea.charAt(0) == '<' || linea.charAt(1) == '<' )
		        {
		        	 
		          
		        
		             while (count >= 0 && count < 100) {    
		                             
		                 line = bufferedReader.readLine().trim();
		                linea2 = line;
		                
		                line = line.substring(line.indexOf('>')+1);  
		                
		                if (line.equals(tagName)) {
			        		  System.out.println( linea2);
		                } 
		                 
		                    
		             }
		            
		           }
		         
		        } 
		   return null;    
			}
	/*
	public static getTextContent() {
		
	}
	public static getAttributes() {
		
	}
	public static getAttribute(String attribute) {
		
	}
	*/
}
