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
 * @author 10t1q
 */
public class StudentClub {
private int idstudent;
private int idclub;
private int point;
private int role;
private int leader;
private Date datecreate;
private Date datemodify;
private int status;

    public StudentClub() {
    }

    public StudentClub(int idstudent, int idclub, int point, int role, int leader, Date datecreate, Date datemodify, int status) {
        this.idstudent = idstudent;
        this.idclub = idclub;
        this.point = point;
        this.role = role;
        this.leader = leader;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
    }

    public StudentClub(int point, int status,int idstudent, int idclub, Date datecreate, Date datemodify) {
        this.idstudent = idstudent;
        this.idclub = idclub;
        this.point = point;
        this.datecreate = datecreate;
        this.datemodify = datemodify;
        this.status = status;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AccountDao getAcdao() {
        return acdao;
    }

    public void setAcdao(AccountDao acdao) {
        this.acdao = acdao;
    }

    public ClubDao getSdao() {
        return sdao;
    }

    public void setSdao(ClubDao sdao) {
        this.sdao = sdao;
    }

    
    AccountDao acdao = new AccountDao();

    public String getNamebyId() {
        return acdao.getNamebyID(idstudent);
    }
    ClubDao sdao =new ClubDao();
    public String getRolebyID(){
        return sdao.getRolebyId(role);
    }
     
     
public String getPosition(){
    if(leader==1){
        return "Leader";
    }else{
        return "Member";
    }
}
}
