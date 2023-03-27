/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.gui;


import com.aldrin.cafsys.gui.dialog.au.db.AppQuery;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Java Programming with Aldrin
 */


public class JFrameLogin extends javax.swing.JFrame {

    private static String passwordT;
    private static boolean unHidePassword = false;

    /**
     * Creates new form JFrameLogin
     */
    public JFrameLogin() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabelMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log-in [CafSys POS]");
        setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameLogin.class.getResource("/images/c.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setMinimumSize(new java.awt.Dimension(328, 348));
        jPanel1.setPreferredSize(new java.awt.Dimension(328, 348));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsername.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldUsername.setToolTipText("Email or Username");
        jTextFieldUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusLost(evt);
            }
        });
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 135, 200, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204)));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 135, 34, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye slash.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204)));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setOpaque(true);
        jLabel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel2FocusLost(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 207, 34, 30));

        jButtonLogin.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButtonLogin.setMnemonic('L');
        jButtonLogin.setText("Log-in");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jButtonLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonLoginKeyReleased(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 246, 36));

        jPasswordFieldPassword.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jPasswordFieldPassword.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordFieldPassword.setToolTipText("Password");
        jPasswordFieldPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPasswordFieldPassword.setMinimumSize(new java.awt.Dimension(200, 32));
        jPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(200, 30));
        jPasswordFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusLost(evt);
            }
        });
        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 207, -1, -1));

        jLabelMessage.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(204, 0, 0));
        jLabelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 250, 30));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 164, 30));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Username");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 107, 164, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(204, 204, 204)));
        jTextField1.setFocusable(false);
        jTextField1.setMaximumSize(new java.awt.Dimension(12, 30));
        jTextField1.setMinimumSize(new java.awt.Dimension(12, 30));
        jTextField1.setOpaque(true);
        jTextField1.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 135, 10, 30));

        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(204, 204, 204)));
        jPasswordField1.setFocusable(false);
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 207, 10, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(319, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained

    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusLost

    }//GEN-LAST:event_jTextFieldUsernameFocusLost

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed

    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        accessLogin();

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        jLabelMessage.setText("");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            accessLogin();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed

//        jPasswordFieldPasswordBack.setText("Password");
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel2FocusGained

    }//GEN-LAST:event_jLabel2FocusGained

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (isUnHidePassword() == false) {
            if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                jPasswordFieldPassword.setForeground(new java.awt.Color(51, 51, 51));
                jPasswordFieldPassword.setEchoChar((char) 0);
                setUnHidePassword(true);
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png")));
            }
        } else if (isUnHidePassword() == true) {
            if (jPasswordFieldPassword.getText().equals("")) {
                jPasswordFieldPassword.setForeground(new java.awt.Color(51, 51, 51));
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png")));
            }
            setUnHidePassword(false);
            jPasswordFieldPassword.setForeground(new java.awt.Color(204, 204, 204));
            jPasswordFieldPassword.setEchoChar('•');
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye slash.png")));

        }

//        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextFieldUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyReleased
     


    }//GEN-LAST:event_jTextFieldUsernameKeyReleased

    private void jLabel2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel2FocusLost
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye slash.png")));
    }//GEN-LAST:event_jLabel2FocusLost

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited

    }//GEN-LAST:event_jLabel2MouseExited

    private void jPasswordFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyReleased
 
    }//GEN-LAST:event_jPasswordFieldPasswordKeyReleased

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            accessLogin();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jPasswordFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusLost

    }//GEN-LAST:event_jPasswordFieldPasswordFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void jPasswordFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusGained
      
    }//GEN-LAST:event_jPasswordFieldPasswordFocusGained

    private void jButtonLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonLoginKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoginKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void accessLogin() {
        int counter = 40000;
        int i = 0;
        if ((jTextFieldUsername.getText().length() == 0) && (jPasswordFieldPassword.getText().length() == 0)) {
            jLabelMessage.setText("Username or Password is empty!");
        }
        if (new AppQuery().loginUser(jTextFieldUsername.getText(), jPasswordFieldPassword.getText()) == false) {
            JFrameCafSys m = new JFrameCafSys();
            m.setLogIn(true);
            this.dispose();
            m.setVisible(true);
        } else if (new AppQuery().loginUser(jTextFieldUsername.getText(), jPasswordFieldPassword.getText()) == true) {
            for (; i <= counter; i++) {
                if (i == counter) {
                    jLabelMessage.setText("Invalid account!!");
                }
            }
            i = 0;
        }
    }

    /**
     * @return the passwordT
     */
    public static String getPasswordT() {
        return passwordT;
    }

    /**
     * @param aPasswordT the passwordT to set
     */
    public static void setPasswordT(String aPasswordT) {
        passwordT = aPasswordT;
    }

    /**
     * @return the unHidePassword
     */
    public static boolean isUnHidePassword() {
        return unHidePassword;
    }

    /**
     * @param aHidePassword the unHidePassword to set
     */
    public static void setUnHidePassword(boolean aHidePassword) {
        unHidePassword = aHidePassword;
    }


  
}
