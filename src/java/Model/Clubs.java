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
public class Clubs {
    private int club;
    private String nameclub;
    private int point;
    private Date datecreate;
    private Date modify;
    private int type;
    private int status;

    public Clubs(int club, String nameclub, int point, Date datecreate, Date modify, int type, int status) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.datecreate = datecreate;
        this.modify = modify;
        this.type = type;
        this.status = status;
    }

    public Clubs() {
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    public String getNameclub() {
        return nameclub;
    }

    public void setNameclub(String nameclub) {
        this.nameclub = nameclub;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
