/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.*;
import java.sql.Connection;
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

    public List<String> getclubbtid(int id) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent=" + id;
        List<String> listclub = new ArrayList<>();
        String x = "";
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


    public int getSizeClub(int id) {
        String query = "SELECT  count(*) AS numberOfMember FROM StudentClub where IdClub=?";
        List<Integer> list = new ArrayList();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("numberOfMember"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list.get(0);
    }
    
 public int getIdStudentByRole(int idclub) {
    int idStudent =0; 
    
    String query = "SELECT IdStudent FROM StudentClub WHERE IdRole = ? and IdClub=?";
    
    try (PreparedStatement st = connection.prepareStatement(query)) {
        st.setInt(1, 1);
        st.setInt(2, idclub);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                idStudent = rs.getInt("IdStudent");
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    
    return idStudent;
}
    
    public List<StudentClub> getStudentClubbyId(int id){
        List<StudentClub> list = new ArrayList<>();
        String query ="SELECT * FROM StudentClub where IdClub=?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
        st.setInt(1, id);
        try (ResultSet rs = st.executeQuery()) {
            while(rs.next()){
                
                StudentClub studentclub = new StudentClub(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getInt(7));
                list.add(studentclub);
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public String getroleofclub(int id, String NameClub) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent=" + id
                + " and NameClub ='" + NameClub + "'";
        String role = "";

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
    
    try (Connection con = DBContext.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
         
        ps.setInt(1, idStudent);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                StudentClub studentClub = new StudentClub();
                studentClub.setPoint(rs.getInt("Point"));
                studentClub.setDateCreate(rs.getDate("DateCreate"));
                studentClub.setDateModify(rs.getDate("DateModify"));
                studentClub.setStatus(rs.getInt("Status"));
                studentClub.setIdStudent(rs.getInt("IdStudent"));
                studentClub.setIdClub(rs.getInt("IdClub"));
                studentClub.setRole(rs.getInt("IdRole"));
                studentClubList.add(studentClub);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return studentClubList;
}


    public static void main(String[] args) {
        StudentClubDAO dao = new StudentClubDAO();
        System.out.println(dao.getStudentClubbyId(34).get(0).getIdStudent());
    }


}
