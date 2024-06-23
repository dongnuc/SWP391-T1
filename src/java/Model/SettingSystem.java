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
public class SettingSystem {
    private int idSetting;
    private String nameSetting;
    private String typeSetting;
    private int idForm;
    private int idClub;
    private int idBlog;
    private int idStudent;
    private int idEvent;
    private int status;
    private Date dateCreate;
    private Date dateModify;

    public SettingSystem(int idSetting, String nameSetting, String typeSetting, int status, Date dateCreate, Date dateModify) {
        this.idSetting = idSetting;
        this.nameSetting = nameSetting;
        this.typeSetting = typeSetting;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
    }

    public SettingSystem(int idSetting, String nameSetting, String typeSetting, int idForm, int idClub, int idBlog, int idStudent, int idEvent, int status, Date dateCreate, Date dateModify) {
        this.idSetting = idSetting;
        this.nameSetting = nameSetting;
        this.typeSetting = typeSetting;
        this.idForm = idForm;
        this.idClub = idClub;
        this.idBlog = idBlog;
        this.idStudent = idStudent;
        this.idEvent = idEvent;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
    }
    
    

    public SettingSystem() {
    }
    
    
    

    public int getIdSetting() {
        return idSetting;
    }

    public String getNameSetting() {
        return nameSetting;
    }

    public String getTypeSetting() {
        return typeSetting;
    }

    public int getStatus() {
        return status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    
    
    
}
