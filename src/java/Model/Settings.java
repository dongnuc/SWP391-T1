/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author 10t1q
 */
    public class Settings {
        private int idSetting;
        private String valueSetting;
        private int typeSetting;
        private int idStudent ;
        private Timestamp dateCreate;
        private Timestamp dateModify;
        private int status ;

    public Settings() {
    }

        
    public Settings(int idSetting, String valueSetting, int typeSetting, int idStudent, Timestamp dateCreate, Timestamp dateModify, int status) {
        this.idSetting = idSetting;
        this.valueSetting = valueSetting;
        this.typeSetting = typeSetting;
        this.idStudent = idStudent;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.status = status;
    }

    public int getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(int idSetting) {
        this.idSetting = idSetting;
    }

    public String getValueSetting() {
        return valueSetting;
    }

    public void setValueSetting(String valueSetting) {
        this.valueSetting = valueSetting;
    }

    public int getTypeSetting() {
        return typeSetting;
    }

    public void setTypeSetting(int typeSetting) {
        this.typeSetting = typeSetting;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
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
        
        
    }
