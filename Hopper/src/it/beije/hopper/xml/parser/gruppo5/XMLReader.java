package it.beije.hopper.xml.parser.gruppo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//getRootElement() //torna l'elemento root
//getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
//getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
//getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
//getTagName() //torna il nome del tag
//getTextContent() //torna il contenuto del tag
//getAttributes() //torna l'elenco degli attributi dell'elemento
//getAttribute(String attribute) //torna il valore dell'attributo specificato


public class XMLReader {
	
	int tab = 0;
	File file; 
	
	public XMLReader(File file)
	{
		this.file = file;
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
//					count++;
					
					if (count++ == 1)		
					{
						
						String line = ""; 
						String[] arr;
						arr = linea.split(" ");
						
						
						line = bufferedReader.readLine().trim();
						if (arr[0].charAt(arr[0].length()-1) == 62)			//'>'
							line = arr[0].substring(1,arr[0].length()-1);
						else
							line = arr[0].substring(1);
						
						System.out.println(line);
//						System.out.println(arr[0]);		
						return null;
					}
				}
			
//			else
//			{
//				if (linea.charAt(0) == '<')
//				{
//					count++;
//					
//					if (count == 2)
//					{
//				
//						String uff[];
//						uff = linea.split(" ");
//						String line = uff[0]; 
//						line = line.substring(1,line.length());
//						System.out.println(line);
//						return null;
//					}
//				}
//				
//			}
				
			
		}
		
		return null;
		
	}
	
	public void stampa() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count = 0;
		while (bufferedReader.ready())
		{
			String linea = bufferedReader.readLine();
			System.out.println(linea);
			//System.out.println("");
		}
	}
	
	
	
	public String getChildNodes() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready())
		{		
			//System.out.print((char)fileReader.read()); 
			String linea = bufferedReader.readLine();
			//System.out.println(linea); 
			if (linea.length()>0)
			{
				if (linea.charAt(0) == '\t' && linea.charAt(1) == '<' && linea.charAt(2) != '/')
				{
					linea = linea.trim();
					linea = linea.substring(1,linea.length()-1);
					String[]arr = linea.split(" ");
					
					System.out.println(arr[0]);
				}	
			}
			
		}
		
		
		
		return null;
		
	}
	
	public String getChildElements() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready())
		{		
			//System.out.print((char)fileReader.read()); 
			String linea = bufferedReader.readLine();
			//System.out.println(linea); 
			if (linea.length()>2)
			{
				if (linea.charAt(0) == '\t' && linea.charAt(1) == '\t' && linea.charAt(2) != '\t')
				{
					linea = linea.trim();
					String[] arr = linea.split(">");
	
						String[] eliminare = linea.split(">");
						linea = linea.substring(eliminare[0].length()+1);
						String[] eliminare1 = linea.split("<");
						
						linea = linea.substring(0,linea.length());
						System.out.println(eliminare1[0]);
										
				}	
			}
		}
			
		return null;
		
	}
	
	public String getElementsByTagName(String tagName) throws IOException
	{
		String ricerca = "<"+tagName + ">";	
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String parole[] = null;

//		while (bufferedReader.ready())
//		{		
//			//System.out.print((char)fileReader.read()); 
//			String linea = bufferedReader.readLine().trim();
//			//System.out.println(linea); 
//			
//			if (linea.contains(ricerca))
//			{
//				String ricerca2 = "<"+tagName + "/>";
//				linea = linea.substring(ricerca.length(), linea.length()-(ricerca2.length()));
//				System.out.println(linea);
//			}
//		}
		int i = 0;
		int inizio = 0;
		int fine = 0;
		while ( bufferedReader.ready())
		{
		
			String linea = bufferedReader.readLine().trim();
			parole[i++] = linea;
			
		}
		for (int j = 0; j<parole.length; j++)
		{
			if(parole[j].contains(ricerca))
				inizio=j;
		}
		for (int k = 0; k<parole.length; k++)
		{
			if (parole[k].contains("</") && k>=inizio)
			{
				fine = k;
				break;
			}
				
		}
			
			
		return null;
	}
	
	public String getTagName() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready())
		{		 
			String linea = bufferedReader.readLine().trim();
			
			if(linea.length()>0)
			{
				if (linea.charAt(0) == '<' && linea.charAt(1) != '/' && linea.charAt(1) != '?' && linea.charAt(linea.length()-2) != '/')
				{
					if(linea.contains(" "))
					{
						String[] arr = linea.split(" ");
						arr[0] = arr[0].trim();
						arr[0] = arr[0].substring(1);
						System.out.println(arr[0]);
					}
					else
					{
						String[] arr = linea.split(">");
						arr[0] = arr[0].trim();
						arr[0] = arr[0].substring(1);
						System.out.println(arr[0]);
					}
				}	
			}
		
		
	}
		return null;
	
	}
	
	public void getTextContent() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready())
		{		
			//System.out.print((char)fileReader.read()); 
			String linea = bufferedReader.readLine();
			if (linea.charAt(0) != '<')
			{
				System.out.println(linea);
			}
			
				
		}
	}
	
	public void getAttributes() throws IOException
	{
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		
		while (bufferedReader.ready())
		{		 
			String linea = bufferedReader.readLine();
			String[] arr = linea.split("=");
			
			for(int j = 0; j < arr.length-1; j++)
			{
				int i = arr[j].lastIndexOf(' ');
				arr[j] = arr[j].substring(i,arr[j].length());
				System.out.println(arr[j].trim());
			}
		}
	}
	
	public void getAttribute(String attribute) throws IOException
	{
		String parseID = " " + attribute + "=" + "\"";
		String fineParseID[] = null;
		FileReader fileReader= new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		
		while (bufferedReader.ready())
		{	
			String linea = bufferedReader.readLine();
			
			String[] arr = linea.split(parseID);
			
			if(arr.length>1)
				fineParseID= arr[1].split("\"");
			
			if(linea.contains(parseID))
				System.out.println(fineParseID[0]);
			
				
			//System.out.println(fineParseID[0]);
		}
	}
	

}
