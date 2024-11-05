/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Publikacija {
    
    private int idP;
    private String naziv;
    private int cena;
    private int brojStrana;
    private String tip;

    public Publikacija() {
    }

    public Publikacija(int idP, String naziv, int cena, int brojStrana, String tip) {
        this.idP = idP;
        this.naziv = naziv;
        this.cena = cena;
        this.brojStrana = brojStrana;
        this.tip = tip;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }  
    
}
