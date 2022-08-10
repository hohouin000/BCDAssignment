/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pages;

import adapters.TrnxPoolAdapter;
import blockchain.Block;
import blockchain.Blockchain;
import com.google.common.collect.Lists;
import dataclasses.ProductRecord;
import ds.DigitalSignature;
import ds.KeyPairAccess;
import java.io.File;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.javatuples.Pair;
import transaction.Transaction;

/**
 *
 * @author caesa
 */
public class ProductPage extends javax.swing.JFrame {

    /**
     * Creates new form ProductPage
     */
    public ProductPage() {
        initComponents();
        txtDep.setText(LoginPage.u.getUser_company_name());
        dtpArrTime.setDateTimeStrict(LocalDateTime.now());
        dtpDepTime.setDateTimeStrict(LocalDateTime.now());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPID = new javax.swing.JLabel();
        lblPName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblArrTime = new javax.swing.JLabel();
        lblDepature = new javax.swing.JLabel();
        lblDepTime = new javax.swing.JLabel();
        lblDest = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        txtPName = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtDep = new javax.swing.JTextField();
        txtDest = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        dtpDepTime = new com.github.lgooddatepicker.components.DateTimePicker();
        dtpArrTime = new com.github.lgooddatepicker.components.DateTimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPID.setText("Product ID");

        lblPName.setText("Product Name");

        lblStatus.setText("Status");

        lblArrTime.setText("Arrival Time Stamp");

        lblDepature.setText("Depature");

        lblDepTime.setText("Depature Time Stamp");

        lblDest.setText("Destination");

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        txtDep.setEditable(false);
        txtDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepActionPerformed(evt);
            }
        });

        txtDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestActionPerformed(evt);
            }
        });

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDepTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDepature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblArrTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(txtPID)
                        .addComponent(txtPName)
                        .addComponent(txtStatus)
                        .addComponent(txtDep)
                        .addComponent(txtDest))
                    .addComponent(dtpDepTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPID)
                    .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPName)
                    .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArrTime)
                    .addComponent(dtpArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepature)
                    .addComponent(txtDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepTime)
                    .addComponent(dtpDepTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDest)
                    .addComponent(txtDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddProduct)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        String pID = txtPID.getText();
        String pName = txtPName.getText();
        String status = txtStatus.getText();
        String arriTime = dtpArrTime.toString().replace("T", " ");
        String dep = txtDep.getText();
        String depTime = dtpDepTime.toString().replace("T", " ");
        String dest = txtDest.getText();
        if (!pID.isEmpty() && !pName.isEmpty() && !status.isEmpty()) {
            try {
                ProductRecord prObj = new ProductRecord(pID, pName, status, arriTime, dep, depTime, dest);
                PrivateKey prvKey = KeyPairAccess.getPrivateKey(LoginPage.u.getKeyPairDirectory());
                DigitalSignature ds = new DigitalSignature();
                Pair<String, String> signedPair = Pair.with(prObj.toString(), ds.sign(prObj.toString(), prvKey));
                ProductRecord.writeNewLineToFile(signedPair);
                flag = true;
            } catch (Exception ex) {
                Logger.getLogger(ProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(this, "Record Added!");
            generateBlockChain();
            clearTxt();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Invalid Input !",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MenuPage menuObj = new MenuPage();
        menuObj.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDepActionPerformed

    private void generateBlockChain() {
        
        boolean noChain = !((new File(Blockchain.MASTER_BINARY).exists()) & (new File(Blockchain.LEDGER_FILE).exists()));
        if (noChain) {
            new File(Blockchain.MASTER_DIR).mkdir();
            //create genesis block
            Blockchain.genesis();
             generateBlock();

        } else {
            generateBlock();

        }
    }
    
    private void generateBlock(){
        List<String> tranxPool = TrnxPoolAdapter.getTransactionsHashes();
        if (tranxPool.size()>=10) {
            List<List<String>> subLst = Lists.partition(tranxPool, Transaction.SIZE);
             for (List<String> lst : subLst) {
                Transaction bag = new Transaction();
                for (String line : lst) {
                    bag.add(line);
                }
                //create nextBlock
                Block b1 = new Block(
                        Blockchain.get().getLast().getHeader().getCurrHash()
                );
                b1.setTranx(bag);
                Blockchain.nextBlock(b1);
                Blockchain.distribute();
            }
            TrnxPoolAdapter.empty();
        }
    }
    
    private void clearTxt(){
        txtPID.setText("");
        txtPName.setText("");
        txtStatus.setText("");
        dtpArrTime.setDateTimeStrict(LocalDateTime.now());
        dtpDepTime.setDateTimeStrict(LocalDateTime.now());
        txtDest.setText("");
    }

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
            java.util.logging.Logger.getLogger(ProductPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private com.github.lgooddatepicker.components.DateTimePicker dtpArrTime;
    private com.github.lgooddatepicker.components.DateTimePicker dtpDepTime;
    private javax.swing.JLabel lblArrTime;
    private javax.swing.JLabel lblDepTime;
    private javax.swing.JLabel lblDepature;
    private javax.swing.JLabel lblDest;
    private javax.swing.JLabel lblPID;
    private javax.swing.JLabel lblPName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtDep;
    private javax.swing.JTextField txtDest;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPName;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
