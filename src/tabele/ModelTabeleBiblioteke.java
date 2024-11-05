/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
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
public class ModelTabeleBiblioteke extends AbstractTableModel{
    
    List<Biblioteka> lista;
    String kolone[] = {"Sifra", "Naziv", "Adresa", "Vrsta"};
    
    public ModelTabeleBiblioteke(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveBiblioteke();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleBiblioteke.class.getName()).log(Level.SEVERE, null, ex);
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
        Biblioteka biblioteka = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return biblioteka.getIdBiblioteke();
            case 1:
                return biblioteka.getNaziv();
            case 2:
                return biblioteka.getAdresa();
            case 3:
                return biblioteka.getVrsta();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Biblioteka> bibliotekeLista = Kontroler.getInstance().vratiSveBiblioteke();
        this.lista = bibliotekeLista;
        fireTableDataChanged();
    }

    public Biblioteka vratiRed(int row) {
        return lista.get(row);
    }
    
}
