/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Inventar;
import domen.Publikacija;
import domen.StavkeInventara;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logika.Kontroler;
import tabele.ModelTabeleInventar;
import tabele.ModelTabeleNoveStavkeInventara;
import tabele.ModelTabelePubliakcija;
import tabele.ModelTabeleRevizija;

/**
 *
 * @author Jaca
 */
public class InventarForma extends javax.swing.JFrame {

    int brojac = 0;
    
    /**
     * Creates new form InventarForma
     */
    public InventarForma() {
        initComponents();
        tblPublikacije.setModel(new ModelTabelePubliakcija());
        tblInventar.setModel(new ModelTabeleInventar());
        tblNoveStavke.setModel(new ModelTabeleNoveStavkeInventara());
        txtUkupnaCena.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOpis = new javax.swing.JTextField();
        txtIdInventara = new javax.swing.JTextField();
        txtUkupnaCena = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        dodajStavku = new javax.swing.JButton();
        obrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventar = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPublikacije = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnInventar = new javax.swing.JButton();
        btnIzmeniInventar = new javax.swing.JButton();
        btnPrikaziStavke = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNoveStavke = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnIzmeniInventar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("id Inventara:");

        jLabel2.setText("opis:");

        jLabel3.setText("ukupna cena:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke inventara"));

        jLabel6.setText("Kolicina:");

        dodajStavku.setText("DODAJ STAVKU");
        dodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajStavkuActionPerformed(evt);
            }
        });

        obrisiStavku.setText("OBRISI STAVKU");
        obrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisiStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(txtKolicina)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dodajStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obrisiStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dodajStavku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(obrisiStavku)
                .addGap(18, 18, 18))
        );

        tblInventar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblInventar);

        tblPublikacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPublikacije);

        jLabel4.setText("tabela inventara:");

        jLabel5.setText("tabela publikacija");

        btnInventar.setText("SACUVAJ INVENTAR");
        btnInventar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarActionPerformed(evt);
            }
        });

        btnIzmeniInventar.setText("IZMENI INVENTAR");
        btnIzmeniInventar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniInventarActionPerformed(evt);
            }
        });

        btnPrikaziStavke.setText("PRIKAZI STAVKE");
        btnPrikaziStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziStavkeActionPerformed(evt);
            }
        });

        tblNoveStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblNoveStavke);

        jLabel7.setText("nove stavke:");

        btnIzmeniInventar1.setText("OBRISI INVENTAR");
        btnIzmeniInventar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniInventar1ActionPerformed(evt);
            }
        });

        jButton1.setText("REFRESH TABELE INVENTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNazad.setText("VRATI SE NAZAD");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOpis, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txtUkupnaCena)
                            .addComponent(txtIdInventara, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInventar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(btnPrikaziStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnIzmeniInventar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeniInventar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnNazad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(160, 160, 160))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(17, 17, 17))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdInventara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInventar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrikaziStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNazad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzmeniInventar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIzmeniInventar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajStavkuActionPerformed
        try {
            if (txtKolicina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti kolicinu stavke!");
                return;
            }
            int rbStavke = brojac+1;
            brojac++;
            //int idInventara = Integer.parseInt(txtIdInventara.getText());
            int kolicina = Integer.parseInt(txtKolicina.getText());
            
            int row = tblPublikacije.getSelectedRow();
            
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Odaberite red u tabeli publikacija!");
                return;
            }
            ModelTabelePubliakcija mtp = (ModelTabelePubliakcija) tblPublikacije.getModel();
            Publikacija publikacija = mtp.vratiRed(row);
            
            StavkeInventara novaStavka = new StavkeInventara(null, -1, kolicina, publikacija);

            ModelTabeleNoveStavkeInventara noveStavke = (ModelTabeleNoveStavkeInventara) tblNoveStavke.getModel();
            noveStavke.dodajStavku(novaStavka);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventarForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodajStavkuActionPerformed

    private void obrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisiStavkuActionPerformed
        int row = tblNoveStavke.getSelectedRow();

        if (row != -1) {
            ModelTabeleNoveStavkeInventara noveStavke = (ModelTabeleNoveStavkeInventara) tblNoveStavke.getModel();
            noveStavke.obrisiStavku(row);
            brojac--;
        }
        else{
           JOptionPane.showMessageDialog(this, "Odaberite stavku za brisanje!");
        }
    }//GEN-LAST:event_obrisiStavkuActionPerformed

    private void btnInventarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarActionPerformed
        
       try{           
       
       int idInventara = Integer.parseInt(txtIdInventara.getText());
       String opis = txtOpis.getText();
                   
       ModelTabeleNoveStavkeInventara noveStavke = (ModelTabeleNoveStavkeInventara) tblNoveStavke.getModel();
       
       if (noveStavke.getLista().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti barem jednu stavku!");
            return;
        }
       
       List<StavkeInventara> stavkeInventara = noveStavke.getLista();
       
       Inventar inventar = new Inventar(idInventara, opis, stavkeInventara);
        
       boolean uspesno = Kontroler.getInstance().sacuvajInventar(inventar);
       
       if(uspesno){
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan inventar i stavke!");
            ModelTabeleInventar mti = (ModelTabeleInventar) tblInventar.getModel();
            mti.refreshTabele();
            noveStavke.resetujListu();
            int ukupnaCena = mti.vratiUkupnuCenuIzInventara(inventar);
            txtUkupnaCena.setText(String.valueOf(ukupnaCena));
        }
       
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnInventarActionPerformed

    private void btnPrikaziStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziStavkeActionPerformed
        try{ 
        int row = tblInventar.getSelectedRow();
            
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Odaberite red u tabeli inventar!");
                return;
            }
        
        ModelTabeleInventar mti = (ModelTabeleInventar) tblInventar.getModel();
        Inventar inventar = mti.vratiRed(row);
            
            
        PrikazStavkiForma psf = new PrikazStavkiForma(this, true, inventar);
        psf.setVisible(true);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnPrikaziStavkeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        ModelTabeleInventar mti = (ModelTabeleInventar) tblInventar.getModel();
        mti.refreshTabele();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnIzmeniInventarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniInventarActionPerformed
        try{ 
            
        int row = tblInventar.getSelectedRow();
            
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Odaberite red u tabeli inventar!");
                return;
            }
        ModelTabeleInventar mti = (ModelTabeleInventar) tblInventar.getModel();
        Inventar inventar = mti.vratiRed(row);
        
        IzmeniInventarForma iif = new IzmeniInventarForma(this, true, inventar);
        iif.setVisible(true);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnIzmeniInventarActionPerformed

    private void btnIzmeniInventar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniInventar1ActionPerformed
         try{ 
            
        int row = tblInventar.getSelectedRow();
            
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Odaberite red u tabeli inventar!");
                return;
            }
        ModelTabeleInventar mti = (ModelTabeleInventar) tblInventar.getModel();
        Inventar inventar = mti.vratiRed(row);
        
        boolean uspesno = Kontroler.getInstance().obrisiInventar(inventar);
       
       if(uspesno){
            JOptionPane.showMessageDialog(this, "Uspesno obrisan inventar i stavke!");
            mti.refreshTabele();
        }
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnIzmeniInventar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInventar;
    private javax.swing.JButton btnIzmeniInventar;
    private javax.swing.JButton btnIzmeniInventar1;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnPrikaziStavke;
    private javax.swing.JButton dodajStavku;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton obrisiStavku;
    private javax.swing.JTable tblInventar;
    private javax.swing.JTable tblNoveStavke;
    private javax.swing.JTable tblPublikacije;
    private javax.swing.JTextField txtIdInventara;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtOpis;
    private javax.swing.JTextField txtUkupnaCena;
    // End of variables declaration//GEN-END:variables
}
