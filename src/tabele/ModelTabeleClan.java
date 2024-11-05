/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.Clan;
import domen.Osoba;
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
public class ModelTabeleClan extends AbstractTableModel{

    List<Clan> lista;
    String kolone[] = {"Sifra", "Ime", "Prezime", "Kontakt"};
    
    public ModelTabeleClan(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiSveClanove();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModelTabeleClan.class.getName()).log(Level.SEVERE, null, ex);
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
        Clan clan = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clan.getIdClana();
            case 1:
                return clan.getIme();
            case 2:
                return clan.getPrezime();
            case 3:
                return clan.getKodClana().getModelniKod();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<Clan> clanoviLista = Kontroler.getInstance().vratiSveClanove();
        this.lista = clanoviLista;
        fireTableDataChanged();
    }

    public Clan vratiRed(int row) {
        return lista.get(row);
    }
    
}
