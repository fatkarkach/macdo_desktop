/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.cafsys.events;

import com.aldrin.cafsys.gui.panel.JPanelCashier;
import com.aldrin.cafsys.model.Category;
import com.aldrin.cafsys.model.MOTD;
import com.aldrin.cafsys.model.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 * @author Java Programming with Aldrin
 */
public class ActionListenerHandler implements ActionListener {

    private ArrayList<Category> categoryList;
    private LinkedList<Menu> menuList;
    private LinkedList<MOTD> motdList;
    private JButton jButton;
    private ArrayList<JButton> arrayButtons = new ArrayList<>();

    public ActionListenerHandler() {
    }

    public ActionListenerHandler(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public ActionListenerHandler(LinkedList<Menu> menuList) {
        this.menuList = menuList;
    }

    public ActionListenerHandler(JButton jButton, LinkedList<MOTD> motdList) {
        this.setjButton(jButton);
        this.motdList = motdList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (getCategoryList() != null) {
            for (Category c : getCategoryList()) {
                if (command.equals(c.getCategory())) {
                    JPanelCashier p = new JPanelCashier(c.getId());
                }
            }
        }
        JButton jButton = new JButton();
        if (e.getSource() == getjButton()) {
            for (MOTD motd : getMotdList()) {
                MOTD m = new MOTD();
                m.setId(Integer.parseInt(getjButton().getName())); 
                if (motd.getId() == Integer.parseInt(getjButton().getName())) {
                    new JPanelCashier(m);
                }
            }
        }
    }

    /**
     * @return the categoryList
     */
    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    /**
     * @param categoryList the categoryList to set
     */
    public void setCategoryList(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * @return the menuList
     */
    public LinkedList<Menu> getMenuList() {
        return menuList;
    }

    /**
     * @param menuList the menuList to set
     */
    public void setMenuList(LinkedList<Menu> menuList) {
        this.menuList = menuList;
    }

    /**
     * @return the jButton
     */
    public JButton getjButton() {
        return jButton;
    }

    /**
     * @param jButton the jButton to set
     */
    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    /**
     * @return the arrayButtons
     */
    public ArrayList<JButton> getArrayButtons() {
        return arrayButtons;
    }

    /**
     * @param arrayButtons the arrayButtons to set
     */
    public void setArrayButtons(ArrayList<JButton> arrayButtons) {
        this.arrayButtons = arrayButtons;
    }

    /**
     * @return the motdList
     */
    public LinkedList<MOTD> getMotdList() {
        return motdList;
    }

    /**
     * @param motdList the motdList to set
     */
    public void setMotdList(LinkedList<MOTD> motdList) {
        this.motdList = motdList;
    }
}
