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
    private Date dateCreate, dateModify;
    private String email;
    private int status,isRead;
    private String phoneNumber;
    

    public Form(int idForm, String fullName , String email, String titleForm, String contentForm, Date dateCreate, int status, int isRead) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.titleForm = titleForm;
        this.contentForm = contentForm;
        this.dateCreate = dateCreate;
        this.email = email;
        this.status = status;
        this.isRead = isRead;
    }

    public Form(int idForm, String fullName, String titleForm, String contentForm, Date dateCreate, Date dateModify, String email, int status, int isRead) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.titleForm = titleForm;
        this.contentForm = contentForm;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.email = email;
        this.status = status;
        this.isRead = isRead;
    }

    public Form(int idForm, String fullName, String titleForm, String contentForm, Date dateCreate, String email, int status, int isRead, String phoneNumber) {
        this.idForm = idForm;
        this.fullName = fullName;
        this.titleForm = titleForm;
        this.contentForm = contentForm;
        this.email = email;
        this.status = status;
        this.isRead = isRead;
        this.phoneNumber = phoneNumber;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    


    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
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

    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

    public Form() {
    }
    
    
    
}
