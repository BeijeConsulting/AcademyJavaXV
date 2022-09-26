package it.beije.java.xv.esercizi.stringstatic;

import it.beije.java.xv.esercizi.stringstatic.utilities.StringUtil;


public class Main {
	/*
	public void  testing() {
		System.out.println("Testing 2");
	}
	*/
	public static void  testing() {
		System.out.println("Testing 2");
	}
	
	public static void main(String[] args) {
		
//		StringUtil.test();
//		System.out.println(StringUtil.indexOf("tesT", 'c'));
//		System.out.println(StringUtil.indexOf("testTingt", 'i'));
		
//		System.out.println(StringUtil.indexOf("testTingt", 't', 4));
		
//		System.out.println(StringUtil.substring("apice", 0, 0));
//		System.out.println(StringUtil.toUpperCase("Ghrs-+*s_ deAbcd1"));
//		
//		System.out.println(StringUtil.toLowerCase("Ghrs-AAAZDASDWsdB SAs+*s_ deAbcd1"));
//		
//		System.out.println(StringUtil.equals("abcDe", "abcde"));
//		System.out.println(StringUtil.equals("abcde", "abcde"));
//		//new Main().testing();
//		testing();
		
		System.out.println(StringUtil.equalsIgnoreCase("abcDe", "abcde"));
		System.out.println(StringUtil.equalsIgnoreCase("abcde", "abcde"));
		System.out.println(StringUtil.equalsIgnoreCase("abcDef", "abcde"));
		System.out.println(StringUtil.equalsIgnoreCase("abcde", "abcdef"));
		
		
	}
	
}
