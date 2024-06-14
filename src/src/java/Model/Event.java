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
    private int idEvent;
    private int nameEvent;
    private Date datecreate;
    private Date dateModify;
    private int status;
    private String address;
    private Date enddate;
    private int idClub;
    private Date dateStart;

    public Event() {
    }

    public Event(int nameEvent, Date datecreate, Date dateModify, int status, String address, Date enddate, int idClub, Date dateStart) {
        this.nameEvent = nameEvent;
        this.datecreate = datecreate;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
    }

    public Event(int idEvent, int nameEvent, Date datecreate, Date dateModify, int status, String address, Date enddate, int idClub, Date dateStart) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.datecreate = datecreate;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(int nameEvent) {
        this.nameEvent = nameEvent;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
  
}
