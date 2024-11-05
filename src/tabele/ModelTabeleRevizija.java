/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Biblioteka;
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
public class ModelTabeleRevizija extends AbstractTableModel{
    
    List<Revizija> lista;
    String kolone[] = {"idRevizije", "DatumPocetka", "DatumZavrsetka", "Zakon", "Gradja", "Komisija", "idBiblioteke", "nazivBiblioteke"};
    
    public ModelTabeleRevizija(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveRevizije();
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
        Revizija revizija = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return revizija.getIdRevizije();
            case 1:
                return sdf.format(revizija.getDatumPocetka());
            case 2:
                return sdf.format(revizija.getDatumZavrsetka());
            case 3:
                return revizija.getZakon();
            case 4:
                return revizija.getGradja();
            case 5:
                return revizija.getKomisija().getNaziv();
            case 6:
                return revizija.getBiblioteka().getIdBiblioteke();
            case 7:
                return revizija.getNazivBiblioteke();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Revizija> revizijaLista = Kontroler.getInstance().vratiSveRevizije();
        this.lista = revizijaLista;
        fireTableDataChanged();
    }

    public Revizija vratiRed(int row) {
        return lista.get(row);
    }
    
}
