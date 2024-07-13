/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ClubDao;
import java.sql.Timestamp;

/**
 *
 * @author 84358
 */
public class Blog {
    private int idBlog;//
    private String titleBlog;//
    private String image;//
    private String description;//
    private String content;//
    private Timestamp dateCreate;//
    private Timestamp dateModify;//
    private int idBlogType;//
    private int idClub;//
    private int show;//
    private int status;//
    private String blogType;

    public Blog() {
    }

    public Blog(String titleBlog, String image, String description, String content, Timestamp dateCreate, Timestamp dateModify, int idBlogType, int idClub, int show, int status) {
        this.titleBlog = titleBlog;
        this.image = image;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.idBlogType = idBlogType;
        this.idClub = idClub;
        this.show = show;
        this.status = status;
    }

    public Blog(String titleBlog, String image, String description, String content, Timestamp dateModify, int idBlogType, int idClub, int show, int status , int idBlog) {
        this.titleBlog = titleBlog;
        this.image = image;
        this.description = description;
        this.content = content;
        this.dateModify = dateModify;
        this.idBlogType = idBlogType;
        this.idClub = idClub;
        this.show = show;
        this.status = status;
         this.idBlog = idBlog;
    }

    public Blog(int idBlog, String titleBlog, String image, String description, String content, Timestamp dateCreate, Timestamp dateModify, int idBlogType, int idClub, int show, int status) {
        this.idBlog = idBlog;
        this.titleBlog = titleBlog;
        this.image = image;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.idBlogType = idBlogType;
        this.idClub = idClub;
        this.show = show;
        this.status = status;
    }

    public Blog(int idBlog, String titleBlog, String image, String description, String content, String blogType,
            int idClub, int show, int status,Timestamp dateCreate, Timestamp dateModify) {
        this.idBlog = idBlog;
        this.titleBlog = titleBlog;
        this.image = image;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.idClub = idClub;
        this.show = show;
        this.status = status;
        this.blogType = blogType;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getIdBlogType() {
        return idBlogType;
    }

    public void setIdBlogType(int idBlogType) {
        this.idBlogType = idBlogType;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    ClubDao dao =new ClubDao();
public String getNameCLub(){
    return dao.getNameById(idClub);
}
}
