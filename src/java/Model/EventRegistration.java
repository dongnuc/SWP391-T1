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
public class EventRegistration {
    private int idevent;
    private String nameevent;
    private Date datestart;
    private Date dateend;
    private String address;
    private String status;
    private String note;
    private String phone;
    private String name;
    private String gmail;
    private int eventregisterid;
    

    public EventRegistration(int idevent, String nameevent, Date datestart, Date dateend, String address, String status, String note) {
        this.idevent = idevent;
        this.nameevent = nameevent;
        this.datestart = datestart;
        this.dateend = dateend;
        this.address = address;
        this.status = status;
        this.note = note;
    }
    

    public EventRegistration(int eventregisterid,String nameevent, Date datestart, Date dateend, String address, String status) {
        this.eventregisterid=eventregisterid;
        this.nameevent = nameevent;
        this.datestart = datestart;
        this.dateend = dateend;
        this.address = address;
        this.status = status;
    }
    

    public int getIdevent() {
        return idevent;
    }
    

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public int getEventregisterid() {
        return eventregisterid;
    }

    public void setEventregisterid(int eventregisterid) {
        this.eventregisterid = eventregisterid;
    }
    

    public String getNameevent() {
        return nameevent;
    }

    public void setNameevent(String nameevent) {
        this.nameevent = nameevent;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public EventRegistration(int eventregisterid,int idevent, String nameevent, String status, String note, String phone, String name, String gmail) {
        this.idevent = idevent;
        this.eventregisterid=eventregisterid;
        this.nameevent = nameevent;
        this.status = status;
        this.note = note;
        this.phone = phone;
        this.name = name;
        this.gmail = gmail;
    }

    
    
    
    
    
}
