/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.Date;

/**
 *
 * @author Jaca
 */
public class Revizija {
    
    private int idRevizije;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private String zakon;
    private String gradja;
    private Komisija komisija;
    private Biblioteka biblioteka;
    private String nazivBiblioteke;

    public Revizija() {
    }

    public Revizija(int idRevizije,String nazivBiblioteke) {
        this.idRevizije = idRevizije;
        this.nazivBiblioteke = nazivBiblioteke;
    }
    
    public Revizija(int idRevizije, Date datumPocetka, Date datumZavrsetka, String zakon, String gradja, Komisija komisija, Biblioteka biblioteka) {
        this.idRevizije = idRevizije;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.zakon = zakon;
        this.gradja = gradja;
        this.komisija = komisija;
        this.biblioteka = biblioteka;
    }

    public Revizija(int idRevizije, Date datumPocetka, Date datumZavrsetka, String zakon, String gradja, Komisija komisija, Biblioteka biblioteka, String nazivBiblioteke) {
        this.idRevizije = idRevizije;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.zakon = zakon;
        this.gradja = gradja;
        this.komisija = komisija;
        this.biblioteka = biblioteka;
        this.nazivBiblioteke = nazivBiblioteke;
    }
    
    public Revizija(int idRevizije, Date datumPocetka, Date datumZavrsetka, String zakon, String gradja, Biblioteka biblioteka, String nazivBiblioteke) {
        this.idRevizije = idRevizije;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.zakon = zakon;
        this.gradja = gradja;
        this.biblioteka = biblioteka;
        this.nazivBiblioteke = nazivBiblioteke;
    }
    
    public int getIdRevizije() {
        return idRevizije;
    }

    public void setIdRevizije(int idRevizije) {
        this.idRevizije = idRevizije;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public String getZakon() {
        return zakon;
    }

    public void setZakon(String zakon) {
        this.zakon = zakon;
    }

    public String getGradja() {
        return gradja;
    }

    public void setGradja(String gradja) {
        this.gradja = gradja;
    }

    public Komisija getKomisija() {
        return komisija;
    }

    public void setKomisija(Komisija komisija) {
        this.komisija = komisija;
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }

    public void setBiblioteka(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
    }

    public String getNazivBiblioteke() {
        return nazivBiblioteke;
    }

    public void setNazivBiblioteke(String nazivBiblioteke) {
        this.nazivBiblioteke = nazivBiblioteke;
    }
    
}
