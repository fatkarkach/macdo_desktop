/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.gui.dialog.au.db;


/**
 *
 * @author Java Programming with Aldrin
 */

public class LoginUser {

    private static com.aldrin.cafsys.model.User user;

    /**
     * @return the user
     */
    public static com.aldrin.cafsys.model.User getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(com.aldrin.cafsys.model.User aUser) {
        user = aUser;
    }

   

}
