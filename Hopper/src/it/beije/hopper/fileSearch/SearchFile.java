package it.beije.hopper.fileSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFile {

	public static void main(String[] args) {
		
		File file =new File("C:\\Users\\andre\\OneDrive\\Documents\\Università\\PA");
		
		if(!file.exists())
			System.exit(0);
		
		
		if(file.isDirectory()){
			System.out.println(file.getName()+"(DIR)");
				verify(file,1);
			}
		
			
	}
	
	
	public static void verify(File file,int i) {
		
		String[] rows=file.list();
		String ind=inde(i);
		for(String row : rows){
			File nfile=new File(file.getPath()+"/"+row);
			
			if(nfile.isDirectory()) {
				System.out.println(ind+row+"(DIR)");
				verify(nfile,i+1);
			}
			
			else {
					System.out.println(ind+row);
			}
		}		
	}
	
	
	public static String inde(int i) {
		
		String result="";
		
		for(int n=0;n<i;n++) {
			result+="\t";
		}
		return result;
	}
}
