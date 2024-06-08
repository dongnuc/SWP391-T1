/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ClubDao;
import DAO.StudentClubDao;
import java.util.Date;

/**
 *
 * @author 84358
 */
public class Clubs {
    private int club;
    private String nameclub;
    private int point;
    private String datecreate;
    private String modify;
    private int status;
    private int type;
    private String img;
    private String description;

    ClubDao dao = new ClubDao();
    public Clubs() {
    }

    public Clubs(int club, String nameclub, int point, String datecreate, String modify, int status, int type, String img, String description) {
        this.club = club;
        this.nameclub = nameclub;
        this.point = point;
        this.datecreate = datecreate;
        this.modify = modify;
        this.status = status;
        this.type = type;
        this.img = img;
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

    public String getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(String datecreate) {
        this.datecreate = datecreate;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClubDao getDao() {
        return dao;
    }

    public void setDao(ClubDao dao) {
        this.dao = dao;
    }
StudentClubDao stdao = new StudentClubDao();
   public int getSizeClub(){
       return stdao.getSizeClub(getClub());
   }

    public String getStringType() {
        TypeClub typeclub = dao.gettypeclubbyID(type);
        String nametype = typeclub.getNameTypeClub();
        return nametype;
    }

   
  

  

}