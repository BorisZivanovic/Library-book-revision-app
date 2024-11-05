/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Fond {
    
    private int idFonda;
    private String naziv;

    public Fond() {
    }

    public Fond(int idFonda, String naziv) {
        this.idFonda = idFonda;
        this.naziv = naziv;
    }

    public int getIdFonda() {
        return idFonda;
    }

    public void setIdFonda(int idFonda) {
        this.idFonda = idFonda;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }  
    
}
