/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class Izvestaj {
    
    private int idIzvestaja;
    private int brojJediniceUElKatalogu;
    private Revizija revizija;

    public Izvestaj() {
    }

    public Izvestaj(int idIzvestaja, int brojJediniceUElKatalogu, Revizija revizija) {
        this.idIzvestaja = idIzvestaja;
        this.brojJediniceUElKatalogu = brojJediniceUElKatalogu;
        this.revizija = revizija;
    }

    public int getIdIzvestaja() {
        return idIzvestaja;
    }

    public void setIdIzvestaja(int idIzvestaja) {
        this.idIzvestaja = idIzvestaja;
    }

    public int getBrojJediniceUElKatalogu() {
        return brojJediniceUElKatalogu;
    }

    public void setBrojJediniceUElKatalogu(int brojJediniceUElKatalogu) {
        this.brojJediniceUElKatalogu = brojJediniceUElKatalogu;
    }

    public Revizija getRevizija() {
        return revizija;
    }

    public void setRevizija(Revizija revizija) {
        this.revizija = revizija;
    }

}
