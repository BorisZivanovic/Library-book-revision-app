/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Clan {
    
    private int idClana;
    private String ime;
    private String prezime;
    private KodClana kodClana;

    public Clan() {
    }

    public Clan(int idClana, String ime, String prezime, KodClana kodClana) {
        this.idClana = idClana;
        this.ime = ime;
        this.prezime = prezime;
        this.kodClana = kodClana;
    }

    public int getIdClana() {
        return idClana;
    }

    public void setIdClana(int idClana) {
        this.idClana = idClana;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public KodClana getKodClana() {
        return kodClana;
    }

    public void setKodClana(KodClana kodClana) {
        this.kodClana = kodClana;
    }
 
}
