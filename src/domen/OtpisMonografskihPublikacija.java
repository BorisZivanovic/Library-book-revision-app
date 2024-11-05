/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class OtpisMonografskihPublikacija {
    
    private MonografskiIzvestaj izvestaj;
    private int idOtpisaM;
    private int manjak;
    private int skart;
    private Revizija revizija;

    public OtpisMonografskihPublikacija() {
    }

    public OtpisMonografskihPublikacija(MonografskiIzvestaj izvestaj, int idOtpisaM, int manjak, int skart, Revizija revizija) {
        this.izvestaj = izvestaj;
        this.idOtpisaM = idOtpisaM;
        this.manjak = manjak;
        this.skart = skart;
        this.revizija = revizija;
    }
    
    public OtpisMonografskihPublikacija(MonografskiIzvestaj izvestaj, int idOtpisaM, int manjak, int skart) {
        this.izvestaj = izvestaj;
        this.idOtpisaM = idOtpisaM;
        this.manjak = manjak;
        this.skart = skart;
    }
    
    public OtpisMonografskihPublikacija(MonografskiIzvestaj izvestaj, int manjak, int skart, Revizija revizija) {
        this.izvestaj = izvestaj;
        this.manjak = manjak;
        this.skart = skart;
        this.revizija = revizija;
    }
    
    public OtpisMonografskihPublikacija(MonografskiIzvestaj izvestaj, int manjak, int skart) {
        this.izvestaj = izvestaj;
        this.manjak = manjak;
        this.skart = skart;
    }

    public MonografskiIzvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(MonografskiIzvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }

    public int getIdOtpisaM() {
        return idOtpisaM;
    }

    public void setIdOtpisaM(int idOtpisaM) {
        this.idOtpisaM = idOtpisaM;
    }

    public int getManjak() {
        return manjak;
    }

    public void setManjak(int manjak) {
        this.manjak = manjak;
    }

    public int getSkart() {
        return skart;
    }

    public void setSkart(int skart) {
        this.skart = skart;
    }

    public Revizija getRevizija() {
        return revizija;
    }

    public void setRevizija(Revizija revizija) {
        this.revizija = revizija;
    }
    
    
    
}
