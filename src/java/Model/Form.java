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
public class Form {
    private int idForm;
    private String fullName;
    private String titleForm;
    private String contentForm;
    private Date dateCreate;
    private String email;
    private int idClub;
    private byte handle, status,isRead;

    public Form(int idForm, String fullName, String titleForm, String contentForm, Date dateCreate, String email, int idClub) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.titleForm = titleForm;
        this.contentForm = contentForm;
        this.dateCreate = dateCreate;
        this.email = email;
        this.idClub = idClub;
    }

    public Form(int idForm, String fullName , String email, String titleForm, String contentForm, Date dateCreate, byte handle, byte status, int idClub) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.titleForm = titleForm;
        this.contentForm = contentForm;
        this.dateCreate = dateCreate;
        this.email = email;
        this.idClub = idClub;
        this.handle = handle;
        this.status = status;
    }
    
    
    
    
    
    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitleForm() {
        return titleForm;
    }

    public void setTitleForm(String titleForm) {
        this.titleForm = titleForm;
    }

    public String getContentForm() {
        return contentForm;
    }

    public void setContentForm(String contentForm) {
        this.contentForm = contentForm;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public byte getHandle() {
        return handle;
    }

    public void setHandle(byte handle) {
        this.handle = handle;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    
    

    public Form() {
    }
    
    
    
}
