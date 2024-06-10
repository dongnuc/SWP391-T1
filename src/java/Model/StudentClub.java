/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AccountDao;
import java.util.Date;
/**
 *
 * @author 10t1q
 */
public class StudentClub {


    private int point;
    private String datecreate;
    private String datemodify;
    private int status;
    private int role;
    private int idstudent;
    private int idclub;

    public StudentClub(int point, String datecreate, String datemodify, int status, int role, int idstudent, int idclub) {
        this.point = point;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
        this.role = role;
        this.idstudent = idstudent;
        this.idclub = idclub;
    }
    
    

    public StudentClub() {
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

    public String getDatemodify() {
        return datemodify;
    }

    public void setDatemodify(String datemodify) {
        this.datemodify = datemodify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public AccountDao getDao() {
        return dao;
    }

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }
  
    AccountDao dao = new AccountDao();

    public String getNamebyId() {
        return dao.getNamebyID(idstudent);
    }

    public String getNameRole() {
        if (getRole() == 1) {
            return "Manager";
        } else {
            return "Member";
        }
    }

}
