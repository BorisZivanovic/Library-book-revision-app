/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
import domen.OtpisMonografskihPublikacija;
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
public class ModelTabeleOtpisMono extends AbstractTableModel{
    
    List<OtpisMonografskihPublikacija> lista;
    String kolone[] = {"id izvestaja", "id otpisa", "manjak", "skart","Id revizije"};
    
    public ModelTabeleOtpisMono(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveOtpisMonoP();
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
        OtpisMonografskihPublikacija otpisMonografskihPublikacija = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return otpisMonografskihPublikacija.getIzvestaj().getIzvestaj().getIdIzvestaja();
            case 1:
                return otpisMonografskihPublikacija.getIdOtpisaM();
            case 2:
                return otpisMonografskihPublikacija.getManjak();
            case 3:
                return otpisMonografskihPublikacija.getSkart();
            case 4:
            return otpisMonografskihPublikacija.getRevizija().getIdRevizije();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<OtpisMonografskihPublikacija> otpisMonoLista = Kontroler.getInstance().vratiSveOtpisMonoP();
        this.lista = otpisMonoLista;
        fireTableDataChanged();
    }

    public OtpisMonografskihPublikacija vratiRed(int row) {
        return lista.get(row);
    }
    
}
