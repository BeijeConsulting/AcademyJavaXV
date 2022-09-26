package it.beije.hopper.esercizioletturafile;

import java.io.File;
import java.util.ArrayList;

public class Directory {
	private ArrayList<File> directories;
	private ArrayList<File> files; // needs to detect if file contains text!
	
	public ArrayList<File> getDirectories() {
		return directories;
	}
	public void setDirectories(ArrayList<File> directories) {
		this.directories = directories;
	}
	public ArrayList<File> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
	

	
}
