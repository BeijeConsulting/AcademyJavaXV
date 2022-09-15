package it.beije.hopper.file.eserciziolettura;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/*

Realizzare un programma che, ottenuto in input il percorso di una directory, ne elenchi il contenuto in un file di testo.
Se all'interno della directory sono presenti ulteriori directories, il programma dovrà elencare anche il contenuto di queste e 
delle eventuali directories interne, in modo ricorsivo.
Il file dovrebbe chiamarsi come il nome della directory ricevuta in input (estenione va benissimo .txt ma potete dicederla a piacere).
Le informazioni raccolte dovrebbero essere strutturate in questo modo dentro il file:
aaa.txt
bbb.zip
ccc.xls
csv (dir)
    f1.csv
    f2.csv
    f3.csv
    yyy (dir)
        pippo.doc
        pluto.doc
    zzz.txt
mydir (dir)
    ggg.txt
    hhh.txt
qui.css
quo.jpg
qua.png
Per maggiore chiarezza, potete prevedere di riportare non solo il nome del file, ma il suo path completo sul disco.

*/

public class Reader {
	
	
	public static void main(String[] args) {
		
		String from = "C:\\Users\\Michael Angelo\\eclipse-workspace\\Beija-Java\\AcademyXV-github\\AcademyJavaXV\\Hopper\\Test";
		textWriter(from, "output_txt.txt" );
				
	}
	
	public static void textWriter( String fromPath, String toPath) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(toPath));
			writer.write(directoryReader(fromPath));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally {
			try {
				writer.flush();
				writer.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
	}
	public static String  directoryReader( String input) {
		StringBuilder output = new StringBuilder("");
		
		try {
			File directory = new File(input);
			File[] files = directory.listFiles();
			//System.out.println("D: " + directory.getName());
			output.append("D: " + directory.getName()+"\n");
			reader(files, 0, 0, output);
			//System.out.println(output);
		}catch(Exception ioe) {
			ioe.printStackTrace();
		}
		return output.toString();
	}
	
	public static void reader( File[] files,  int index, int level, StringBuilder output) {
		
		if( index == files.length) {
			return;
		}
		
		printWhiteLine(level, "    ", output);
		
		if( files[index].isFile()) { 
			output.append(files[index].getName() + "\n");
		}else if(files[index].isDirectory()) {
			output.append("Dir(" + files[index].getName() +")\n");
			reader(files[index].listFiles(), 0, level+1, output );
		}
			
		
		reader(files, ++index, level, output);
		
		return;
		
	}
	
	
	private static void printWhiteLine(int whiteLine, String c, StringBuilder output) {
		for( int i = 0; i<whiteLine; i++) output.append(c);
	}
	
}	


