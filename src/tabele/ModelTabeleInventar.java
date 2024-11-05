/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Inventar;
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
public class ModelTabeleInventar extends AbstractTableModel{
    
    List<Inventar> lista;
    String kolone[] = {"id inventara", "opis", "ukupna cena"};
    
    public ModelTabeleInventar(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveInventare();
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
        Inventar inventar = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventar.getIdInventara();
            case 1:
                return inventar.getOpis();
            case 2:
                return inventar.getUkupnaCena();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Inventar> inventariLista = Kontroler.getInstance().vratiSveInventare();
        this.lista = inventariLista;
        fireTableDataChanged();
    }

    public Inventar vratiRed(int row) {
        return lista.get(row);
    }

    public int vratiUkupnuCenuIzInventara(Inventar inventar) {
        for (Inventar inventar1 : lista) {
            if(inventar1.getIdInventara() == inventar.getIdInventara()){
                return inventar1.getUkupnaCena();
            }
        }
        return 0;
    }
    
}
