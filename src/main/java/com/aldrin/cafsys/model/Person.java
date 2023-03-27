/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.model;

import java.io.File;

/**
 *
 * @author Java Programming with Aldrin
 */

public abstract class Person {

    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String mobileNo;
    private String address;
    private String email;
    private String gender;
    private File photo;
    private String dateOfBirth;

    public Person() {

    }

    public Person(Integer id, String firstname, String middlename, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public Person(String firstname, String middlename, String lastname, String mobileNo, String address, String email, String gender, File photo, String birthDate) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.mobileNo = mobileNo;
        this.address = address;
        this.email = email;
        this.gender = email;
        this.photo = photo;
        this.dateOfBirth = birthDate;
    }

    public Person(Integer id, String firstname, String middlename, String lastname, String mobileNo, String address, String email, String gender, File photo, String birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.mobileNo = mobileNo;
        this.address = address;
        this.email = email;
        this.gender = email;
        this.photo = photo;
        this.dateOfBirth = birthDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

  

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the photo
     */
    public File getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(File photo) {
        this.photo = photo;
    }

}
