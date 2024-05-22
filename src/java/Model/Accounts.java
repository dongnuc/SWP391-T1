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
public class Accounts {
    private int id;
    private String name;
    private String email;
    private String password;
    private String sdt;
    private int gender;
    private Date date;
    private Date datecreate;
    private Date datemodify;
    private int status;
    private int role;

    public Accounts() {
    }

    public Accounts(int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.sdt = sdt;
        this.gender = gender;
        this.date = date;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
        this.role = role;
    }

    public Accounts(int id, String email, String password, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

   
    

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
