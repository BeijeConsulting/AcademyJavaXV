package it.beije.hopper.file;

import java.util.ArrayList;

public class Elemento {

    private String nome;
    private int n;
    private Elemento parent = null;
    private ArrayList<String> texts = new ArrayList<String>();
    private ArrayList<Elemento> childs;

    public Elemento(String nome){
        this.nome=nome;
        this.childs = new ArrayList<Elemento>();
    }

    public void addParent(Elemento parent){
        this.parent=parent;
    }

    public void addChild(Elemento child){
        childs.add(child);
    }
    public Elemento getParent(){
        return parent;
    }

    public ArrayList<Elemento>  getChilds(){
        return childs;
    }

    public String getNome(){
        return this.nome;
    }

    public int getN(){
        return this.n;
    }

    public void setN(int n){
        this.n=n;
    }
    public ArrayList<String> getTexts(){
        return this.texts;
    }

    public boolean addTexts(String text){
        return texts.add(text);
    }

}
