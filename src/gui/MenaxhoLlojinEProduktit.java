/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import BLL.LlojiProduktit;
import BLL.Produkti;
import DAL.FarmaciaException;
import DAL.LlojiProduktitRepository;
import DAL.ProduktiRepository;
import gui.models.LlojiProduktitTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ASUS
 */
public class MenaxhoLlojinEProduktit extends javax.swing.JInternalFrame {
    
    LlojiProduktitRepository lpr = new LlojiProduktitRepository();
    LlojiProduktitTableModel lptm;
    
    ProduktiRepository pr = new ProduktiRepository();
    
    /**
     * Creates new form MenaxhoLlojinEProduktit
     */
    public MenaxhoLlojinEProduktit() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
    }
    
    public void loadTable() {
        List<LlojiProduktit> lista = lpr.findAll();
        lptm = new LlojiProduktitTableModel(lista);
        tabela.setModel(lptm);
        lptm.fireTableDataChanged(); 
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
                if (selectedIndex > -1){
                    LlojiProduktit t = lptm.getLlojiProduktit(selectedIndex);
                    emriLlojit.setText(t.getLlojiProduktit());
                
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
        fshij = new javax.swing.JButton();
        shto = new javax.swing.JButton();
        emriLlojit = new javax.swing.JTextField();
        emri = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 710));

        fshij.setText("Fshij");
        fshij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijActionPerformed(evt);
            }
        });

        shto.setText("Shto");
        shto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoActionPerformed(evt);
            }
        });

        emriLlojit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriLlojitActionPerformed(evt);
            }
        });

        emri.setText("Emri i Llojit te Produktit:");

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

        jButton1.setText("Prapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emriLlojit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emri, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(shto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fshij, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 605, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emri, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emriLlojit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fshij, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emriLlojitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriLlojitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emriLlojitActionPerformed

    private void shtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoActionPerformed
        // TODO add your handling code here:
        if(!emriLlojit.getText().trim().equals("")){
            int row = tabela.getSelectedRow();
            if (row == -1) {
                LlojiProduktit t = new LlojiProduktit();
                try{
                t.setLlojiProduktit(emriLlojit.getText());
                try {
                    lpr.create(t);
                } catch (FarmaciaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                }catch(FarmaciaException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            else{
                LlojiProduktit ts = lptm.getLlojiProduktit(row);
                try{
                ts.setLlojiProduktit(emriLlojit.getText());
                try {
                    lpr.edit(ts);
                } catch (FarmaciaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                }catch(FarmaciaException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            loadTable();
            clear();
        }else{
            JOptionPane.showMessageDialog(this, "Ju lutem plotesoni fushat obligative");
            
        }
    }//GEN-LAST:event_shtoActionPerformed

    private void fshijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijActionPerformed
        // TODO add your handling code here:
        int row = tabela.getSelectedRow();
        if (row != -1) {
            LlojiProduktit lp = lptm.getLlojiProduktit(row);
            List<Produkti> listaProduktet = lp.getProduktiList();
            if (listaProduktet.isEmpty()) {
                Object[] ob = {"Po", "Jo"};
                int i = JOptionPane.showOptionDialog(this,
                        "A dëshironi ta fshini ?", "Fshirja",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                System.out.println("" + i);
                if (i == 0) {
                    try {
                        lpr.delete(lp);
                    } catch (FarmaciaException ex) {
                        Logger.getLogger(MenaxhoLlojinEProduktit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadTable();
                }
            } else {
                Object[] ob = {"Po", "Jo"};
                int i = JOptionPane.showOptionDialog(this,
                        "Ekzistojne produkte qe e permbajne kete lloj.Me fshirjen e ketij lloji do te fshihen te gjitha"
                                + " produktet qe e permbajne kete lloj.Deshironi ta fshini?", "Fshirja",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                System.out.println("" + i);
                if (i == 0) {

                    for (int j = 0; j < listaProduktet.size(); j++) {
                        
                        pr.deleteProdukti(listaProduktet.get(j));
                    }
                    try {
                        lpr.delete(lp);
                    } catch (FarmaciaException ex) {
                        Logger.getLogger(MenaxhoLlojinEProduktit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadTable();

                }
            }

            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Nuk ke selektuar asgje!");
        }
    }//GEN-LAST:event_fshijActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Home h = new Home();
        h.dashboard();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void clear(){
        emriLlojit.setText("");
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emri;
    private javax.swing.JTextField emriLlojit;
    private javax.swing.JButton fshij;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton shto;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
