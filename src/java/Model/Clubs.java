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
    private Date datecreate;
    private Date modify;
    private int type;
    private int status;
    private String image;
    private String description;
<<<<<<< HEAD
    private String typeClub;
    private Date dateCreate, dateModify;
    
    
=======
    private Role listRole ;
>>>>>>> 8d31409bbc7395d019269cc4072bfe83377cdc3c

    public Clubs() {
    }

    public Clubs(int club, String nameclub, int point, Date datecreate, Date modify, int type, int status, String image, String description, Role listRole) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.datecreate = datecreate;
        this.modify = modify;
        this.type = type;
        this.status = status;
        this.image = image;
        this.description = description;
        this.listRole = listRole;
    }

   
 public Clubs(int club, String nameclub, int point, Date datecreate, Date modify, int type, int status, String image, String description) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.datecreate = datecreate;
        this.modify = modify;
        this.type = type;
        this.status = status;
        this.image = image;
        this.description = description;
        this.listRole = listRole;
    }

    public Clubs(int club, String nameclub, int point, Date dateCreate, Date dateModify, String typeClub,int status) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.status = status;
        this.typeClub = typeClub;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
    }

    

    public String getTypeClub() {
        return typeClub;
    }

    public void setTypeClub(String typeClub) {
        this.typeClub = typeClub;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
    ClubDao dao = new ClubDao();
    public String getStringType() {
        TypeClub typeclub = dao.gettypeclubbyID(status);
        String nametype = typeclub.getNameTypeClub();
        return nametype;
    
    }
}
