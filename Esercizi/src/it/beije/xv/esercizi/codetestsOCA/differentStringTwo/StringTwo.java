package it.beije.xv.esercizi.codetestsOCA.differentStringTwo;


import it.beije.xv.esercizi.codetestsOCA.one.StringOne;

public class StringTwo {
	public String str2 ="abc";
	
	public static void main(String[] args) {
		StringOne test = new StringOne();
		StringTwo test2 = new StringTwo();
		System.out.println( test.str + "=="+ test2.str2 +"?" + test.str == test2.str2);
		System.out.println();
	}
}
