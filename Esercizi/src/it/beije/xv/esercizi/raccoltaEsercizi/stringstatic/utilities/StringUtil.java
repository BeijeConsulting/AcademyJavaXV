package it.beije.java.xv.esercizi.stringstatic.utilities;

public class StringUtil {

	
	public static void test() {
		System.out.println("Testing!");
	}
	
	public static int indexOf(String s, char c) {
		for( int i = 0; i < s.length(); i++ ) {
			if( s.charAt(i) == c ) return i;
		}
		return -1;
	}
	
	public static int indexOf(String s, char c, int fromIndex ) {
		for( int i = fromIndex; i < s.length(); i++) {
			if( s.charAt(i) == c ) return i;
		}
		return -1;
	}
	
	//String indexOf(String s, String str)
	public static int indexOf(String s, String str) {
		if( str.length() > s.length()) return -1;
		
		for( int i = 0; i < s.length() ; i++) {
			if( s.charAt(i) == str.charAt(i)) {
				
			}
		}
		return -1;
	}
	
	
	
	
	//String substring(String s, int beginIndex, int endIndex)
	public static String substring(String s, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
		if( beginIndex < 0 || endIndex >= s.length()) throw new IndexOutOfBoundsException();
		StringBuilder builder = new StringBuilder();
		for( int i = beginIndex; i < endIndex; i++ ) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
	
	public static String toUpperCase(String s ) {
		StringBuilder builder = new StringBuilder();
		for( int i = 0; i < s.length(); i++ ) {
			builder.append(Character.toUpperCase(s.charAt(i)));
		}
		return builder.toString();
	}
	
	//Da RIFARE con unicode
	public static String toLowerCase(String s ) {
		StringBuilder builder = new StringBuilder();
		for( int i = 0; i < s.length(); i++ ) {
			builder.append(Character.toLowerCase(s.charAt(i)));
		}
		return builder.toString();
	}
	
	public static boolean equals(String s1, String s2) {
		//internalTest();// --> cannot make static reference to a non static method
		//new StringUtil().internalTest();
		if(s1 == null || s2 == null || (s1.length() != s2.length()) ) return false;
		
		for( int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) return false;
		}
		return true;
	}
	
	/*
	public void internalTest() {
		System.out.println("Working!");
	}
	*/
	public static boolean equalsIgnoreCase(String s1, String s2) {
		if(s1 == null || s2 == null || (s1.length() != s2.length()) ) return false;
		for( int i = 0; i < s1.length(); i++) {
			if( Character.toLowerCase(s1.charAt(i)) != Character.toLowerCase(s2.charAt(i)) ) return false;
		}
		return true;
	}
	
	
	
}
