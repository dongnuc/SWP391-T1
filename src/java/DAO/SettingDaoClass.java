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
     public int namePageSetting(String category, String search, String status){
        String query = "select count(*) from settings where 1 = 1 and status = ? ";
        if (!category.equals("All")) {
            query += " and typeSetting = " + category;
        }
        if (!search.isBlank()) {
            query += " and valueSetting like '%" + search + "%' ";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int numberPage = rs.getInt(1);
                if(numberPage % 5 == 0){
                    numberPage /= 5;
                }else{
                    numberPage = numberPage / 5 + 1;
                }
                return numberPage;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
      public List<SettingSystem> getAllSettingDong(String category, String search, String status, int page) {
        List<SettingSystem> listSetting = new ArrayList<>();
        String query = "select s.idSetting, s.valueSetting, ts.NameType, s.idStudent, s.DateCreate, s.DateModify, s.status\n"
                + " from settings s join typesetting ts ON s.typeSetting = ts.IdType where 1 = 1 and s.status = ? ";
        if (!category.equals("All")) {
            query += " and s.typeSetting = " + category;
        }
        if (!search.isBlank()) {
            query += " and s.valueSetting like '%" + search + "%' ";
        }

        query += " order by s.idSetting limit 4 offset ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, page * 4 - 4);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SettingSystem setting = new SettingSystem(rs.getInt("idSetting"),
                        rs.getString("valueSetting"), rs.getString("NameType"),
                        rs.getInt("idStudent"), rs.getInt("status"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"));
                listSetting.add(setting);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listSetting;
    }
       public void updateSettingDong(String idSetting, String valueSetting,String typeSetting,String idStudent, String status){
        String query = "UPDATE `settings` SET ";
        int count = 0;
        if (!valueSetting.isBlank()) {
            query += " `valueSetting` = '" + valueSetting + "' ";
            count++;
        }
        if(!typeSetting.isBlank()){
            if(count > 0){
                query += ", ";
            }
            query += "`typeSetting` = '" + typeSetting + "' ";
        }
        if(!idStudent.isBlank()){
            if(count > 0){
                query += ", ";
            }
            query += "`idStudent` = '" + idStudent + "' ";
        }
        if (!status.isBlank()) {
            if (count > 0) {
                query += ", ";
            }
            query += "`Status` = '" + status + "' ";
        }
         query += " where idSetting = " + idSetting;
         try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
    public SettingSystem getSettingByIdDong(String idSetting) {
        String query = "select s.idSetting, s.valueSetting, ts.NameType, s.idStudent, s.DateCreate, s.DateModify, s.status\n"
                + "from settings s join typesetting ts ON s.typeSetting = ts.IdType where s.idSetting = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idSetting);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {              
                return new SettingSystem(rs.getInt("idSetting"), rs.getString("valueSetting"),
                        rs.getString("NameType"), rs.getInt("idStudent"),
                        rs.getInt("status"), rs.getDate("DateCreate"), rs.getDate("DateModify"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    //    Insert
    public void insertSettingDong(String nameSetting, String idType,String idStudent, String status) {
        String query = "INSERT INTO `settings`\n"
                + "(\n"
                + "`valueSetting`,\n"
                + "`typeSetting`,\n"
                + "`IdStudent`,\n"
                + "`Status`)\n"
                + "VALUES\n"
                + "(?,?,?,?);";

        if (idStudent.isBlank()) {
            idStudent = null;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nameSetting);
            ps.setString(2, idType);
            ps.setString(3, idStudent);
            ps.setString(4, status);
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public HashMap<String, String> getAllTypeSettingDong(String status) {
        String query = "select * from typesetting where status = ?";
        HashMap<String, String> listTypeSetting = new HashMap<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nameType = rs.getString("NameType");
                String idType = rs.getString("IdType");
                listTypeSetting.put(idType,nameType );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeSetting;
    }
    

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
            rs.close();
            ps.close();
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
            rs.close();
            ps.close();
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
            rs.close();
            ps.close();
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
            
            ps.close();
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
            
            ps.close();
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
