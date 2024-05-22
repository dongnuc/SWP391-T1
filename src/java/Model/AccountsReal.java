/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author 84358
 */
public class AccountsReal {
    private int id;
    private String name;
    private String email;
    private String sdt;
    private int gender;
    private Date date;
    private Date datecreate;
    private Date datemodify;
    private int status;

    public AccountsReal(int id, String name, String email, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.gender = gender;
        this.date = date;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getDatemodify() {
        return datemodify;
    }

    public void setDatemodify(Date datemodify) {
        this.datemodify = datemodify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
}
