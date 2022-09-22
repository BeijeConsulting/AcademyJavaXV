package it.beije.hopper.xml.parser.gruppo3;

import java.util.ArrayList;

public class Documento {
    private String root;
    private ArrayList<Elemento> parentThree;
    public Documento(ArrayList<Elemento> elementi){
        setRoot(elementi.get(0));
        setParentThree(elementi);
    }

    public void setRoot(Elemento elemento){ this.root = elemento.getNome(); }
    public String getRootElement(){ return this.root; }

    public String[] getChildNotes(Elemento elemento){
        String[] childs = null;
        for (Elemento e: this.parentThree) {
            
        }
        return childs;
    }
    //   public static String[] getChildElements(){}

    //  public static String[] getElementsByTagName(){}

    //   public static String[] getTagName(){}

    //  public static String[] getTextContext(){}

    //  public static String[] getAttributes(){}*/

    public void setParentThree(ArrayList<Elemento> elementi){
        this.parentThree = parentThree;
    }
    public static String indentazione(int j){
        String result="";
        for(int i =0; i<j; i++){
            result += "\t";
        }
        return result;
    }

}


