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
public class FormAdmin {
    private int idForm;
    private String nameFull,tittleForm,contentForm;
    private Date dateSend;
    private String email;
    private int idClub;
    private byte handle,status;

    public FormAdmin(int idForm, String nameFull, String tittleForm, String contentForm, String email, Date dateSend, int idClub, byte handle, byte status) {
        this.idForm = idForm;
        this.nameFull = nameFull;
        this.tittleForm = tittleForm;
        this.contentForm = contentForm;
        this.dateSend = dateSend;
        this.email = email;
        this.idClub = idClub;
        this.handle = handle;
        this.status = status;
    }

    public FormAdmin() {
    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getTittleForm() {
        return tittleForm;
    }

    public void setTittleForm(String tittleForm) {
        this.tittleForm = tittleForm;
    }

    public String getContentForm() {
        return contentForm;
    }

    public void setContentForm(String contentForm) {
        this.contentForm = contentForm;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
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
    
    
}
