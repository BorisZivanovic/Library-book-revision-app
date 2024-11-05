/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Komisija {
    
    private int idKomisije;
    private String naziv;
    private String opis;

    public Komisija() {
    }

    public Komisija(int idKomisije, String naziv, String opis) {
        this.idKomisije = idKomisije;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getIdKomisije() {
        return idKomisije;
    }

    public void setIdKomisije(int idKomisije) {
        this.idKomisije = idKomisije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
    
}
