/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.FormAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class FormDao extends DBContext{
    
    public List<FormAdmin> getFormNoHandle(){
        List<FormAdmin> listForm = new ArrayList<>();
        String query = "SELECT * FROM swp391.form where Handle = 0;";
        try {
             PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FormAdmin form = new FormAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getByte(8), rs.getByte(9));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public static void main(String[] args) {
        FormDao dao = new FormDao();
        List<FormAdmin> listForm = dao.getFormNoHandle();
        System.out.println(listForm.get(0).getEmail());
    }
}
