/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

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
    private int points;
    private int status;
    private int role;
    private String image;
    List<Clubs> myClubs;

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

    public Accounts(int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role, List<Clubs> myClubs) {
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
        this.myClubs = myClubs;
    }
    public Accounts(int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role, String image) {
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
        this.image = image;
    }

    public Accounts(int id, String name, int gender, Date date, int points, int status, int role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.points = points;
        this.status = status;
        this.role = role;
    }

    public Accounts(int id, String name, int gender, Date date, int points, int status, List<Clubs> myClubs) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.points = points;
        this.status = status;
        this.myClubs = myClubs;
    }
    
    

   

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Clubs> getMyClubs() {
        return myClubs;
    }

    public void setMyClubs(List<Clubs> myClubs) {
        this.myClubs = myClubs;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    

    
    
}
