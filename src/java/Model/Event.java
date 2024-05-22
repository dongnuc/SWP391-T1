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
public class Event {
    private int id;
    private int idclub;
    private String club;
    private Date datecreate;
    private Date enddate;

    public Event() {
    }

    public Event(int id, int idclub, String club, Date datecreate, Date enddate) {
        this.id = id;
        this.idclub = idclub;
        this.club = club;
        this.datecreate = datecreate;
        this.enddate = enddate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
    
}
