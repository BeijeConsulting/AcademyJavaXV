package it.beije.xv.esercizi.miglio.array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.*;

public class EsercizioData {
	
	public static double arrotonda(double sett, int numCifreDecimali) {
	      double temp = Math.pow(10, numCifreDecimali);
	      return Math.round(sett * temp) / temp;
	   }
	
	public static void main(String... args) {
		
		LocalDate data = LocalDate.of(2021, 9, 13);
		String g_sett = data.getDayOfWeek().toString();
		int g_mese = data.getDayOfMonth();
		String mese = data.getMonth().toString();
		int g_anno = data.getDayOfYear();
		int anno = data.getYear();
		int sett = (int)arrotonda(g_anno/7, 2);
		System.out.println(g_sett + " " + g_mese  + " " + mese + ", giorno " + g_anno + " dell'anno " + anno + ", settimana numero " + sett);
	}
}
