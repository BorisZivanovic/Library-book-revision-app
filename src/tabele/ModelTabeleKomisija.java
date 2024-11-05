/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
import domen.Komisija;
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
public class ModelTabeleKomisija extends AbstractTableModel{
    
     List<Komisija> lista;
    String kolone[] = {"Sifra", "Naziv", "Opis"};
    
    public ModelTabeleKomisija(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveKomisije();
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
        Komisija komisija = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return komisija.getIdKomisije();
            case 1:
                return komisija.getNaziv();
            case 2:
                return komisija.getOpis();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Komisija> komisijeLista = Kontroler.getInstance().vratiSveKomisije();
        this.lista = komisijeLista;
        fireTableDataChanged();
    }

    public Komisija vratiRed(int row) {
        return lista.get(row);
    }
    
}
