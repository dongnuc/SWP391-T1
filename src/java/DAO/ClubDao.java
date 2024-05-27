/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Accounts;
import Model.Clubs;
import Model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class ClubDao extends DBContext{
    
    //select
    public  List<String> getAllClub() {
        List<String> list=new ArrayList<>();
        String sql = "select * from Club ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//               //int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role
                 String x=rs.getString("NameClub");
                 list.add(x);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Clubs> getClubAll(){
        List<Clubs> listClub = new ArrayList<>();
        String query = "select * from club";
        try {
            
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Clubs club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }
    
    
    public List<Clubs> getListClubsById(String idAcc){
        String query = "SELECT * FROM swp391.studentclub where IdStudent = ?";
        List<Clubs> getClubs = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idAcc);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String idClub = rs.getString(1);
                Clubs club = getClubsById(idClub);
                getClubs.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getClubs;
    }
    
    public Clubs getClubsById(String idClub){
        String query = "SELECT * FROM swp391.club where IdClub = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Role> getAllRole(String idClub){
        String query = "select DISTINCT  sc.IdRole from Student s join studentclub sc on s.IdStudent = sc.IdStudent where sc.IdClub = ?";
        List<Role> listRole = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String idRole = rs.getString("sc.IdRole");
                Role role = getRoleById(idRole);
                listRole.add(role);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listRole;
    }
    
    public Role getRoleById(String idRole){
        String query = "SELECT * FROM swp391.role where IdRole = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idRole);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Role(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        ClubDao clubdao=new ClubDao();
        System.out.println(clubdao.getAllClub().size());
    }
    
}
