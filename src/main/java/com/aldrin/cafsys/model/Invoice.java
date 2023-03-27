/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.model;



/**
 *
 * @author Java Programming with Aldrin
 */

public class Invoice {

    private Long id;
    private User user;
    private String dateTime;
    private String customerNo;
    private Double customerCash;
    private Integer noOfOrders;
    //Data integration
    private Double total;
    private Integer tableNo;
    private Integer takingMealsId;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the customerNo
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo the customerNo to set
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    /**
     * @return the customerCash
     */
    public Double getCustomerCash() {
        return customerCash;
    }

    /**
     * @param customerCash the customerCash to set
     */
    public void setCustomerCash(Double customerCash) {
        this.customerCash = customerCash;
    }

    /**
     * @return the noOfOrders
     */
    public Integer getNoOfOrders() {
        return noOfOrders;
    }

    /**
     * @param noOfOrders the noOfOrders to set
     */
    public void setNoOfOrders(Integer noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the tableNo
     */
    public Integer getTableNo() {
        return tableNo;
    }

    /**
     * @param tableNo the tableNo to set
     */
    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    /**
     * @return the takingMealsId
     */
    public Integer getTakingMealsId() {
        return takingMealsId;
    }

    /**
     * @param takingMealsId the takingMealsId to set
     */
    public void setTakingMealsId(Integer takingMealsId) {
        this.takingMealsId = takingMealsId;
    }

}
