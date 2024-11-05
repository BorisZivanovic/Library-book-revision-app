/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.MonografskaPublikacijaView;
import domen.Revizija;
import java.text.SimpleDateFormat;
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
public class ModelTabeleMonoPView extends AbstractTableModel{
    
     List<MonografskaPublikacijaView> lista;
    String kolone[] = {"id publikacije", "id mono", "vrsta poveza", "stanje", "fond"};
    
    public ModelTabeleMonoPView(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiMonoPView();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleRevizija.class.getName()).log(Level.SEVERE, null, ex);
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
        MonografskaPublikacijaView monoPdet = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return monoPdet.getPublikacija().getIdP();
            case 1:
                return monoPdet.getIdMono();
            case 2:
                return monoPdet.getVrstaPoveza();
            case 3:
                return monoPdet.getStanje();
            case 4:
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
        List<MonografskaPublikacijaView> monoPDetLista = Kontroler.getInstance().vratiMonoPView();
        this.lista = monoPDetLista;
        fireTableDataChanged();
    }

    public MonografskaPublikacijaView vratiRed(int row) {
        return lista.get(row);
    }
    
}
