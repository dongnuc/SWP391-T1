/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Form;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FormDao extends DBContext {

    public List<Form> getAllForm() {
        List<Form> listForm = new ArrayList<>();
        String sql = "SELECT * FROM swp391.form where status = 1;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getByte(7), rs.getByte(8), rs.getInt(9));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    public Form getFormByID(String idForm) {
        String query = "SELECT * FROM swp391.form where IdForm = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getByte(7), rs.getByte(8), rs.getInt(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Form> getFormDelete() {
        List<Form> listForm = new ArrayList<>();
        String sql = "select * from form where status = 0;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getByte(7), rs.getByte(8), rs.getInt(9));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    public List<Form> searchByTittleExist(String tittle) {
        List<Form> listForm = new ArrayList<>();
        String query = "SELECT * FROM swp391.form where status = 1";
        if (!tittle.isEmpty()) {
            query += " and TittleForm like '%" + tittle + "%'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getByte(7), rs.getByte(8), rs.getInt(9));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    public List<Form> searchByTittleNoExist(String tittle) {
        List<Form> listForm = new ArrayList<>();
        String query = "SELECT * FROM swp391.form where status = 0";
        if (!tittle.isEmpty()) {
            query += " and TittleForm like '%" + tittle + "%'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6),
                        rs.getByte(7), rs.getByte(8), rs.getInt(9));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    //delete Form
    public void deleteFormById(String idForm) {
        String query = "UPDATE `swp391`.`form`\n"
                + "SET `Status` = 0 where IdForm = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Insert 
    public void insertForm(String fullName, String email, String tittle, String content, Date dateCreate,
            byte handle, byte status, String idClub,byte isRead) {
        String query = "INSERT INTO `swp391`.`form`\n"
                + "(`FullName`,`Email`,`TittleForm`,`Content`,`DateCreate`,`Handle`,`Status`,`IdClub`,`isRead`)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, fullName);
            st.setString(2, email);
            st.setString(3, tittle);
            st.setString(4, content);
            java.sql.Date sqlDate = new java.sql.Date(dateCreate.getTime());
            st.setDate(5, sqlDate);
            st.setByte(6, handle);
            st.setByte(7, status);
            st.setString(8, idClub);
            st.setByte(9, isRead);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        FormDao dao = new FormDao();

        Form form = dao.getFormByID("1");
//        System.out.println(form.getEmail());
        dao.deleteFormById("2");
        List<Form> listForm = dao.searchByTittleExist("Event");
        System.out.println(listForm.size());
    }

}
