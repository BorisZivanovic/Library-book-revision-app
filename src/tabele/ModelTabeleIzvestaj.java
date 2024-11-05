/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
import domen.Izvestaj;
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
public class ModelTabeleIzvestaj extends AbstractTableModel{
    
    List<Izvestaj> lista;
    String kolone[] = {"Sifra", "Broj jedinica u katalogu", "id revizije"};
    
    public ModelTabeleIzvestaj(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveIzvestaje();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleIzvestaj.class.getName()).log(Level.SEVERE, null, ex);
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
        Izvestaj izvestaj = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return izvestaj.getIdIzvestaja();
            case 1:
                return izvestaj.getBrojJediniceUElKatalogu();
            case 2:
                return izvestaj.getRevizija().getIdRevizije();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Izvestaj> izvestajiLista = Kontroler.getInstance().vratiSveIzvestaje();
        this.lista = izvestajiLista;
        fireTableDataChanged();
    }

    public Izvestaj vratiRed(int row) {
        return lista.get(row);
    }
    
}
