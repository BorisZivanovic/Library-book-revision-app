/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.OtpisMonografskihPublikacija;
import domen.Publikacija;
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
public class ModelTabelePubliakcija extends AbstractTableModel{
    
     List<Publikacija> lista;
    String kolone[] = {"id publikacije", "naziv", "cena", "broj strana", "tip"};
    
    public ModelTabelePubliakcija(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSvePublikacije();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleOtpisMono.class.getName()).log(Level.SEVERE, null, ex);
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
        Publikacija publikacija = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return publikacija.getIdP();
            case 1:
                return publikacija.getNaziv();
            case 2:
            return publikacija.getCena();
            case 3:
                return publikacija.getBrojStrana();
            case 4:
                return publikacija.getTip();

            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Publikacija> publikacijaLista = Kontroler.getInstance().vratiSvePublikacije();
        this.lista = publikacijaLista;
        fireTableDataChanged();
    }

    public Publikacija vratiRed(int row) {
        return lista.get(row);
    }
    
}
