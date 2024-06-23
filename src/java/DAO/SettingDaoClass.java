/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.SettingSystem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SettingDaoClass extends DBContext {

    public HashMap<String, String> getAllTypeSetting() {
        String query = "select * from typesetting";
        HashMap<String, String> listTypeSetting = new HashMap<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nameType = rs.getString("NameType");
                String idType = rs.getString("IdType");
                listTypeSetting.put(nameType, idType);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeSetting;
    }

    public List<SettingSystem> getAllSettingByType(String idType, String search) {
        List<SettingSystem> listSetting = new ArrayList<>();
        String query = "select s.IdSetting,s.Name,ts.NameType,s.IdForm,s.IdClub,s.IdBlog,s.IdStudent,s.IdEvent,"
                + "s.Status,s.DateCreate,s.DateModify from setting s join typesetting ts ON s.IdType = ts.IdType and";
        int count = 0;
        if (Integer.parseInt(idType) == 1) {
            count++;
            query += " s.IdType = 1 and s.IdClub is null and s.IdStudent is null ";
        }
        if (count > 1) {
            query += "and ";
        }
        if (Integer.parseInt(idType) == 2) {
            count++;
            query += " s.IdType = 2 and s.IdForm is null ";
        }
        if (count > 1) {
            query += " and ";
        }
        if (Integer.parseInt(idType) == 3) {
            count++;
            query += " s.IdType = 3 and s.IdClub is null";
        }
        if (count > 1) {
            query += " and ";
        }
        if (Integer.parseInt(idType) == 4) {
            count++;
            query += " s.IdType = 4 and s.IdBlog is null and s.IdClub is null";
        }
        if (!search.isBlank()) {
            query += " and s.Name like '%" + search + "%'";
        }

        System.out.println(query);
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SettingSystem setting = new SettingSystem(rs.getInt("IdSetting"), rs.getString("Name"),
                        rs.getString("NameType"), rs.getInt("IdForm"), rs.getInt("IdClub"),
                        rs.getInt("IdBlog"), rs.getInt("IdStudent"), rs.getInt("IdEvent"),
                        rs.getInt("Status"), rs.getDate("DateCreate"), rs.getDate("DateModify"));
                listSetting.add(setting);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listSetting;
    }

    public SettingSystem getSettingById(String id) {
        String query = "select s.IdSetting,s.Name,ts.NameType,s.IdForm,s.IdClub,s.IdBlog,s.IdStudent,s.IdEvent,"
                + "s.Status,s.DateCreate,s.DateModify from setting s join typesetting ts ON s.IdType = ts.IdType and"
                + " s.IdSetting = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SettingSystem(rs.getInt("IdSetting"), rs.getString("Name"),
                        rs.getString("NameType"), rs.getInt("IdForm"), rs.getInt("IdClub"),
                        rs.getInt("IdBlog"), rs.getInt("IdStudent"), rs.getInt("IdEvent"),
                        rs.getInt("Status"), rs.getDate("DateCreate"), rs.getDate("DateModify"));

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

//    update Setting
    public void updateSetting(String nameSetting, String idType, String idForm, String idClub,
            String idBlog, String idStudent, String idEvent, String status, String idSetting) {
        String query = " UPDATE `swp392`.`setting`SET ";
        int count = 0;
        if (!nameSetting.isBlank()) {
            query += " `Name` = '" + nameSetting + "'";
            count++;
        }
        if (!idType.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdType` = '" + idType + "'";
            count++;
        }

        if (!idForm.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdForm` = '" + idForm + "'";
        }

        if (!idClub.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdClub` = '" + idClub + "'";
        }

        if (!idBlog.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdBlog` = '" + idBlog + "'";
        }

        if (!idStudent.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdStudent` = '" + idStudent + "'";
        }

        if (!idEvent.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`IdEvent` = '" + idEvent + "'";
        }

        if (!status.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`Status` = '" + status + "'";
        }

        query += " where idSetting = " + idSetting;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

//    Insert
    public void insertSetting(String nameSetting, String idType, String idForm, String idClub,
            String idBlog, String idStudent, String idEvent, String status) {
        String query = "INSERT INTO `swp392`.`setting`\n"
                + "(\n"
                + "`Name`,\n"
                + "`IdType`,\n"
                + "`IdForm`,\n"
                + "`IdClub`,\n"
                + "`IdBlog`,\n"
                + "`IdStudent`,\n"
                + "`IdEvent`,\n"
                + "`Status`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?);";
        if(idForm.isBlank()){
            idForm = null;
        }
        if(idClub.isBlank()){
            idClub = null;
        }
        if(idBlog.isBlank()){
            idBlog = null;
        }
        if(idStudent.isBlank()){
            idStudent = null;
        }
        if(idEvent.isBlank()){
            idEvent = null;
        }
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nameSetting);
            ps.setString(2, idType);
            ps.setString(3, idForm);
            ps.setString(4, idClub);
            ps.setString(5, idBlog);
            ps.setString(6, idStudent);
            ps.setString(7, idEvent);
            ps.setString(8, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SettingDaoClass dao = new SettingDaoClass();
        List<SettingSystem> list = dao.getAllSettingByType("2", "");
        System.out.println(list.size());
        SettingSystem s = dao.getSettingById("1");
        System.out.println(s);
        dao.insertSetting("Feedback Student", "2", "", "", "", "1", "", "1");
//        dao.updateSetting(nameSetting, idType, idForm, idClub, idBlog, idStudent, idEvent, status, idSetting);
    }

}
