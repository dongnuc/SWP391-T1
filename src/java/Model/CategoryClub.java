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
public class CategoryClub {
    private int idCategoryClub;
    private String nameClub;
    private Date dateCreate;
    private Date dateModify;
    private boolean status;

    public CategoryClub(int idCategoryClub, String nameClub, Date dateCreate, Date dateModify, boolean status) {
        this.idCategoryClub = idCategoryClub;
        this.nameClub = nameClub;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.status = status;
    }

    public CategoryClub() {
    }

    public int getIdCategoryClub() {
        return idCategoryClub;
    }

    public void setIdCategoryClub(int idCategoryClub) {
        this.idCategoryClub = idCategoryClub;
    }

    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
