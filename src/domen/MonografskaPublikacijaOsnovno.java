/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class MonografskaPublikacijaOsnovno {
    
    private Publikacija publikacija;
    private int idMono;

    public MonografskaPublikacijaOsnovno() {
    }

    public MonografskaPublikacijaOsnovno(Publikacija publikacija, int idMono) {
        this.publikacija = publikacija;
        this.idMono = idMono;
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
    
}
