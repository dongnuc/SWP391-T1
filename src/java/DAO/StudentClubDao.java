/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class StudentClubDao extends DBContext {
    public List<String> getclubbtid(int id ) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent="+id;
        List<String> listclub=new ArrayList<>();
        String x ="";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                x = rs.getString("NameClub");
                listclub.add(x);
            }
        } catch (Exception e) {
        }
        return listclub;
    }
    public String getroleofclub(int id,String NameClub ) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent="+id
                + " and NameClub ='"+NameClub+"'";
        String role="";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
        }
        return role;
    }
    
}
