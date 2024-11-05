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
public class OdlukaUsvajanja {
    
    private int idOdluke;
    private Date datumOdluke;
    private Long brojZaZalbe;
    private Osoba osoba;
    private Revizija revizija;
    private Biblioteka biblioteka;

    public OdlukaUsvajanja() {
    }

    public OdlukaUsvajanja(int idOdluke, Date datumOdluke, Long brojZaZalbe, Osoba osoba, Revizija revizija, Biblioteka biblioteka) {
        this.idOdluke = idOdluke;
        this.datumOdluke = datumOdluke;
        this.brojZaZalbe = brojZaZalbe;
        this.osoba = osoba;
        this.revizija = revizija;
        this.biblioteka = biblioteka;
    }

    public int getIdOdluke() {
        return idOdluke;
    }

    public void setIdOdluke(int idOdluke) {
        this.idOdluke = idOdluke;
    }

    public Date getDatumOdluke() {
        return datumOdluke;
    }

    public void setDatumOdluke(Date datumOdluke) {
        this.datumOdluke = datumOdluke;
    }

    public Long getBrojZaZalbe() {
        return brojZaZalbe;
    }

    public void setBrojZaZalbe(Long brojZaZalbe) {
        this.brojZaZalbe = brojZaZalbe;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public Revizija getRevizija() {
        return revizija;
    }

    public void setRevizija(Revizija revizija) {
        this.revizija = revizija;
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }

    public void setBiblioteka(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
    }
    
    
    
}
