/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.List;

/**
 *
 * @author Jaca
 */
public class Inventar {
    
    private int idInventara;
    private String opis;
    private int ukupnaCena;
    private List<StavkeInventara> stavkeInventara;

    public Inventar() {
    }

    public Inventar(int idInventara, String opis, int ukupnaCena) {
        this.idInventara = idInventara;
        this.opis = opis;
        this.ukupnaCena = ukupnaCena;
    }

    public Inventar(int idInventara, String opis, int ukupnaCena, List<StavkeInventara> stavkeInventara) {
        this.idInventara = idInventara;
        this.opis = opis;
        this.ukupnaCena = ukupnaCena;
        this.stavkeInventara = stavkeInventara;
    }

    public Inventar(int idInventara, String opis, List<StavkeInventara> stavkeInventara) {
        this.idInventara = idInventara;
        this.opis = opis;
        this.stavkeInventara = stavkeInventara;
    }
    
    public List<StavkeInventara> getStavkeInventara() {
        return stavkeInventara;
    }

    public void setStavkeInventara(List<StavkeInventara> stavkeInventara) {
        this.stavkeInventara = stavkeInventara;
    }

    public int getIdInventara() {
        return idInventara;
    }

    public void setIdInventara(int idInventara) {
        this.idInventara = idInventara;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }
    
    
    
}
