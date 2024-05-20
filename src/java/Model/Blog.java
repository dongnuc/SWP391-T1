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
public class Blog {
    private int idBlog;
    private String titleBlog;
    private String image;
    private String description;
    private Date dateCreate;
    private int idClub;
    private boolean show;
    private boolean status;

    public Blog() {
    }

    public Blog(int idBlog, String titleBlog, String image, String description, Date dateCreate, int idClub, boolean show, boolean status) {
        this.idBlog = idBlog;
        this.titleBlog = titleBlog;
        this.image = image;
        this.description = description;
        this.dateCreate = dateCreate;
        this.idClub = idClub;
        this.show = show;
        this.status = status;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
