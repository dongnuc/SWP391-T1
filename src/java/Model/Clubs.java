/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ClubDao;
import DAO.StudentClubDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 84358
 */
public class Clubs {
    private int club;
    private String nameclub;
    private int point;
    private int categoryclub;
    private Date datecreate;
    private Date modify;
    private int status;
    private String image;
    private String title;
    private String description;
    private Role listRole ;

    public Clubs() {
    }

    public int getCategoryclub() {
        return categoryclub;
    }

    public void setCategoryclub(int categoryclub) {
        this.categoryclub = categoryclub;
    }

    public Clubs(int club, String nameclub, int point, Date datecreate, Date modify, int status, String image, String title, String description, Role listRole) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.datecreate = datecreate;
        this.modify = modify;
        this.status = status;
        this.image = image;
        this.title = title;
        this.description = description;
        this.listRole = listRole;
    }

    public Clubs(int club, String nameclub, int point, int categoryclub, Date datecreate, Date modify, int status, String image, String title, String description) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.categoryclub = categoryclub;
        this.datecreate = datecreate;
        this.modify = modify;
        this.status = status;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    public String getNameclub() {
        return nameclub;
    }

    public void setNameclub(String nameclub) {
        this.nameclub = nameclub;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getListRole() {
        return listRole;
    }

    public void setListRole(Role listRole) {
        this.listRole = listRole;
    }

    StudentClubDAO stdao = new StudentClubDAO();
   public int getSizeClub(){
       return stdao.getSizeClub(getClub());
   }
    ClubDao sdao =new ClubDao();
    public String getTypebyid(){
        return sdao.getValuebySetting(categoryclub);
    }
    
}
