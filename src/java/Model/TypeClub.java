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
public class TypeClub {
    private int idTypeClub;
    private String nameTypeCllub;
    private Date dateCreate, dateModify;
    private byte status;

    public TypeClub() {
    }

    public TypeClub(int idTypeClub, String nameTypeCllub, Date dateCreate, Date dateModify, byte status) {
        this.idTypeClub = idTypeClub;
        this.nameTypeCllub = nameTypeCllub;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.status = status;
    }

    public int getIdTypeClub() {
        return idTypeClub;
    }

    public void setIdTypeClub(int idTypeClub) {
        this.idTypeClub = idTypeClub;
    }

    public String getNameTypeCllub() {
        return nameTypeCllub;
    }

    public void setNameTypeCllub(String nameTypeCllub) {
        this.nameTypeCllub = nameTypeCllub;
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
