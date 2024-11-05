/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
import domen.MonografskiIzvestaj;
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
public class ModelTabeleMonografskiIzvestaj extends AbstractTableModel{
    
    List<MonografskiIzvestaj> lista;
    String kolone[] = {"idIzvestaja", "broj jedinica u izvestaju", "sifra mono izvestaja"};
    
    public ModelTabeleMonografskiIzvestaj(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveMonoIzvestaje();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleMonografskiIzvestaj.class.getName()).log(Level.SEVERE, null, ex);
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
        MonografskiIzvestaj monografskiIzvestaj = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return monografskiIzvestaj.getIzvestaj().getIdIzvestaja();
            case 1:
                return monografskiIzvestaj.getIzvestaj().getBrojJediniceUElKatalogu();
            case 2:
                return monografskiIzvestaj.getSifraM();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<MonografskiIzvestaj> monoIzvestajiLista = Kontroler.getInstance().vratiSveMonoIzvestaje();
        this.lista = monoIzvestajiLista;
        fireTableDataChanged();
    }

    public MonografskiIzvestaj vratiRed(int row) {
        return lista.get(row);
    }
    
}
