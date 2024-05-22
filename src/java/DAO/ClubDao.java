/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Accounts;
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
        String sql = "select *from Club ";
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
    public static void main(String[] args) {
        ClubDao clubdao=new ClubDao();
        System.out.println(clubdao.getAllClub().size());
    }
    
}
