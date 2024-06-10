/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AccountDao;

/**
 *
 * @author Nguyen Hau
 */
public class StudentClub {

    private int point;
    private String datecreate;
    private String datemodify;
    private int status;
    private int idrole;
    private int idstudent;
    private int idclub;

    public StudentClub() {
    }

    public StudentClub(int point, String datecreate, String datemodify, int status, int idrole, int idstudent, int idclub) {
        this.point = point;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
        this.idrole = idrole;
        this.idstudent = idstudent;
        this.idclub = idclub;
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

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
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
    AccountDao dao = new AccountDao();

    public String getNamebyId() {
        return dao.getNamebyID(idstudent);
    }

    public String getRole() {
        if (getIdrole() == 1) {
            return "Manager";
        } else {
            return "Member";
        }
    }
}
