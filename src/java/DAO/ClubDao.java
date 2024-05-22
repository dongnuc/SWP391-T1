/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Accounts;
import Model.Clubs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class ClubDao extends DBContext{
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
                Clubs club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }
    public static void main(String[] args) {
        ClubDao clubdao=new ClubDao();
        System.out.println(clubdao.getAllClub().size());
    }
    
}
