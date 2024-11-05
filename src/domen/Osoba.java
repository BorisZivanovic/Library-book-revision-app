/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Osoba {
    
    private int idOsobe;
    private String ime;
    private String prezime;
    private Kontakt kontakt;

    public Osoba() {
    }

    public Osoba(int idOsobe, String ime, String prezime, Kontakt kontakt) {
        this.idOsobe = idOsobe;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
    }

    public int getIdOsobe() {
        return idOsobe;
    }

    public void setIdOsobe(int idOsobe) {
        this.idOsobe = idOsobe;
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

    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }
    
    
    
}
