/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Inventar;
import domen.StavkeInventara;
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
public class ModelTabeleNoveStavkeInventara extends AbstractTableModel{
    
     List<StavkeInventara> lista;
    String kolone[] = {"kolicina", "publikacija"};
    
    public ModelTabeleNoveStavkeInventara(){
        
        try {
        lista = new ArrayList<>();
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
        StavkeInventara stavkaInventara = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavkaInventara.getKolicina();
            case 1:
                return stavkaInventara.getPublikacija().getNaziv();    
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public StavkeInventara vratiRed(int row) {
        return lista.get(row);
    }

    public void dodajStavku(StavkeInventara novaStavka) {
        lista.add(novaStavka);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    public List<StavkeInventara> getLista() {
        return lista;
    }

    public void resetujListu() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }
    
}
