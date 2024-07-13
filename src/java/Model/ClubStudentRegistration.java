/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AccountDao;
import DAO.ClubDao;
import java.util.Date;

/**
 *
 * @author Nguyen Hau
 */
public class ClubStudentRegistration {
    private int idclubstudentregistration;
    private int idstudent;
    private int idclub;
    private int role;
    private Date datecreate;
    private String fullname;
    private String talent;
    private String experience;
    private String target;
    private String reason;

    public ClubStudentRegistration() {
    }

    public ClubStudentRegistration(int idclubstudentregistration, int idstudent, int idclub, int role, Date datecreate, String fullname, String talent, String experience, String target, String reason) {
        this.idclubstudentregistration = idclubstudentregistration;
        this.idstudent = idstudent;
        this.idclub = idclub;
        this.role = role;
        this.datecreate = datecreate;
        this.fullname = fullname;
        this.talent = talent;
        this.experience = experience;
        this.target = target;
        this.reason = reason;
    }

    public int getIdclubstudentregistration() {
        return idclubstudentregistration;
    }

    public void setIdclubstudentregistration(int idclubstudentregistration) {
        this.idclubstudentregistration = idclubstudentregistration;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    AccountDao acdao = new AccountDao();

    public String getNamebyId() {
        return acdao.getNamebyID(idstudent);
    }
    ClubDao sdao =new ClubDao();
    public String getRolebyID(){
        return sdao.getRolebyId(role);
    }
    public String getStringRole(){
        return sdao.getValuebySetting(role);
    } 
    public String getNameClubbyId(){
        Clubs club = sdao.getClubbyId(idclub);
        return club.getNameclub();
    }
}
