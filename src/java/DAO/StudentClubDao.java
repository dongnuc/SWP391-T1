/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class StudentClubDAO extends DBContext {
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
    
    public List<StudentClub> getStudentClubs(int idStudent) {
    List<StudentClub> studentClubList = new ArrayList<>();
    String sql = "SELECT * FROM StudentClub WHERE IdStudent = ?";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idStudent);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StudentClub studentClub = new StudentClub();
            studentClub.setPoint(rs.getInt("Point"));
            studentClub.setDateCreate(rs.getDate("DateCreate"));
            studentClub.setDateModify(rs.getDate("DateModify"));
            studentClub.setStatus(rs.getInt("Status"));
            studentClub.setIdStudent(rs.getInt("IdStudent"));
            studentClub.setIdClub(rs.getInt("IdClub"));
            studentClubList.add(studentClub);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return studentClubList;
}

    
}
