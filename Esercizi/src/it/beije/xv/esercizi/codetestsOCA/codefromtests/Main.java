package it.beije.xv.esercizi.codetestsOCA.codefromtests;

public class Main {

	public static void main(String[] args) {

    
		/*
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };
        
        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }
        System.out.println(newStr);
        System.out.println((newStr == myStr)+ " " + (newStr.equals(myStr)));
        */

		//new JustLooping().showJ();;
		/*
		int x = 0;
		while(false) {
			x=3;
		}*/
		float f = 1;

	}

	
	
}

class JustLooping{
	private int j;
	void showJ() {
		while( j<=5) {
			for( int j=1; j <=5;) {
				System.out.println(j+" ");
				j++;
			}
			j++;
		}
	}
}