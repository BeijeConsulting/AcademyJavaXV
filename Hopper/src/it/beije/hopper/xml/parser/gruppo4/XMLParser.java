package it.beije.hopper.xml.parser.gruppo4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class XMLParser {
    public static String getRootElement() throws Exception{
        List<String> listTag = listTag();
        return listTag.get(0);
    }
    /*public static String getTagName() throws Exception {//torna il nome del tag
         BufferedReader contenutoXml=leggiFile();//Lettura da file XML utilizzano classe BufferedReader
         StringBuilder temp=new StringBuilder();//Creazione variabile temporanea per ottenere il nome dei tag da file
         StringBuilder tag = new StringBuilder();//Variabile di tipo StringBuilder che contiene i tag rilevati.
         String risultato;//Variabile che conterrà il rrisultato
         boolean insideTag=false;//Variabile utile per controllare se si è all'interno di un tag

         while(contenutoXml.ready()){
             temp.append(contenutoXml.readLine());//Lettura intera riga dal file XML
             for (int j=0;j< temp.length();j++) {//Ciclo per tutta la lunghezza della riga acquisita dalla lettura della riga del file XML
                 switch (temp.charAt(j)) {//Valutazione caratteri della riga
                     case '<'://Caso in cui il carattere risulta uguale a <
                         if (temp.charAt(j+1)=='/' && temp.charAt(j+2)== '?'){
                             insideTag=false;
                             continue;
                         }else{
                             insideTag=true;//Si è trovato il carattere di inizio tag e si pone vero questa condizione
                         }
                         break;
                     case '>'://Caso in cui il carattere risulta uguale a >
                         insideTag=false;//Si è trovato il carattere di fine  tag e si pone falsa questa condizione
                         tag.append("\n");
                         break;
                     default://Caso in cui il carattere non risulta nei casi precedenti
                         if(temp.charAt(j)!='/' & insideTag){//Controllo che non ci sia il carattere terminatore del tag
                             tag.append(temp.charAt(j));//Caricamtno nella stringBuilder dei tag con le condizioni dell'IF
                         }
                         break;
                 }
             }
             temp.delete(0,temp.length());
         }
         risultato=tag.toString();


         return risultato;
     }*/
    /*public static void getTextContent(){ //torna il contenuto del tag

    }
    public static void getAttributes() throws IOException { //torna l'elenco degli attributi dell'elemento

    }
    public static void getAttribute(String attribute){  //torna il valore dell'attributo specificato

    }*/
    /*---------------------------------------METODI-UTILY---------------------------------*/
    public static BufferedReader leggiFile() throws IOException {//Legge il file con la classe BuffereREader
        String percorso="src/xml/parser/gruppo4/test/test_parser1.xml";
        return new BufferedReader(new FileReader(percorso));//Apertura con classe Buffered reader file
    }
    public static StringBuilder fromFileToString() throws IOException {//Salva il file aprendolo utilizzando BuffereREader in una StringBuilder
        StringBuilder contenuto= new StringBuilder();
        BufferedReader fileDaLeggere=leggiFile();
        while (fileDaLeggere.ready()) {
            contenuto.append(fileDaLeggere.readLine());
            contenuto.append("\n");
        }
        return contenuto;
    }
    public static List<String> listTag() throws Exception {
        StringBuilder stringFile = fromFileToString();
        StringBuilder element = new StringBuilder();
        List<String> listTag = new ArrayList<>();

        boolean isInsideTag = false;

        int i = 0;
        while(i < stringFile.length() ) {

            switch(stringFile.charAt(i)) {
                case '<':
                    element.delete(0, element.length() );
                    isInsideTag = true;
                    break;

                case '>':
                    isInsideTag = false;
                    listTag.add(element.toString());
                    break;

                default:
                    if(isInsideTag) element.append(stringFile.charAt(i));
                    break;
            }
            i++;
        }

        if( isOpenXMLTag(listTag.get(0)) ){
            listTag.remove(0);
        }

        return listTag;
    }
    public static boolean isOnlyTag(List<String> listTag) throws Exception {//Contolla se i tag hanno tutti un'apertura e una chiusura
        String tag = "";

        int count = 0; //Conta quanti tag aperti e non chiusi ci sono


        for(int i = 0; i < listTag.size() - 1; i++) {
            tag = listTag.get(i);
            if( !(isCloseTag(tag)) ) {
                for(int j = i+1; j < listTag.size(); j++) {
                    if(tag.equals(listTag.get(j))) {
                        count++;
                    }
                    //)  && (count > 0)
                    if(isCloseTag(listTag.get(j))) {
                        if( isOpenAndClose(tag, listTag.get(j))  && (count > 0)) {
                            count --;
                        }
                    }
                }
            }
        }
        return ((count == 0) ? true : false);
    }
    public static boolean isOpenXMLTag(String row) {
        if( ( (row.charAt(0) == '<') && (row.charAt(1) == '?')) || (row.substring(0, 4).equals("?xml")) ) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean isOpenAndClose(String open, String close) {//Restituisce true se open e close hanno lo stesso formato
        close = close.substring(1, close.length());
        return open.equals(close);
    }
    public static boolean isCloseTag(String tag) {
        return (tag.charAt(0) == '/' );
    }
}

