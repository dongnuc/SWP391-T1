/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Student {
    private int idSt;
    private String nameSt,emailSt, password,phoneSt,gender;
    private Date dobSt,dateCreate,dateModify;
    private byte status;

    public Student() {
    }

    public Student(int idSt, String nameSt, String emailSt, String password, String phoneSt, String gender, Date dobSt, Date dateCreate, Date dateModify, byte status) {
        this.idSt = idSt;
        this.nameSt = nameSt;
        this.emailSt = emailSt;
        this.password = password;
        this.phoneSt = phoneSt;
        this.gender = gender;
        this.dobSt = dobSt;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.status = status;
    }

    

    public int getIdSt() {
        return idSt;
    }

    public void setIdSt(int idSt) {
        this.idSt = idSt;
    }

    public String getNameSt() {
        return nameSt;
    }

    public void setNameSt(String nameSt) {
        this.nameSt = nameSt;
    }

    public String getEmailSt() {
        return emailSt;
    }

    public void setEmailSt(String emailSt) {
        this.emailSt = emailSt;
    }

    public String getPhoneSt() {
        return phoneSt;
    }

    public void setPhoneSt(String phoneSt) {
        this.phoneSt = phoneSt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDobSt() {
        return dobSt;
    }

    public void setDobSt(Date dobSt) {
        this.dobSt = dobSt;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    
    
}
