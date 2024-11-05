/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import domen.OdlukaUsvajanja;
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
public class ModelTabeleNovijeOdluke extends AbstractTableModel{
    
     List<OdlukaUsvajanja> lista;
    String kolone[] = {"idOdluke", "datum odluke", "broj za zalbe", "idOsobe", "idRevizije", "idBiblioteke"};
    
    public ModelTabeleNovijeOdluke(){
        
        try {
        lista = new ArrayList<>();
        lista = Kontroler.getInstance().vratiNovijeOdlukeUsvajanja();
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
        OdlukaUsvajanja odlukaUsvajanja = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return odlukaUsvajanja.getIdOdluke();
            case 1:
                return sdf.format(odlukaUsvajanja.getDatumOdluke());
            case 3:
                return odlukaUsvajanja.getOsoba().getIdOsobe();
            case 2:
                return odlukaUsvajanja.getBrojZaZalbe();
            case 4:
                return odlukaUsvajanja.getRevizija().getIdRevizije();
            case 5:
                return odlukaUsvajanja.getBiblioteka().getIdBiblioteke();
            default:
                return "return!";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void refreshTabele() throws Exception {
        List<OdlukaUsvajanja> odlukeLista = Kontroler.getInstance().vratiNovijeOdlukeUsvajanja();
        this.lista = odlukeLista;
        fireTableDataChanged();
    }

    public OdlukaUsvajanja vratiRed(int row) {
        return lista.get(row);
    }
    
}
