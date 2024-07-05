/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author 84358
 */
public class Event {
    private int idEvent;//
    private String nameEvent;//
    private Timestamp datecreate;//
    private Timestamp dateModify;//
    private int status;//
    private String address;//
    private Timestamp enddate;//
    private int idClub;//
    private Timestamp dateStart;//
    private String image;//
    private int idEventType;//
    private String description;//
    private String content ;//
    private String eventType;
    
    public Event() {
    }

    public Event(String nameEvent, Timestamp datecreate, Timestamp dateModify, int status, String address, Timestamp enddate, int idClub, Timestamp dateStart, String image, int idEventType, String description, String content) {
        this.nameEvent = nameEvent;
        this.datecreate = datecreate;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
        this.image = image;
        this.idEventType = idEventType;
        this.description = description;
        this.content = content;
    }

    public Event(int idEvent, String nameEvent, Timestamp dateModify, int status, String address, Timestamp enddate, int idClub, Timestamp dateStart, String image, int idEventType, String description, String content) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
        this.image = image;
        this.idEventType = idEventType;
        this.description = description;
        this.content = content;
    }
    
    

    public Event(int idEvent, String nameEvent, Timestamp datecreate, Timestamp dateModify, int status, String address, Timestamp enddate, int idClub, Timestamp dateStart, String image, int idEventType, String description, String content) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.datecreate = datecreate;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
        this.image = image;
        this.idEventType = idEventType;
        this.description = description;
        this.content = content;
    }

    public Event(int idEvent, String nameEvent ,String image, String description, String content,
            String address, Timestamp dateStart, Timestamp enddate, int idClub,
            String eventType , Timestamp datecreate, Timestamp dateModify, int status) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.datecreate = datecreate;
        this.dateModify = dateModify;
        this.status = status;
        this.address = address;
        this.enddate = enddate;
        this.idClub = idClub;
        this.dateStart = dateStart;
        this.image = image;
        this.description = description;
        this.content = content;
        this.eventType = eventType;
    }

    
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    
    

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public Timestamp getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Timestamp datecreate) {
        this.datecreate = datecreate;
    }

    public Timestamp getDateModify() {
        return dateModify;
    }

    public void setDateModify(Timestamp dateModify) {
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

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(int idEventType) {
        this.idEventType = idEventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
