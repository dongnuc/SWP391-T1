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
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(6),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getInt(7), rs.getInt(8));
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
                return new Form(rs.getInt(1), rs.getString(2), rs.getString(6),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getInt(7), rs.getInt(8));
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

                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(6),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getInt(7), rs.getInt(8));
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
                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(6),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getInt(7), rs.getInt(8));
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

                Form form = new Form(rs.getInt(1), rs.getString(2), rs.getString(6),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getInt(7), rs.getInt(8));
                listForm.add(form);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    public int countFormNoRead() {
        String query = "select count(isRead) from form where isRead = 0 and Status = 1;";
        int number = -1;
        try {
            PreparedStatement ps = connection.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                number = rs.getInt(1);
                return number;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }

    //Update
    public void readForm(String idForm) {
        String query = "UPDATE `swp391`.`form`\n"
                + "SET `isRead` = 1 where IdForm = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
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


    public void insertForm(String fullName, String titleForm, String content, Date dateCreate, String email) {
        String query = "INSERT INTO `swp391`.`form`\n"
                + "(\n"
                + "`FullName`,\n"
                + "`TittleForm`,\n"
                + "`Content`,\n"
                + "`DateCreate`,\n"
                + "`Email`)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, fullName);
                ps.setString(2, titleForm);
                ps.setString(3, content);
                java.sql.Date sqlDate = new java.sql.Date(dateCreate.getTime());
                ps.setDate(4, sqlDate);
                ps.setString(5, email);
                ps.executeUpdate();         
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }

    public static void main(String[] args) {
        FormDao dao = new FormDao();

        Form form = dao.getFormByID("1");
//        System.out.println(form.getEmail());
//        dao.deleteFormById("2");
//        List<Form> listForm = dao.searchByTittleExist("Event");
//        System.out.println(listForm.size());
//        System.out.println(dao.countFormNoRead());
        Date dateNow = new Date();
        dao.insertForm("Dong", "Bao cao su kiện", "Sự Kiện lỗi", dateNow, "dongnuc2k3@gmail.com");
    }

}
