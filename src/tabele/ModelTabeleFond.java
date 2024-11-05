/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Fond;
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
public class ModelTabeleFond extends AbstractTableModel{
    
    List<Fond> lista;
    String kolone[] = {"id fonda", "naziv"};
    
    public ModelTabeleFond(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveFondove();
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
        Fond fond = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fond.getIdFonda();
            case 1:
                return fond.getNaziv();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Fond> fondoviLista = Kontroler.getInstance().vratiSveFondove();
        this.lista = fondoviLista;
        fireTableDataChanged();
    }

    public Fond vratiRed(int row) {
        return lista.get(row);
    }
    
}
