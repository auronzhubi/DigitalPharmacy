/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import BLL.LlojiProduktit;
import BLL.ProduktetEFurnizuesit;
import BLL.ProduktetETerapise;
import BLL.Produkti;
import DAL.FarmaciaException;
import DAL.LlojiProduktitRepository;
import DAL.ProduktetEFurnizuesitRepository;
import DAL.ProduktetETerapiseRepository;
import DAL.ProduktiInterface;
import DAL.ProduktiRepository;
import gui.models.LlojiProduktitComboboxModel;
import gui.models.ProduktiTableModel;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ASUS
 */
public class RegjistroProduktin extends javax.swing.JInternalFrame {

    ProduktiInterface pir = new ProduktiRepository();
    ProduktiTableModel ptm;

    LlojiProduktitRepository lpr = new LlojiProduktitRepository();
    LlojiProduktitComboboxModel lpcb;
    
    ProduktetETerapiseRepository ptr = new ProduktetETerapiseRepository();
    
    ProduktetEFurnizuesitRepository pfr = new ProduktetEFurnizuesitRepository();

    /**
     * Creates new form RegjistroProduktin
     */
    public RegjistroProduktin() {
        initComponents();
        loadTable();
        loadCombobox();
        tabelaSelectedIndexChange();
    }

    public void loadCombobox() {
        List<LlojiProduktit> list = lpr.findAll();
        lpcb = new LlojiProduktitComboboxModel(list);
        llojiCB.setModel(lpcb);
        llojiCB.repaint();
    }

    public void loadTable() {
        try {

            List<Produkti> list = pir.findAll();
            ptm = new ProduktiTableModel(list);
            tabela.setModel(ptm);
            ptm.fireTableDataChanged();
        } catch (FarmaciaException se) {
            JOptionPane.showMessageDialog(this, se.getMessage());

        }

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
                    Produkti p = ptm.getProdukti(selectedIndex);
                    jTextField1.setText(p.getProduktiID() + "");
                    jTextField2.setText(p.getNumriSerik() + "");
                    jTextField3.setText(p.getEmri());
                    jTextField4.setText(p.getPerbersiBaze());
                    data.setDate(p.getDataSkadimit());
                    jTextField6.setText(p.getNumriTabletave() + "");
                    llojiCB.setSelectedItem(p.getLlojiProduktitID());
                    llojiCB.repaint();

                    jTextField8.setText(p.getQmimi() + "");
                    jTextField9.setText(p.getQmimiFurnizues() + "");
                    jTextField10.setText(p.getProdhuesi());
                    jTextField11.setText(p.getShtetiProdhimit());
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        data = new com.toedter.calendar.JDateChooser();
        fshijProduktinButton = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        prapa = new javax.swing.JButton();
        llojiCB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(3, 165, 50));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Regjistro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(3, 165, 50));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Pastro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        fshijProduktinButton.setBackground(new java.awt.Color(3, 165, 50));
        fshijProduktinButton.setForeground(new java.awt.Color(255, 255, 255));
        fshijProduktinButton.setText("Fshij");
        fshijProduktinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijProduktinButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Barkodi");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Numri serise:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Perberesi Baze");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Emri");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Data Skadimit");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Numri Tabletave");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Lloji i produktit");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Cmimi Shites");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Cmimi Furnizues");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Prodhuesi");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Shteti i prodhimit");

        prapa.setBackground(new java.awt.Color(3, 165, 50));
        prapa.setForeground(new java.awt.Color(255, 255, 255));
        prapa.setText("Prapa");
        prapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prapaActionPerformed(evt);
            }
        });

        llojiCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llojiCBActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1044, Short.MAX_VALUE)
                .addComponent(prapa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fshijProduktinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(llojiCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(prapa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(llojiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fshijProduktinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(211, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (!jTextField1.getText().trim().equals("") && !jTextField2.getText().trim().equals("") && !jTextField3.getText().trim().equals("")) {
            int row = tabela.getSelectedRow();
            if (row == -1) {
                Produkti p = new Produkti();
                try {
                    if(jTextField1.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Barkodi nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField2.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Numri serik nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    p.setProduktiID(Integer.parseInt(jTextField1.getText()));
                    p.setNumriSerik(Integer.parseInt(jTextField2.getText()));
                    p.setEmri(jTextField3.getText());
                    p.setPerbersiBaze(jTextField4.getText());
                    p.setDataSkadimit(data.getDate());
                    if(jTextField6.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Numri tabletave nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    p.setNumriTabletave(Integer.parseInt(jTextField6.getText()));
                    LlojiProduktit lp = (LlojiProduktit) llojiCB.getSelectedItem();
                    p.setLlojiProduktitID(lp);
                    if(jTextField8.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Cmimi nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField9.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Cmimi furnizues nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    p.setQmimi(new BigDecimal(jTextField8.getText()));
                    p.setQmimiFurnizues(new BigDecimal(jTextField9.getText()));
                    p.setProdhuesi(jTextField10.getText());
                    p.setShtetiProdhimit(jTextField11.getText());
                    try {
                        pir.create(p);
                    } catch (FarmaciaException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                        
                    }
                } catch (FarmaciaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                    return;
                }

            } else {
                Produkti p = ptm.getProdukti(row);
                try {
                    if(jTextField1.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Barkodi nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField2.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Numri serik nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField6.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Numri tabletave nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField8.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Cmimi nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    if(jTextField9.getText().contains("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(this, "Cmimi furnizues nuk mund te permbaje shkronja");
                        return;
                        
                    }
                    p.setProduktiID(Integer.parseInt(jTextField1.getText()));
                    p.setNumriSerik(Integer.parseInt(jTextField2.getText()));
                    p.setEmri(jTextField3.getText());
                    p.setPerbersiBaze(jTextField4.getText());
                    p.setNumriTabletave(Integer.parseInt(jTextField6.getText()));
                    LlojiProduktit lp = (LlojiProduktit) llojiCB.getSelectedItem();
                    p.setLlojiProduktitID(lp);
                    p.setQmimi(new BigDecimal(jTextField8.getText()));
                    p.setQmimiFurnizues(new BigDecimal(jTextField9.getText()));
                    p.setProdhuesi(jTextField10.getText());
                    p.setShtetiProdhimit(jTextField11.getText());
                    try {
                        pir.edit(p);
                    } catch (FarmaciaException ex) {
                        Logger.getLogger(RegjistroProduktin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FarmaciaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            clear();
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Ju lutem plotesoni fushat obligative");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fshijProduktinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijProduktinButtonActionPerformed
        // TODO add your handling code here:
        int row = tabela.getSelectedRow();
        if (row != -1) {
            Produkti p = ptm.getProdukti(row);
            List<ProduktetETerapise> produktetETerapise = p.getProduktetETerapiseList();
            List<ProduktetEFurnizuesit> produktetEFurnizuesit = p.getProduktetEFurnizuesitList();
            if (produktetETerapise.isEmpty() && produktetEFurnizuesit.isEmpty()) {
                Object[] ob = {"Po", "Jo"};
                int i = JOptionPane.showOptionDialog(this,
                        "A dëshironi ta fshini ?", "Fshirja",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                System.out.println("" + i);
                if (i == 0) {
                    try {
                        pir.delete(p);
                    } catch (FarmaciaException ex) {
                        Logger.getLogger(ListaProdukteve.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadTable();
                }
            } else {
                Object[] ob = {"Po", "Jo"};
                int i = JOptionPane.showOptionDialog(this,
                        "Ekzistojne terapi qe i permbajne kete produkt,me fshirjen e ketij produkti "
                        + "do te fshihen te gjitha terapite dhe furnizuesit.Deshirone t'a fshini?", "Fshirja",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                System.out.println("" + i);
                if (i == 0) {

                    for (int j = 0; j < produktetETerapise.size(); j++) {
                       
                        ptr.deleteProduktetETerapise(produktetETerapise.get(j));
                    }
                    for (int j = 0; j < produktetEFurnizuesit.size(); j++) {
                        pfr.deleteProduktetEFurnizuesit(produktetEFurnizuesit.get(j));
                    }
                    try {
                        pir.delete(p);
                    } catch (FarmaciaException ex) {
                        Logger.getLogger(ListaProdukteve.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadTable();

                }
            }

            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Nuk ke selektuar asgje!");
        }
    }//GEN-LAST:event_fshijProduktinButtonActionPerformed

    public void clear() {
        tabela.clearSelection();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        //data.setDate(null);
        jTextField6.setText("");
        llojiCB.setSelectedItem(null);
        llojiCB.repaint();
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");

    }
    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void prapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prapaActionPerformed
        // TODO add your handling code here:   
        
        Home h = new Home();
        h.dashboard();
        this.setVisible(false);

    }//GEN-LAST:event_prapaActionPerformed

    private void llojiCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llojiCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llojiCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JButton fshijProduktinButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JComboBox<LlojiProduktit> llojiCB;
    private javax.swing.JButton prapa;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
