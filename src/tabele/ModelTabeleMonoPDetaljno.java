/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.MonografskaPublikacijaDetaljno;
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
public class ModelTabeleMonoPDetaljno extends AbstractTableModel{
     List<MonografskaPublikacijaDetaljno> lista;
    String kolone[] = {"id publikacije", "vrsta poveza", "stanje", "fond"};
    
    public ModelTabeleMonoPDetaljno(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiMonoPDetaljno();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleMonoPDetaljno.class.getName()).log(Level.SEVERE, null, ex);
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
        MonografskaPublikacijaDetaljno monoPdet = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return monoPdet.getPublikacija().getIdP();
            case 1:
                return monoPdet.getVrstaPoveza();
            case 2:
                return monoPdet.getStanje();
            case 3:
                return monoPdet.getFond().getNaziv();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<MonografskaPublikacijaDetaljno> monoPDetLista = Kontroler.getInstance().vratiMonoPDetaljno();
        this.lista = monoPDetLista;
        fireTableDataChanged();
    }

    public MonografskaPublikacijaDetaljno vratiRed(int row) {
        return lista.get(row);
    }
    
}
