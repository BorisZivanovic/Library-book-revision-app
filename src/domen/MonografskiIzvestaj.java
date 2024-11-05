/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class MonografskiIzvestaj {
    
    private Izvestaj izvestaj;
    private String sifraM;

    public MonografskiIzvestaj() {
    }

    public MonografskiIzvestaj(Izvestaj izvestaj, String sifraM) {
        this.izvestaj = izvestaj;
        this.sifraM = sifraM;
    }

    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }

    public String getSifraM() {
        return sifraM;
    }

    public void setSifraM(String sifraM) {
        this.sifraM = sifraM;
    }
 
}
