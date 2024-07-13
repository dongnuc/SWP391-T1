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
public class RegisterClub {

    private int idregister;
    private String nameclub;
    private String reason;
    private int member;
    private int idstudent;
    private Date datecreate;
    private Date datemodify;
    private String target;
    private String plan;
    private String refuse;
    private int category;

    public RegisterClub() {
    }

    public RegisterClub(int idregister, String nameclub, String reason, int member, int idstudent, Date datecreate, Date datemodify, String target, String plan, String refuse, int category) {
        this.idregister = idregister;
        this.nameclub = nameclub;
        this.reason = reason;
        this.member = member;
        this.idstudent = idstudent;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.target = target;
        this.plan = plan;
        this.refuse = refuse;
        this.category = category;
    }

    public int getIdregister() {
        return idregister;
    }

    public void setIdregister(int idregister) {
        this.idregister = idregister;
    }

    public String getNameclub() {
        return nameclub;
    }

    public void setNameclub(String nameclub) {
        this.nameclub = nameclub;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getDatemodify() {
        return datemodify;
    }

    public void setDatemodify(Date datemodify) {
        this.datemodify = datemodify;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public AccountDao getAd() {
        return ad;
    }

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    ClubDao dao = new ClubDao();
    public String getTypeclub(){
        return dao.getValuebySetting(category);
    }
    AccountDao ad = new AccountDao();

    public String getNamebyID() {
        return ad.getNamebyID(idstudent);
    }

}
