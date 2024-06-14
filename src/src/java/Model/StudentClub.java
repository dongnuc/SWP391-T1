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
    private int point ;
    private Date dateCreate;
    private Date dateModify;
    private int status;
    private int idStudent;
    private int idClub;
    private int role;

    public StudentClub() {
    }

    public StudentClub(int point, Date dateCreate, Date dateModify, int status, int idStudent, int idClub, int role) {
        this.point = point;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.status = status;
        this.idStudent = idStudent;
        this.idClub = idClub;
        this.role = role;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getRole() {
        return role;
    }
 public String getNamebyId() {
        return dao.getNamebyID(idStudent);
    }
    public void setRole(int role) {
        this.role = role;
    }
    AccountDao dao = new AccountDao();


    public String getNameRole() {
        if (getRole() == 1) {
            return "Manager";
        } else {
            return "Member";
        }
    }
    
}
