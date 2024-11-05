/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class MonografskaPublikacijaView {
    
    private Publikacija publikacija;
    private int idMono;
    private String vrstaPoveza;
    private String stanje;
    private Fond fond;

    public MonografskaPublikacijaView() {
    }

    public MonografskaPublikacijaView(Publikacija publikacija, int idMono, String vrstaPoveza, String stanje, Fond fond) {
        this.publikacija = publikacija;
        this.idMono = idMono;
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

    public int getIdMono() {
        return idMono;
    }

    public void setIdMono(int idMono) {
        this.idMono = idMono;
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
