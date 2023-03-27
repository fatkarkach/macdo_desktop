/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.api;

import javax.swing.JPanel;

/**
 *
 * @author Java Programming with Aldrin
 */
public class PanelSwaper extends JPanel {

    public  PanelSwaper(JPanel panelParam) {
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        this.setFocusable(false);
        this.add(panelParam);
        this.updateUI();
    }
    

}
