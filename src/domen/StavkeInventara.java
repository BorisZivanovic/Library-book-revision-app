/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class StavkeInventara {
    
    private Inventar inventar;
    private int rbStavke;
    private int kolicina;
    private Publikacija publikacija;

    public StavkeInventara() {
    }

    public StavkeInventara(Inventar inventar, int rbStavke, int kolicina, Publikacija publikacija) {
        this.inventar = inventar;
        this.rbStavke = rbStavke;
        this.kolicina = kolicina;
        this.publikacija = publikacija;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Publikacija getPublikacija() {
        return publikacija;
    }

    public void setPublikacija(Publikacija publikacija) {
        this.publikacija = publikacija;
    }

}
