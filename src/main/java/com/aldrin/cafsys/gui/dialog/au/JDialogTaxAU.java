/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.gui.dialog.au;

import com.aldrin.cafsys.api.NumberInput;
import com.aldrin.cafsys.gui.dialog.au.db.AppQuery;
import com.aldrin.cafsys.model.Discount;
import com.aldrin.cafsys.model.Tax;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */

public class JDialogTaxAU extends javax.swing.JDialog {

    private com.aldrin.cafsys.gui.JFrameCafSys mainMenu;
    private String evt = new String();
    private File pictureFile = null;
    private File photo;
    private Tax tax = new Tax();

    /**
     * Creates new form JDialogSupplierAUD
     */
    public JDialogTaxAU(com.aldrin.cafsys.gui.JFrameCafSys parent, boolean modal) {
        super(parent, modal);
        this.mainMenu = parent;
        initComponents();
    }

    public JDialogTaxAU(com.aldrin.cafsys.gui.JFrameCafSys parent, boolean modal, String evtl) {
        super(parent, modal);
        initComponents();
        this.evt = evtl;
        setTitle("Add Discount");
        jButtonSave.setText("Save");
        jButtonSave.setMnemonic('S');
        new NumberInput().doubleValidator(jTextFieldPercent);

    }

    public JDialogTaxAU(com.aldrin.cafsys.gui.JFrameCafSys parent, boolean modal, String evtl, Tax tax) {
        super(parent, modal);
        initComponents();
        this.evt = evtl;
        this.tax = tax;
        jButtonSave.setText("Update");
        jButtonSave.setMnemonic('U');
        jTextFieldPercent.setText(String.valueOf(this.tax.getPercentage()));
        jTextArea1.setText(this.tax.getDescription());
        jTextFieldTax.setText(this.tax.getTax());
        new NumberInput().doubleValidator(jTextFieldPercent);

    }

    public JDialogTaxAU(com.aldrin.cafsys.gui.JFrameCafSys parent, boolean modal, Tax tax, String evtl) {
        super(parent, modal);
        initComponents();
        this.evt = evtl;
        this.tax = tax;
        jButtonSave.setText("Delete");
        jButtonSave.setMnemonic('D');
        jTextFieldPercent.setText(String.valueOf(tax.getPercentage()));
        jTextArea1.setText(tax.getDescription());
        jTextFieldTax.setText(this.tax.getTax());
        new NumberInput().doubleValidator(jTextFieldPercent);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPercent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextFieldTax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanelButton = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Tax");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Description");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, -1));

        jTextFieldPercent.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextFieldPercent.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 260, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 260, 110));

        jTextFieldTax.setPreferredSize(new java.awt.Dimension(59, 25));
        jPanel2.add(jTextFieldTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 260, 25));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Percent");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 180, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanelButton.setPreferredSize(new java.awt.Dimension(394, 60));
        jPanelButton.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSave.setMnemonic('S');
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 36));

        jPanelButton.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanelButton.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel7.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanelButton.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanelButton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(299, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {
            switch (this.evt) {
                case "Add":
                    int reply = JOptionPane.showConfirmDialog(this,
                            "Are you sure  to save " + jTextFieldPercent.getText() + "   " + jTextArea1.getText() + " ?",
                            "Confirmation - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (reply == JOptionPane.YES_OPTION) {
                        tax.setPercentage(Float.parseFloat(jTextFieldPercent.getText()));
                        tax.setDescription(jTextArea1.getText());
                        tax.setTax(jTextFieldTax.getText());
                        new AppQuery().addTax(tax);
                    } else if (reply == JOptionPane.NO_OPTION) {

                    }
                    this.dispose();
                    break;

                case "Update":
                    int upate = JOptionPane.showConfirmDialog(this,
                            "Are you sure  to save " + jTextFieldPercent.getText() + "   " + jTextArea1.getText() + " ?",
                            "Confirmation - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (upate == JOptionPane.YES_OPTION) {
                        tax.setTax(jTextFieldTax.getText());
                        tax.setPercentage(Float.parseFloat(jTextFieldPercent.getText()));
                        tax.setDescription(jTextArea1.getText());
                        new AppQuery().updateTax(tax);
                    }
                    this.dispose();
                    break;
                case "Delete":
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + tax.getPercentage() + " " + tax.getDescription() + " ?", "Delete Confirmation!!", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        new AppQuery().deleteTax(tax);
                        JOptionPane.showMessageDialog(null, tax.getPercentage() + " " + tax.getDescription() + " is successfully deleted.", "Message", JOptionPane.PLAIN_MESSAGE);
                    }
                    this.dispose();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSave;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldPercent;
    private javax.swing.JTextField jTextFieldTax;
    // End of variables declaration//GEN-END:variables

}
