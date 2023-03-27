/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.gui.panel;

import java.util.ArrayList;

/**
 *
 * @author Java Programming with Aldrin
 */

public class OrdersHold {


    private Integer id;
    private Integer qty;
    private String menu;
    private String unitPrice;
    private String lineTotal;
    private String lineTotalUF;
    private String unitPriceUF;
    private static ArrayList<OrdersHold> ordersHold;
    


  

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return the menu
     */
    public String getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * @return the unitPrice
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the lineTotal
     */
    public String getLineTotal() {
        return lineTotal;
    }

    /**
     * @param lineTotal the lineTotal to set
     */
    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }

    /**
     * @return the lineTotalUF
     */
    public String getLineTotalUF() {
        return lineTotalUF;
    }

    /**
     * @param lineTotalUF the lineTotalUF to set
     */
    public void setLineTotalUF(String lineTotalUF) {
        this.lineTotalUF = lineTotalUF;
    }

    /**
     * @return the ordersHold
     */
    public static ArrayList<OrdersHold> getOrdersHold() {
        return ordersHold;
    }

    /**
     * @param aOrdersHold the ordersHold to set
     */
    public static void setOrdersHold(ArrayList<OrdersHold> aOrdersHold) {
        ordersHold = aOrdersHold;
    }

    /**
     * @return the unitPriceUF
     */
    public String getUnitPriceUF() {
        return unitPriceUF;
    }

    /**
     * @param unitPriceUF the unitPriceUF to set
     */
    public void setUnitPriceUF(String unitPriceUF) {
        this.unitPriceUF = unitPriceUF;
    }

}
