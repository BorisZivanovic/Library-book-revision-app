/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Biblioteka;
import domen.Clan;
import domen.Fond;
import domen.Inventar;
import domen.Izvestaj;
import domen.Komisija;
import domen.MonografskaPublikacijaDetaljno;
import domen.MonografskaPublikacijaOsnovno;
import domen.MonografskaPublikacijaView;
import domen.MonografskiIzvestaj;
import domen.OdlukaUsvajanja;
import domen.Osoba;
import domen.OtpisMonografskihPublikacija;
import domen.Publikacija;
import domen.Revizija;
import domen.StavkeInventara;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaca
 */
public class Kontroler {
    
    private static Kontroler instance;
    private DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<Biblioteka> vratiSveBiblioteke() throws SQLException {
        return dbb.vratiSveBiblioteke();
    }

    public boolean azurirajBiblioteku(Biblioteka biblioteka) throws SQLException {
            return dbb.azurirajBiblioteku(biblioteka);
    }

    public boolean izbrisiBiblioteku(Biblioteka biblioteka) throws SQLException {
            return dbb.izbrisiBiblioteku(biblioteka);
    }

    public boolean sacuvajBiblioteku(Biblioteka biblioteka) throws SQLException {
        return dbb.sacuvajBiblioteku(biblioteka);
    }

    public List<Revizija> vratiSveRevizije() throws SQLException{
        return dbb.vratiSveRevizije();
    }

    public void azurirajReviziju(Revizija revizija) throws SQLException {
        dbb.azurirajReviziju(revizija);
    }

    public boolean izbrisiReviziju(Revizija revizija) throws SQLException {
        return dbb.izbrisiReviziju(revizija);
    }

    public List<Komisija> vratiSveKomisije() throws SQLException {
        return dbb.vratiSveKomisije();
    }

    public boolean sacuvajReviziju(Revizija novaRevizija) throws SQLException {
        return dbb.sacuvajReviziju(novaRevizija);
    }

    public List<Izvestaj> vratiSveIzvestaje() throws SQLException {
        return dbb.vratiSveIzvestaje();
    }

    public boolean sacuvajIzvestaj(Izvestaj izvestaj) throws SQLException {
        return dbb.sacuvajIzvestaj(izvestaj);
    }

    public boolean izbrisiIzvestaj(Izvestaj izvestaj) throws SQLException {
        return dbb.izbrisiIzvestaj(izvestaj);
    }

    public Revizija vratiKonkretnuReviziju(int idRevizije) throws SQLException {
        return dbb.vratiKonkretnuReviziju(idRevizije);
    }

    public boolean azurirajIzvestaj(Izvestaj noviIzvestaj) throws SQLException {
        return dbb.azurirajIzvestaj(noviIzvestaj);
    }

    public List<MonografskiIzvestaj> vratiSveMonoIzvestaje() throws SQLException {
        return dbb.vratiSveMonoIzvestaje();
    }

    public List<OtpisMonografskihPublikacija> vratiSveOtpisMonoP() throws SQLException {
        return dbb.vratiSveOtpisMonoP();
    }

    public boolean sacuvajOtpisMono(OtpisMonografskihPublikacija otpisMono) throws SQLException {
        return dbb.sacuvajOtpisMono(otpisMono);
    }

    public boolean izbrisiOtpis(OtpisMonografskihPublikacija otpis) throws SQLException {
        return dbb.izbrisiOtpis(otpis);
    }

    public boolean azurirajOtpisMono(OtpisMonografskihPublikacija noviOtpis) throws SQLException {
        return dbb.azurirajOtpisMono(noviOtpis);
    }

    public List<Osoba> vratiSveOsobe() throws SQLException {
        return dbb.vratiSveOsobe();
    }

    public boolean sacuvajOsobu(Osoba osoba) throws SQLException {
        return dbb.sacuvajOsobu(osoba);
    }

    public boolean sacuvajClana(Clan clan) throws SQLException {
        return dbb.sacuvajClana(clan);
    }

    public List<Clan> vratiSveClanove() throws SQLException {
        return dbb.vratiSveClanove();
    }

    public List<OdlukaUsvajanja> vratiSveOdlukeUsvajanja() throws SQLException {
        return dbb.vratiSveOdlukeUsvajanja();
    }

    public List<OdlukaUsvajanja> vratiStarijeOdlukeUsvajanja() throws SQLException {
        return dbb.vratiStarijeOdlukeUsvajanja();
    }

    public List<OdlukaUsvajanja> vratiNovijeOdlukeUsvajanja() throws SQLException {
        return dbb.vratiNovijeOdlukeUsvajanja();
    }

    public boolean sacuvajOdlukuUsvajanja(OdlukaUsvajanja odlukaUsvajanja) throws SQLException {
        return dbb.sacuvajOdlukuUsvajanja(odlukaUsvajanja);
    }

    public List<MonografskaPublikacijaView> vratiMonoPView() throws SQLException {
        return dbb.vratiMonoPView();
    }

    public List<MonografskaPublikacijaOsnovno> vratiMonoPOsnovno() throws SQLException {
        return dbb.vratiMonoPOsnovno();
    }

    public List<MonografskaPublikacijaDetaljno> vratiMonoPDetaljno() throws SQLException {
        return dbb.vratiMonoPDetaljno();
    }

    public List<Publikacija> vratiSvePublikacije() throws SQLException {
        return dbb.vratiSvePublikacije();
    }

    public List<Fond> vratiSveFondove() throws SQLException {
        return dbb.vratiSveFondove();
    }

    public boolean sacuvajMonoP(MonografskaPublikacijaView monoP) throws SQLException {
        return dbb.sacuvajMonoP(monoP);
    }

    public boolean azurirajMonoP(MonografskaPublikacijaView novaMonoP) throws SQLException {
       return dbb.azurirajMonoP(novaMonoP);
    }

    public boolean obrisiMonoP(MonografskaPublikacijaView monoP) throws SQLException {
        return dbb.obrisiMonoP(monoP);
    }

    public List<Inventar> vratiSveInventare() throws SQLException {
        return dbb.vratiSveInventare();
    }

    public List<StavkeInventara> vratiSveStavkeInventare(Inventar inventar) throws SQLException {
        return dbb.vratiSveStavkeInventare(inventar);
    }

    public boolean sacuvajInventar(Inventar inventar) throws SQLException {
        return dbb.sacuvajInventar(inventar);
    }

    public boolean obrisiStavku(StavkeInventara stavkeInventara) throws SQLException {
        return dbb.obrisiStavku(stavkeInventara);
    }

    public boolean azurirajStavku(StavkeInventara stavkeInventara) throws SQLException {
        return dbb.azurirajStavku(stavkeInventara);
    }

    public boolean azurirajInventar(Inventar inventar) throws SQLException {
        return dbb.azurirajInventar(inventar);
    }

    public boolean obrisiInventar(Inventar inventar) throws SQLException {
        return dbb.obrisiInventar(inventar);
    }
    
}
