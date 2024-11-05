/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class MonografskaPublikacijaDetaljno {
    
    Publikacija publikacija;
    String vrstaPoveza;
    String stanje;
    Fond fond;

    public MonografskaPublikacijaDetaljno() {
    }

    public MonografskaPublikacijaDetaljno(Publikacija publikacija, String vrstaPoveza, String stanje, Fond fond) {
        this.publikacija = publikacija;
        this.vrstaPoveza = vrstaPoveza;
        this.stanje = stanje;
        this.fond = fond;
    }

    public Publikacija getPublikacija() {
        return publikacija;
    }

    public void setPublikacija(Publikacija publikacija) {
        this.publikacija = publikacija;
    }

    public String getVrstaPoveza() {
        return vrstaPoveza;
    }

    public void setVrstaPoveza(String vrstaPoveza) {
        this.vrstaPoveza = vrstaPoveza;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    public Fond getFond() {
        return fond;
    }

    public void setFond(Fond fond) {
        this.fond = fond;
    }

}
