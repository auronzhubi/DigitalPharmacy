/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import BLL.Stafi;
import BLL.TipiStafit;
import DAL.FarmaciaException;
import DAL.ReportGenerator;
import DAL.StafiRepository;
import DAL.TipiStafitRepository;
import gui.models.StafiTableModel;
import gui.models.TipiStafitComboBoxModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author ASUS
 */
public class RegjistroStafin extends javax.swing.JInternalFrame {

    ButtonGroup group = new ButtonGroup();
    StafiRepository sr = new StafiRepository();
    StafiTableModel stm;

    TipiStafitRepository tsr = new TipiStafitRepository();
    TipiStafitComboBoxModel tscb;

    /**
     * Creates new form StafiForm
     */
    public RegjistroStafin() {
        initComponents();
        group.add(femerS);
        group.add(mashkullS);
        loadTable();
        loadCombobox();
        tabelaSelectedIndexChange();
    }

    public void loadCombobox() {
        List<TipiStafit> list = tsr.findAll();
        tscb = new TipiStafitComboBoxModel(list);
        tipiCB.setModel(tscb);
        tipiCB.repaint();
    }

    public void loadTable() {
        List<Stafi> list = sr.findAll();
        stm = new StafiTableModel(list);
        tabela.setModel(stm);
        stm.fireTableDataChanged();
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Stafi s = stm.getStafi(selectedIndex);
                    emriS.setText(s.getEmri() + "");
                    mbiemriS.setText(s.getMbiemri() + "");
                    dataLindjesS.setDate(s.getDataLindjes());
                    if (s.getGjinia() == 'F') {
                        femerS.setSelected(true);
                    } else if (s.getGjinia() == 'M') {
                        mashkullS.setSelected(true);
                    }
                    tipiCB.setSelectedItem(s.getTipiID());
                    tipiCB.repaint();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        emri = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mbiemri = new javax.swing.JTextField();
        femer = new javax.swing.JRadioButton();
        mashkull = new javax.swing.JRadioButton();
        dataLindjes = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        emriS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        mbiemriS = new javax.swing.JTextField();
        femerS = new javax.swing.JRadioButton();
        mashkullS = new javax.swing.JRadioButton();
        dataLindjesS = new com.toedter.calendar.JDateChooser();
        saveStafiButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        prapa = new javax.swing.JButton();
        fshijStafiButton = new javax.swing.JButton();
        pastroStafiButton = new javax.swing.JButton();
        tipiCB = new javax.swing.JComboBox<>();
        gjenero = new javax.swing.JButton();

        jLabel5.setText("Data Lindjes:");

        jLabel6.setText("Gjinia:");

        jLabel13.setText("Emri:");

        jLabel15.setText("Mbiemri:");

        femer.setText("Femer");
        femer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femerActionPerformed(evt);
            }
        });

        mashkull.setText("Mashkull");
        mashkull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mashkullActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1160, 710));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 710));

        jLabel7.setText("Data Lindjes:");

        jLabel8.setText("Gjinia:");

        jLabel14.setText("Emri:");

        jLabel16.setText("Mbiemri:");

        femerS.setText("Femer");
        femerS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femerSActionPerformed(evt);
            }
        });

        mashkullS.setText("Mashkull");
        mashkullS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mashkullSActionPerformed(evt);
            }
        });

        saveStafiButton.setText("Ruaj");
        saveStafiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStafiButtonActionPerformed(evt);
            }
        });

        jLabel17.setText("Tipi i Stafit:");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela);

        prapa.setText("Prapa");
        prapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prapaActionPerformed(evt);
            }
        });

        fshijStafiButton.setText("Fshij");
        fshijStafiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijStafiButtonActionPerformed(evt);
            }
        });

        pastroStafiButton.setText("Pastro");
        pastroStafiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastroStafiButtonActionPerformed(evt);
            }
        });

        gjenero.setText("Gjenero raportin e stafit");
        gjenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gjeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(prapa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(204, 204, 204)
                                        .addComponent(pastroStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(emriS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(mbiemriS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(dataLindjesS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(femerS)
                                                .addGap(25, 25, 25)
                                                .addComponent(mashkullS))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(saveStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(72, 72, 72)
                                                        .addComponent(fshijStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(tipiCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(0, 208, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(gjenero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emriS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbiemriS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLindjesS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(femerS)
                    .addComponent(mashkullS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshijStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(pastroStafiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gjenero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(prapa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void femerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femerActionPerformed

    private void mashkullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mashkullActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mashkullActionPerformed

    private void femerSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femerSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femerSActionPerformed

    private void mashkullSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mashkullSActionPerformed


    }//GEN-LAST:event_mashkullSActionPerformed

    private void saveStafiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStafiButtonActionPerformed
        // TODO add your handling code here:
        if (!emriS.getText().trim().equals("") && !mbiemriS.getText().trim().equals("") && !dataLindjesS.getDate().equals(null)) {
            int row = tabela.getSelectedRow();
            if (row == -1) {
                Stafi s = new Stafi();
                try{
                s.setEmri(emriS.getText());
                s.setMbiemri(mbiemriS.getText());
                s.setDataLindjes(dataLindjesS.getDate());
                }catch(FarmaciaException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                if (femerS.isSelected()) {
                    s.setGjinia('F');
                } else if (mashkullS.isSelected()) {
                    s.setGjinia('M');
                }
                TipiStafit t = (TipiStafit) tipiCB.getSelectedItem();
                s.setTipiID(t);

                try {
                    sr.create(s);
                } catch (FarmaciaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else {
                Stafi s = stm.getStafi(row);
                try{
                s.setEmri(emriS.getText());
                s.setMbiemri(mbiemriS.getText());
                s.setDataLindjes(dataLindjesS.getDate());
                }catch(FarmaciaException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                if (femerS.isSelected()) {
                    s.setGjinia('F');
                } else if (mashkullS.isSelected()) {
                    s.setGjinia('M');
                }
                TipiStafit t = (TipiStafit) tipiCB.getSelectedItem();
                s.setTipiID(t);

            }
            clear();
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Ju lutem plotesoni fushat obligative");
        }


    }//GEN-LAST:event_saveStafiButtonActionPerformed

    private void prapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prapaActionPerformed
        // TODO add your handling code here:
         Home h = new Home();
        h.dashboard();
        this.setVisible(false);
    }//GEN-LAST:event_prapaActionPerformed

    private void fshijStafiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijStafiButtonActionPerformed
        // TODO add your handling code here:
        int row = tabela.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this,
                    "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            System.out.println("" + i);
            if (i == 0) {
                Stafi s = stm.getStafi(row);
                sr.delete(s);
                loadTable();

            }
            clear();

        } else {
            JOptionPane.showMessageDialog(this, "Nuk ke selektuar asgje!");
        }
    }//GEN-LAST:event_fshijStafiButtonActionPerformed

    private void pastroStafiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastroStafiButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_pastroStafiButtonActionPerformed

    private void gjeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gjeneroActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String path = "C:\\Users\\Auron\\Documents\\NetBeansProjects\\DigitalPharmacy\\src\\Reports\\Stafi.jrxml";
            String emriPDF = "Stafi.pdf";
            ReportGenerator rg = new ReportGenerator();
            rg.gjeneroRaportin(path, emriPDF);
        } catch (SQLException ex) {
            Logger.getLogger(ListaProdukteve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ListaProdukteve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gjeneroActionPerformed

    public void clear() {
        tabela.clearSelection();
        emriS.setText("");
        mbiemriS.setText("");
        dataLindjesS.setDate(null);
        group.clearSelection();
        tipiCB.setSelectedItem(null);
        tipiCB.repaint();
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataLindjes;
    private com.toedter.calendar.JDateChooser dataLindjesS;
    private javax.swing.JTextField emri;
    private javax.swing.JTextField emriS;
    private javax.swing.JRadioButton femer;
    private javax.swing.JRadioButton femerS;
    private javax.swing.JButton fshijStafiButton;
    private javax.swing.JButton gjenero;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton mashkull;
    private javax.swing.JRadioButton mashkullS;
    private javax.swing.JTextField mbiemri;
    private javax.swing.JTextField mbiemriS;
    private javax.swing.JButton pastroStafiButton;
    private javax.swing.JButton prapa;
    private javax.swing.JButton saveStafiButton;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<TipiStafit> tipiCB;
    // End of variables declaration//GEN-END:variables
}