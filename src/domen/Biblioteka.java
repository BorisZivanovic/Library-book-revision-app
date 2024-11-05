/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Biblioteka {
    
    private int idBiblioteke;
    private String naziv;
    private String adresa;
    private String vrsta;

    public Biblioteka() {
    }

    public Biblioteka(int idBiblioteke, String naziv, String adresa, String vrsta) {
        this.idBiblioteke = idBiblioteke;
        this.naziv = naziv;
        this.adresa = adresa;
        this.vrsta = vrsta;
    }

    public int getIdBiblioteke() {
        return idBiblioteke;
    }

    public void setIdBiblioteke(int idBiblioteke) {
        this.idBiblioteke = idBiblioteke;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }
    
            
    
}
