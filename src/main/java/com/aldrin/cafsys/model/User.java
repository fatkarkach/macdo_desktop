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

public class User extends Person  {

    public  User(){
        
    }

    public User(Integer id, String firstname, String middlename, String lastname, String username, String password) {
        super(id, firstname, middlename, lastname);
        this.username = username;
        this.password = password;
    }
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
