package it.beije.hopper.xml.parser.gruppo2;

import java.util.ArrayList;

public class XmlElement {

    private String root;
    private String nome;

    private String valore;

    private ArrayList<XmlElement> elements = new ArrayList<>();

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public ArrayList<XmlElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<XmlElement> elements) {
        this.elements = elements;
    }

    public void addElement(XmlElement e) {
        this.elements.add(e);
    }

    public String getTagName() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTextContent() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public XmlElement(String nome, String valore) {
        this.nome = nome;
        this.valore = valore;
    }

    public XmlElement() {
    }

    public ArrayList<XmlElement> getChildNodes() {
        return this.elements;
    }

    public ArrayList<XmlElement> getChildElements() {
        ArrayList<XmlElement> elements1 = new ArrayList<>();
        for (XmlElement e : this.elements) {
            XmlElement e1 = new XmlElement(e.nome, e.valore);
            elements1.add(e);
        }
        return elements1;
    }


    public String getAttributes() {
        ArrayList<String> strings = new ArrayList<>();
        for (XmlElement e : this.elements) {
            strings.add(e.getTagName() + ": " + e.getTextContent());
        }
        return strings.toString();
    }

    public String getAttribute(String attribute) {
        ArrayList<String> strings = new ArrayList<>();
        for (XmlElement e : this.elements) {
            if (e.getTagName().equals(attribute))
                strings.add(e.getTagName() + ": " + e.getTextContent());
        }
        return strings.toString();
    }

    public String getElementsByTagName(String tagname) {
        ArrayList<String> strings = new ArrayList<>();
        if (this.nome.equals(tagname)) {
            return this.valore;
        } else {
            for (XmlElement e : this.elements) {
                if (e.getTagName().equals(tagname))
                    strings.add(e.getTextContent());
            }
        }
        return strings.toString();
    }

    public void add(XmlElement child) {
        this.elements.add(child);
    }


    @Override
    public String toString() {
        StringBuilder ts = new StringBuilder("XmlElement{" +
                "root='" + root + '\'' +
                ", nome='" + nome + '\'' +
                ", valore='" + valore + '\''
                );
        for(XmlElement e : this.getChildElements())
            ts.append(e.toString());
        ts.append('}');
        return ts.toString();
    }
}
