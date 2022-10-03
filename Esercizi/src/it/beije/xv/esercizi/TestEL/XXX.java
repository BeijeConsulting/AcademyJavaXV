package it.beije.xv.esercizi.TestEL;


class XXX {
    public void m() throws Exception {
        throw new Exception();
    }
}

class YYY extends XXX {
    public void m() {
    }

    public static void main(String[] args) {
        YYY obj = new YYY();
        obj.m();
    }
}