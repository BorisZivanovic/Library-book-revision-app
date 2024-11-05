/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
import domen.Osoba;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import logika.Kontroler;

/**
 *
 * @author Jaca
 */
public class ModelTabeleOsoba extends AbstractTableModel{
    
     List<Osoba> lista;
    String kolone[] = {"Sifra", "Ime", "Prezime", "Kontakt"};
    
    public ModelTabeleOsoba(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveOsobe();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleBiblioteke.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Osoba osoba = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return osoba.getIdOsobe();
            case 1:
                return osoba.getIme();
            case 2:
                return osoba.getPrezime();
            case 3:
                return osoba.getKontakt().getEmail() + " - " + osoba.getKontakt().getBrojTelefona();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Osoba> osobeLista = Kontroler.getInstance().vratiSveOsobe();
        this.lista = osobeLista;
        fireTableDataChanged();
    }

    public Osoba vratiRed(int row) {
        return lista.get(row);
    }
    
}
