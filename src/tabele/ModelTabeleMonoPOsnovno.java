/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.MonografskaPublikacijaOsnovno;
import domen.MonografskaPublikacijaView;
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
public class ModelTabeleMonoPOsnovno extends AbstractTableModel{
    
     List<MonografskaPublikacijaOsnovno> lista;
    String kolone[] = {"id publikacije", "id mono"};
    
    public ModelTabeleMonoPOsnovno(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiMonoPOsnovno();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleMonoPOsnovno.class.getName()).log(Level.SEVERE, null, ex);
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
        MonografskaPublikacijaOsnovno monoPOsnovno = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return monoPOsnovno.getPublikacija().getIdP();
            case 1:
                return monoPOsnovno.getIdMono();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<MonografskaPublikacijaOsnovno> monoPOsnovnoLista = Kontroler.getInstance().vratiMonoPOsnovno();
        this.lista = monoPOsnovnoLista;
        fireTableDataChanged();
    }

    public MonografskaPublikacijaOsnovno vratiRed(int row) {
        return lista.get(row);
    }
    
}
