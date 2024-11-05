/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Biblioteka;
import domen.Clan;
import domen.Fond;
import domen.Inventar;
import domen.Izvestaj;
import domen.KodClana;
import domen.Komisija;
import domen.Kontakt;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.sql.DATE;

/**
 *
 * @author Jaca
 */
public class DBBroker {
    
     public ArrayList<Object> vrati() {
        ArrayList<Object> lista = new ArrayList<>();
        String upit = "";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean cuvajIzmeniBrisi() throws Exception {
        String upit = "";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Biblioteka> vratiSveBiblioteke() throws SQLException{
        ArrayList<Biblioteka> lista = new ArrayList<>();
        String upit = "SELECT * FROM BIBLIOTEKA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Biblioteka biblioteka = new Biblioteka(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(biblioteka);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean azurirajBiblioteku(Biblioteka biblioteka) throws SQLException {
        String upit = "UPDATE BIBLIOTEKA SET naziv = '" + biblioteka.getNaziv() + "' WHERE idBiblioteke = " + biblioteka.getIdBiblioteke();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean izbrisiBiblioteku(Biblioteka biblioteka) throws SQLException {
        String upit = "DELETE FROM BIBLIOTEKA WHERE idBiblioteke = " + biblioteka.getIdBiblioteke();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean sacuvajBiblioteku(Biblioteka biblioteka) throws SQLException {
         String upit = "INSERT INTO BIBLIOTEKA VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, biblioteka.getIdBiblioteke());
            ps.setString(2, biblioteka.getNaziv());
            ps.setString(3, biblioteka.getAdresa());
            ps.setString(4, biblioteka.getVrsta());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public List<Revizija> vratiSveRevizije() throws SQLException{
        ArrayList<Revizija> lista = new ArrayList<>();
        String upit = "select * from revizija r join biblioteka b on (r.idBiblioteke = b.idBiblioteke) join komisija k on (r.idKomisije = k.idKomisije)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                Biblioteka biblioteka = new Biblioteka(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                Komisija komisija = new Komisija(rs.getInt(13), rs.getString(14), rs.getString(15));
                Revizija revizija = new Revizija(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), komisija, biblioteka, rs.getString(8));
                
                lista.add(revizija);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void azurirajReviziju(Revizija revizija) throws SQLException {
        
        String upit = "UPDATE REVIZIJA SET nazivBiblioteke = '" + revizija.getNazivBiblioteke() + "' WHERE idRevizije = " + revizija.getIdRevizije();
        
        if(revizija.getNazivBiblioteke() == null){
            upit = "UPDATE REVIZIJA SET zakon = '" + revizija.getZakon() + 
                  "', gradja = '" + revizija.getGradja() +                  
                  "' WHERE idRevizije = " + revizija.getIdRevizije(); 
        }
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean izbrisiReviziju(Revizija revizija) throws SQLException {
         String upit = "DELETE FROM REVIZIJA WHERE idRevizije = " + revizija.getIdRevizije();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public List<Komisija> vratiSveKomisije() throws SQLException{
         ArrayList<Komisija> lista = new ArrayList<>();
        String upit = "SELECT * FROM KOMISIJA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Komisija komisija = new Komisija(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(komisija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajReviziju(Revizija novaRevizija) throws SQLException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        /*String pocetak = sdf.format(novaRevizija.getDatumPocetka());
        String zavrsetak = sdf.format(novaRevizija.getDatumZavrsetka());*/
        
        String upit = "INSERT INTO REVIZIJA (idRevizije, datumPocetka, datumZavrsetka, zakon, gradja,idKomisije, idBiblioteke) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, novaRevizija.getIdRevizije());
            /*ps.setDate(2, Date.valueOf(pocetak));
            ps.setDate(3, Date.valueOf(zavrsetak));*/
            ps.setDate(2, new java.sql.Date(novaRevizija.getDatumPocetka().getTime()));
            ps.setDate(3, new java.sql.Date(novaRevizija.getDatumZavrsetka().getTime()));
            ps.setString(4, novaRevizija.getZakon());
            ps.setString(5, novaRevizija.getGradja());
            ps.setInt(6, novaRevizija.getKomisija().getIdKomisije());
            ps.setInt(7, novaRevizija.getBiblioteka().getIdBiblioteke());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }

    public List<Izvestaj> vratiSveIzvestaje() throws SQLException {
         ArrayList<Izvestaj> lista = new ArrayList<>();
        String upit = "select * from revizija r join biblioteka b on (r.idBiblioteke = b.idBiblioteke) join komisija k on (r.idKomisije = k.idKomisije) join izvestaj i on (r.idrevizije = i.idrevizije)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Biblioteka biblioteka = new Biblioteka(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                Komisija komisija = new Komisija(rs.getInt(13), rs.getString(14), rs.getString(15));
                Revizija revizija = new Revizija(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), komisija, biblioteka, rs.getString(8));
                Izvestaj izvestaj = new Izvestaj(rs.getInt(16), rs.getInt(17), revizija);
                
                lista.add(izvestaj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean sacuvajIzvestaj(Izvestaj izvestaj) throws SQLException {
         String upit = "INSERT INTO IZVESTAJ VALUES (?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, izvestaj.getIdIzvestaja());
            ps.setInt(2, izvestaj.getBrojJediniceUElKatalogu());
            ps.setInt(3, izvestaj.getRevizija().getIdRevizije());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean izbrisiIzvestaj(Izvestaj izvestaj) throws SQLException {
         String upit = "DELETE FROM IZVESTAJ WHERE idIzvestaja = " + izvestaj.getIdIzvestaja();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public Revizija vratiKonkretnuReviziju(int idRevizije) throws SQLException{
        Revizija revizija = new Revizija();
        String upit = "select * from revizija r join biblioteka b on (r.idBiblioteke = b.idBiblioteke) join komisija k on (r.idKomisije = k.idKomisije) where r.idRevizije = " + idRevizije;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                Biblioteka biblioteka = new Biblioteka(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                Komisija komisija = new Komisija(rs.getInt(13), rs.getString(14), rs.getString(15));
                revizija = new Revizija(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), komisija, biblioteka, rs.getString(8));                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return revizija;
    }

    public boolean azurirajIzvestaj(Izvestaj noviIzvestaj) throws SQLException {
        String upit = "UPDATE IZVESTAJ SET BROJJEDINICAUELKATALOGU = " + noviIzvestaj.getBrojJediniceUElKatalogu() + ", IDREVIZIJE = " + noviIzvestaj.getRevizija().getIdRevizije() + " WHERE IDIZVESTAJA = " + noviIzvestaj.getIdIzvestaja();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public List<MonografskiIzvestaj> vratiSveMonoIzvestaje() throws SQLException{
        ArrayList<MonografskiIzvestaj> lista = new ArrayList<>();
        String upit = "select * from revizija r join biblioteka b on (r.idBiblioteke = b.idBiblioteke) join komisija k on (r.idKomisije = k.idKomisije)\n" +
                       " JOIN izvestaj I ON (I.IDREVIZIJE = R.IDREVIZIJE) JOIN MONOGRAFSKIIZVESTAJ M ON (M.IDIZVESTAJA = I.IDIZVESTAJA)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Biblioteka biblioteka = new Biblioteka(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                Komisija komisija = new Komisija(rs.getInt(13), rs.getString(14), rs.getString(15));
                Revizija revizija = new Revizija(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), komisija, biblioteka, rs.getString(8));
                Izvestaj izvestaj = new Izvestaj(rs.getInt(16), rs.getInt(17), revizija);
                MonografskiIzvestaj mi = new MonografskiIzvestaj(izvestaj, rs.getString(20));
                
                lista.add(mi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<OtpisMonografskihPublikacija> vratiSveOtpisMonoP() throws SQLException{
        ArrayList<OtpisMonografskihPublikacija> lista = new ArrayList<>();
        String upit = "select * from revizija r join biblioteka b on (r.idBiblioteke = b.idBiblioteke) join komisija k on (r.idKomisije = k.idKomisije)\n" +
                      "JOIN izvestaj I ON (I.IDREVIZIJE = R.IDREVIZIJE) JOIN MONOGRAFSKIIZVESTAJ M ON (M.IDIZVESTAJA = I.IDIZVESTAJA) JOIN OTPISMONOGRAFSKIHPUBLIKACIJA O ON (O.IDIZVESTAJA = M.IDIZVESTAJA)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Biblioteka biblioteka = new Biblioteka(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                Komisija komisija = new Komisija(rs.getInt(13), rs.getString(14), rs.getString(15));
                Revizija revizija = new Revizija(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), komisija, biblioteka, rs.getString(8));
                Izvestaj izvestaj = new Izvestaj(rs.getInt(16), rs.getInt(17), revizija);
                MonografskiIzvestaj mi = new MonografskiIzvestaj(izvestaj, rs.getString(20));
                OtpisMonografskihPublikacija omp = new OtpisMonografskihPublikacija(mi, rs.getInt(22), rs.getInt(23), rs.getInt(24), revizija);
                
                lista.add(omp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajOtpisMono(OtpisMonografskihPublikacija otpisMono) throws SQLException {
        String upit = "INSERT INTO OTPISMONOGRAFSKIHPUBLIKACIJA (idIzvestaja, idOtpisaM, manjak, skart) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, otpisMono.getIzvestaj().getIzvestaj().getIdIzvestaja());
            ps.setInt(2, otpisMono.getIdOtpisaM());
            ps.setInt(3, otpisMono.getManjak());
            ps.setInt(4, otpisMono.getSkart());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean izbrisiOtpis(OtpisMonografskihPublikacija otpis) throws SQLException{
        String upit = "DELETE FROM OTPISMONOGRAFSKIHPUBLIKACIJA WHERE idIzvestaja = " + otpis.getIzvestaj().getIzvestaj().getIdIzvestaja() + " AND IDOTPISAM = " + otpis.getIdOtpisaM();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public boolean azurirajOtpisMono(OtpisMonografskihPublikacija noviOtpis) throws SQLException {
        
        String upit = "UPDATE OTPISMONOGRAFSKIHPUBLIKACIJA SET idIzvestaja = " + noviOtpis.getIzvestaj().getIzvestaj().getIdIzvestaja() + 
                  ", manjak = " + noviOtpis.getManjak() +
                  ", skart = " + noviOtpis.getSkart() + 
                  ", idRevizije = 99" + 
                  " WHERE idOtpisaM = " + noviOtpis.getIdOtpisaM();
        
        if(noviOtpis.getRevizija() == null){
            upit = "UPDATE OTPISMONOGRAFSKIHPUBLIKACIJA SET idIzvestaja = " + noviOtpis.getIzvestaj().getIzvestaj().getIdIzvestaja() + 
               ", manjak = " + noviOtpis.getManjak() +
               ", skart = " + noviOtpis.getSkart() +
               " WHERE idOtpisaM = " + noviOtpis.getIdOtpisaM();
        }
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public List<Osoba> vratiSveOsobe() throws SQLException{
        ArrayList<Osoba> lista = new ArrayList<>();
        String upit = "SELECT * FROM OSOBA";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                Kontakt kontakt = new Kontakt();
                Struct struct = (Struct) rs.getObject(4);
                Object[] objects = struct.getAttributes();

                String brTelefona = (String) objects[0];
                String email = (String) objects[1];

                kontakt.setBrojTelefona(brTelefona);
                kontakt.setEmail(email);
                
                Osoba osoba = new Osoba(rs.getInt(1), rs.getString(2), rs.getString(3), kontakt);
                
                lista.add(osoba);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajOsobu(Osoba osoba) throws SQLException {
           String upit = "INSERT INTO OSOBA VALUES (?,?,?,KONTAKT_OSOBE(?,?))";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, osoba.getIdOsobe());
            ps.setString(2, osoba.getIme());
            ps.setString(3, osoba.getPrezime());
            ps.setString(4, osoba.getKontakt().getBrojTelefona());
            ps.setString(5, osoba.getKontakt().getEmail());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean sacuvajClana(Clan clan) throws SQLException{
        String upit = "INSERT INTO CLAN VALUES (?,?,?,KOD_CLANA(?))";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, clan.getIdClana());
            ps.setString(2, clan.getIme());
            ps.setString(3, clan.getPrezime());
            ps.setString(4, clan.getKodClana().getModelniKod());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public List<Clan> vratiSveClanove() throws SQLException {
        ArrayList<Clan> lista = new ArrayList<>();
        String upit = "SELECT * FROM CLAN";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                KodClana kodClana = new KodClana();
                Struct struct = (Struct) rs.getObject(4);
                Object[] objects = struct.getAttributes();

                String modelniKod = (String) objects[0];

                kodClana.setModelniKod(modelniKod);
                
                Clan clan = new Clan(rs.getInt(1), rs.getString(2), rs.getString(3), kodClana);
                
                lista.add(clan);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<OdlukaUsvajanja> vratiSveOdlukeUsvajanja() throws SQLException{
        ArrayList<OdlukaUsvajanja> lista = new ArrayList<>();
        String upit = "SELECT * FROM odlukausvajanja O JOIN osoba OS ON (O.IDOSOBE = OS.IDOSOBE) \n" +
                      "JOIN REVIZIJA R ON (O.IDREVIZIJE = R.IDREVIZIJE)\n" +
                      "JOIN BIBLIOTEKA B ON (O.IDBIBLIOTEKE = B.IDBIBLIOTEKE)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Kontakt kontakt = new Kontakt();
                Struct struct = (Struct) rs.getObject(10);
                Object[] objects = struct.getAttributes();

                String brTelefona = (String) objects[0];
                String email = (String) objects[1];

                kontakt.setBrojTelefona(brTelefona);
                kontakt.setEmail(email);
                
                Osoba osoba = new Osoba(rs.getInt(7), rs.getString(8), rs.getString(9), kontakt);
                Biblioteka biblioteka = new Biblioteka(rs.getInt(19), rs.getString(20), rs.getString(21), rs.getString(22));
                Revizija revizija = new Revizija(rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getString(14), rs.getString(15), biblioteka, rs.getString(17));
                //Revizija revizija = new Revizija(0, datumPocetka, datumZavrsetka, email, email, komisija, biblioteka, email)
                OdlukaUsvajanja odlukaUsvajanja = new OdlukaUsvajanja(rs.getInt(1), rs.getDate(2), rs.getLong(3), osoba, revizija, biblioteka);
                
                lista.add(odlukaUsvajanja);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<OdlukaUsvajanja> vratiStarijeOdlukeUsvajanja() throws SQLException{
         ArrayList<OdlukaUsvajanja> lista = new ArrayList<>();
        String upit = "SELECT * FROM odlukausvajanja PARTITION (stare_odluke) O JOIN osoba OS ON (O.IDOSOBE = OS.IDOSOBE) \n" +
                      "JOIN REVIZIJA R ON (O.IDREVIZIJE = R.IDREVIZIJE)\n" +
                      "JOIN BIBLIOTEKA B ON (O.IDBIBLIOTEKE = B.IDBIBLIOTEKE)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Kontakt kontakt = new Kontakt();
                Struct struct = (Struct) rs.getObject(10);
                Object[] objects = struct.getAttributes();

                String brTelefona = (String) objects[0];
                String email = (String) objects[1];

                kontakt.setBrojTelefona(brTelefona);
                kontakt.setEmail(email);
                
                Osoba osoba = new Osoba(rs.getInt(7), rs.getString(8), rs.getString(9), kontakt);
                Biblioteka biblioteka = new Biblioteka(rs.getInt(19), rs.getString(20), rs.getString(21), rs.getString(22));
                Revizija revizija = new Revizija(rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getString(14), rs.getString(15), biblioteka, rs.getString(17));
                //Revizija revizija = new Revizija(0, datumPocetka, datumZavrsetka, email, email, komisija, biblioteka, email)
                OdlukaUsvajanja odlukaUsvajanja = new OdlukaUsvajanja(rs.getInt(1), rs.getDate(2), rs.getLong(3), osoba, revizija, biblioteka);
                
                lista.add(odlukaUsvajanja);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<OdlukaUsvajanja> vratiNovijeOdlukeUsvajanja() throws SQLException{
        ArrayList<OdlukaUsvajanja> lista = new ArrayList<>();
        String upit = "SELECT * FROM odlukausvajanja PARTITION (novije_odluke) O JOIN osoba OS ON (O.IDOSOBE = OS.IDOSOBE) \n" +
                      "JOIN REVIZIJA R ON (O.IDREVIZIJE = R.IDREVIZIJE)\n" +
                      "JOIN BIBLIOTEKA B ON (O.IDBIBLIOTEKE = B.IDBIBLIOTEKE)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {

                Kontakt kontakt = new Kontakt();
                Struct struct = (Struct) rs.getObject(10);
                Object[] objects = struct.getAttributes();

                String brTelefona = (String) objects[0];
                String email = (String) objects[1];

                kontakt.setBrojTelefona(brTelefona);
                kontakt.setEmail(email);
                
                Osoba osoba = new Osoba(rs.getInt(7), rs.getString(8), rs.getString(9), kontakt);
                Biblioteka biblioteka = new Biblioteka(rs.getInt(19), rs.getString(20), rs.getString(21), rs.getString(22));
                Revizija revizija = new Revizija(rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getString(14), rs.getString(15), biblioteka, rs.getString(17));
                //Revizija revizija = new Revizija(0, datumPocetka, datumZavrsetka, email, email, komisija, biblioteka, email)
                OdlukaUsvajanja odlukaUsvajanja = new OdlukaUsvajanja(rs.getInt(1), rs.getDate(2), rs.getLong(3), osoba, revizija, biblioteka);
                
                lista.add(odlukaUsvajanja);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajOdlukuUsvajanja(OdlukaUsvajanja odlukaUsvajanja) throws SQLException {
        String upit = "INSERT INTO ODLUKAUSVAJANJA VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, odlukaUsvajanja.getIdOdluke());
            ps.setDate(2, new Date(odlukaUsvajanja.getDatumOdluke().getTime()));
            ps.setInt(3, odlukaUsvajanja.getIdOdluke());
            ps.setInt(4, odlukaUsvajanja.getOsoba().getIdOsobe());
            ps.setInt(5, odlukaUsvajanja.getRevizija().getIdRevizije());
            ps.setInt(6, odlukaUsvajanja.getBiblioteka().getIdBiblioteke());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public List<MonografskaPublikacijaView> vratiMonoPView() throws SQLException{
        ArrayList<MonografskaPublikacijaView> lista = new ArrayList<>();
        String upit = "SELECT * FROM monografskapublikacija_view M JOIN fond F ON (M.IDFONDA = F.IDFONDA) \n" +
                      "JOIN publikacija P ON (M.IDP = P.IDP)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Fond fond = new Fond(rs.getInt(6), rs.getString(7));
                Publikacija publikacija = new Publikacija(rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getString(12));
                MonografskaPublikacijaView mono = new MonografskaPublikacijaView(publikacija, rs.getInt(2), rs.getString(3), rs.getString(4), fond);
                
                lista.add(mono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<MonografskaPublikacijaOsnovno> vratiMonoPOsnovno() throws SQLException{
        ArrayList<MonografskaPublikacijaOsnovno> lista = new ArrayList<>();
        String upit = "SELECT * FROM monografskapublikacija_osnovno M \n" +
                      "JOIN publikacija P ON (M.IDP = P.IDP)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Publikacija publikacija = new Publikacija(rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                MonografskaPublikacijaOsnovno mono = new MonografskaPublikacijaOsnovno(publikacija, rs.getInt(2));
                
                lista.add(mono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<MonografskaPublikacijaDetaljno> vratiMonoPDetaljno() throws SQLException{
         ArrayList<MonografskaPublikacijaDetaljno> lista = new ArrayList<>();
        String upit = "SELECT * FROM monografskapublikacija_detaljno M JOIN fond F ON (M.IDFONDA = F.IDFONDA) \n" +
                      "JOIN publikacija P ON (M.IDP = P.IDP)";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Fond fond = new Fond(rs.getInt(5), rs.getString(6));
                Publikacija publikacija = new Publikacija(rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11));
                MonografskaPublikacijaDetaljno mono = new MonografskaPublikacijaDetaljno(publikacija, rs.getString(2), rs.getString(3), fond);
                
                lista.add(mono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<Publikacija> vratiSvePublikacije() throws SQLException{
        ArrayList<Publikacija> lista = new ArrayList<>();
        String upit = "SELECT * FROM publikacija";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                
                Publikacija publikacija = new Publikacija(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
                
                lista.add(publikacija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<Fond> vratiSveFondove() throws SQLException{
        ArrayList<Fond> lista = new ArrayList<>();
        String upit = "SELECT * FROM fond";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Fond fond = new Fond(rs.getInt(1), rs.getString(2));
                lista.add(fond);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajMonoP(MonografskaPublikacijaView monoP) throws SQLException {
          String upit = "INSERT INTO MONOGRAFSKAPUBLIKACIJA_VIEW VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, monoP.getPublikacija().getIdP());
            ps.setInt(2, monoP.getIdMono());
            ps.setString(3, monoP.getVrstaPoveza());
            ps.setString(4, monoP.getStanje());
            ps.setInt(5, monoP.getFond().getIdFonda());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean azurirajMonoP(MonografskaPublikacijaView novaMonoP) throws SQLException {
        String upit = "UPDATE monografskapublikacija_view SET idMono = " + novaMonoP.getIdMono() + 
                  ", vrstaPoveza = '" + novaMonoP.getVrstaPoveza() +
                  "' , stanje = '" + novaMonoP.getStanje() + 
                  "' , idFonda = " + novaMonoP.getFond().getIdFonda() +
                  " WHERE idP = " + novaMonoP.getPublikacija().getIdP();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }

    public boolean obrisiMonoP(MonografskaPublikacijaView monoP) throws SQLException {
         String upit = "DELETE FROM monografskapublikacija_view WHERE IDP = " + monoP.getPublikacija().getIdP();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }

    public List<Inventar> vratiSveInventare() throws SQLException{
         ArrayList<Inventar> lista = new ArrayList<>();
        String upit = "SELECT * FROM INVENTAR";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {          
                Inventar inventar = new Inventar(rs.getInt(1), rs.getString(2), rs.getInt(3), null);
                
                lista.add(inventar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public List<StavkeInventara> vratiSveStavkeInventare(Inventar inventar) throws SQLException{
        ArrayList<StavkeInventara> lista = new ArrayList<>();
        String upit = "SELECT * FROM STAVKAINVENTARA S JOIN PUBLIKACIJA P ON (S.IDP = P.IDP) WHERE IDINVENTARA = " + inventar.getIdInventara();
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                Publikacija publikacija = new Publikacija(rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                StavkeInventara si = new StavkeInventara(inventar, rs.getInt(2), rs.getInt(3), publikacija);
                
                lista.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return lista;
    }

    public boolean sacuvajInventar(Inventar inventar) throws SQLException {
        String upit = "INSERT INTO INVENTAR (IDINVENTARA, OPIS) VALUES (?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.setInt(1, inventar.getIdInventara());
            ps.setString(2, inventar.getOpis());
            
            ps.executeUpdate();
            
            if(sacuvajSveStavke(inventar)){
               Konekcija.getInstance().getConnection().commit();
               return true; 
            }else {
                Konekcija.getInstance().getConnection().rollback();
                return false;
            }

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    private boolean sacuvajSveStavke(Inventar inventar) throws SQLException {
        String upit = "INSERT INTO STAVKAINVENTARA VALUES (?,?,?,?)";
        int brojac = 0;
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            for (StavkeInventara stavkeInventara : inventar.getStavkeInventara()) {
                
                brojac++;
                
                stavkeInventara.setInventar(inventar);
                ps.setInt(1, stavkeInventara.getInventar().getIdInventara());
                ps.setInt(2, brojac);
                ps.setInt(3, stavkeInventara.getKolicina());
                ps.setInt(4, stavkeInventara.getPublikacija().getIdP());
                
                ps.addBatch();
            }
            
            ps.executeBatch();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean obrisiStavku(StavkeInventara stavkeInventara) throws SQLException {
        String upit = "DELETE FROM STAVKAINVENTARA WHERE IDINVENTARA = " + stavkeInventara.getInventar().getIdInventara() + "AND RBSTAVKE = " + stavkeInventara.getRbStavke();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean azurirajStavku(StavkeInventara stavkeInventara) throws SQLException {
        String upit = "UPDATE STAVKAINVENTARA SET KOLICINA = " + stavkeInventara.getKolicina() + "WHERE IDINVENTARA = " + stavkeInventara.getInventar().getIdInventara() + "AND RBSTAVKE = " + stavkeInventara.getRbStavke();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean azurirajInventar(Inventar inventar) throws SQLException {
        String upit = "UPDATE INVENTAR SET UKUPNACENA = " + inventar.getUkupnaCena() + " WHERE IDINVENTARA = " + inventar.getIdInventara();
        
        if(inventar.getUkupnaCena() == -1){
            upit = "UPDATE INVENTAR SET OPIS = '" + inventar.getOpis() + "' WHERE IDINVENTARA = " + inventar.getIdInventara();
        }
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    public boolean obrisiInventar(Inventar inventar) throws SQLException {
        String upit = "DELETE FROM INVENTAR WHERE IDINVENTARA = " + inventar.getIdInventara();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);

            if(obrisiSveStavke(inventar)){               
               ps.executeUpdate();
               Konekcija.getInstance().getConnection().commit();
               return true; 
            }else {
                Konekcija.getInstance().getConnection().rollback();
                return false;
            }

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    private boolean obrisiSveStavke(Inventar inventar) throws SQLException{
         String upit = "DELETE FROM STAVKAINVENTARA WHERE IDINVENTARA = " + inventar.getIdInventara();
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();

            return true;

        } catch (SQLException ex) {
            Konekcija.getInstance().getConnection().rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
}
