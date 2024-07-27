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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FormDao extends DBContext {
    public int countFormDeleteDong(String idCategory) {
        String query = "select count(*) from form where status = 0 and CategoryForm = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCategory);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
                        rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
         
    public void insertFormDong(String fullName, String tittleForm, String content, String email, String phone, String category) {
        String query = " INSERT INTO `newsetting`.`form`\n"
                + "(`FullName`,`TittleForm`,`Content`,`Email`,`Phone`,`CategoryForm`)\n"
                + "VALUES (?,?,?,?,?,?); ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, tittleForm);
            ps.setString(3, content);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, category);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public HashMap<String, String> getCategoryFormCDong() {
        HashMap<String, String> categoryForm = new HashMap<>();
        String query = "select idSetting, valueSetting from settings where typeSetting = 2 and status = 1; ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String keyForm = rs.getString("idSetting");
                String valueForm = rs.getString("valueSetting");
                categoryForm.put(keyForm, valueForm);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return categoryForm;
    }

    public String getCategoryFormDong(String idStudent) {
        String query = "select idSetting from settings where typeSetting = 2 and idStudent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idStudent);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<String> getAllCategoryFormDong() {
        List<String> listFormType = new ArrayList<>();
        String query = "select valueSetting from settings where typeSetting = 2 ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listFormType.add(rs.getString(1));
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listFormType;
    }

    public List<Form> getListFormDong(int pageCurrent, String category, String tittle, String status) {
        List<Form> listForm = new ArrayList<>();
        String query = "select * from form where status = ? and CategoryForm = '" + category + "'";
        if (!tittle.isBlank()) {
            query += " and TittleForm like '%" + tittle + "%'";
        }
        query += " ORDER BY DateCreate DESC LIMIT 4 OFFSET ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, pageCurrent * 4 - 4);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Form getForm;
                getForm = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getString("email"), rs.getInt("Status"), rs.getInt("isRead"),
                        rs.getString("Phone"));
                listForm.add(getForm);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }

    public int numberPageFormDong(String categoryId,String status) {
        int numberPage = 0;
        String query = "select COUNT(*) from form where status = ? and CategoryForm = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberPage = rs.getInt(1);
            }
            if (numberPage % 4 == 0) {
                numberPage /= 4;
            } else {
                numberPage = (numberPage / 4) + 1;
            }
rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return numberPage;
    }

    public int countFormDong(String idCategory) {
        String query = "select count(*) from form where status = 1 and CategoryForm = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCategory);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int countFormNoReadDong(String idCategory) {
        String query = "select count(*) from form where status = 1 and isRead = 0 and CategoryForm = " + idCategory;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }rs.close();
                        ps.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Form getFormByIdDong(String idForm) {
        String query = "select * from form where IdForm = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idForm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Form getForm = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getString("email"), rs.getInt("Status"), rs.getInt("isRead"),
                        rs.getString("Phone"));
                return getForm;
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Form> getFormReplyDong(String idForm) {
        List<Form> listFormReply = new ArrayList<>();
        String query = "select * from form_reply where Status = 1 and IdForm = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idForm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Form formReply = new Form(rs.getInt("IdReply"), rs.getString("ContentReply"),
                        rs.getDate("DateSend"), rs.getInt("Status"));
                listFormReply.add(formReply);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listFormReply;
    }

    public List<Form> getFormSentDong(String categoryId, String search, int page) {
    List<Form> listFormReply = new ArrayList<>();
    String query = "SELECT DISTINCT f.IdForm, f.FullName, f.TittleForm, f.Content, f.DateCreate, f.DateModify, f.Email, f.Phone, f.Status, f.isRead " +
                   "FROM form f " +
                   "JOIN form_reply fr ON f.IdForm = fr.IdForm " +
                   "WHERE f.CategoryForm = ?";

    if (search != null && !search.isEmpty()) {
        query += " AND f.TittleForm LIKE ?";
    }
    
    int number = page * 4 - 4;
    query += " ORDER BY f.DateCreate DESC LIMIT 4 OFFSET ?";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setString(1, categoryId);
        
        if (search != null && !search.isEmpty()) {
            ps.setString(2, "%" + search + "%");
            ps.setInt(3, number);
        } else {
            ps.setInt(2, number);
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Form getForm = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                                        rs.getString("TittleForm"), rs.getString("Content"),
                                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                                        rs.getString("Email"), rs.getInt("Status"), rs.getInt("isRead"),
                                        rs.getString("Phone"));
                listFormReply.add(getForm);
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return listFormReply;
}
    
    public HashMap<String, String> typeForm() {
        String query = "select * from Setting where IdType = 2 and IdForm is  null and Status = 1;";
        HashMap<String, String> listType = new HashMap<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nameType = rs.getString("Name");
                String idStudent = rs.getString("IdStudent");
                listType.put(idStudent, nameType);
            }
            rs.close();
                        
        } catch (Exception e) {
            System.out.println(e);
        }
        return listType;
    }
    public void readFormDong(String idForm) {
        String query = " UPDATE form SET `isRead` = 1 WHERE `IdForm` = ?; ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idForm);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int numberPageFormSent(String category) {
        String query = "select  count(*) from (SELECT DISTINCT f.IdForm FROM form f JOIN form_reply fr\n"
                + " ON f.IdForm = fr.IdForm WHERE f.CategoryForm = ?) as distinctForms";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numberPage = rs.getInt(1);
                if (numberPage % 4 == 0) {
                    numberPage /= 4;
                } else {
                    numberPage = numberPage / 4 + 1;
                }
                return numberPage;
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
     public void removeFormDong(String idForm) {
        String query = "UPDATE form SET `Status` = 0 WHERE `IdForm` = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idForm);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public void insertFormReplyDong(String content, String idForm) {
        String query = "INSERT INTO form_reply\n"
                + "(`ContentReply`,`IdForm`)\n"
                + "VALUES\n"
                + "(?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, content);
            ps.setString(2, idForm);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public String getNameFormStudentManager(String idAcc) {
        String nameForm = "";
        String sql = "select * from Setting where IdType = 2 and IdForm is null and Status = 1 and IdStudent = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, idAcc);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                nameForm = rs.getString("Name");
            }
            rs.close();
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return nameForm;
    }
    
    public List<Form> getAllFormByAcc(String idAcc, int status) {
        String nameType = getNameFormStudentManager(idAcc);
        List<Form> listForm = new ArrayList<>();
        String sql = "select f.IdForm,f.FullName, f.Email, f.TittleForm, f.Content, f.DateCreate,"
                + " f.DateModify,f.Status, f.isRead from Form f join Setting st ON f.IdForm = st.IdForm"
                + " where f.status = ? " + "and st.Name = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setString(2, nameType);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getString("Email"), rs.getInt("Status"), rs.getInt("isRead"));
                listForm.add(form);
            }
            rs.close();
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public List<Form> getFormReply(String idForm){
        List<Form> listFormReply = new ArrayList<>();
        String query = "SELECT * FROM swp392.form_reply where idForm = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idForm);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Form formReply = new Form(rs.getInt("IdReply"), rs.getString("ContentReply"),
                        rs.getDate("DateSend"), rs.getInt("Status"));
                listFormReply.add(formReply);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listFormReply;
    }
    
    public List<Form> getFormSent(){
        List<Form> listForm = new ArrayList<>();
        String query = " select distinct(f.IdForm),f.TittleForm,f.Content,f.Email,f.FullName,f.Status,f.isRead,"
                + "f.DateCreate,f.DateModify,f.Phone from form f join form_reply fr ON f.idForm = fr.IdForm";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Form form = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getString("Email"), rs.getInt("Status"), rs.getInt("isRead"));
                listForm.add(form);
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public Form getFormByID(String idForm) {
        String query = "SELECT * FROM swp392.form where IdForm = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getString("Email"),
                        rs.getInt("Status"), rs.getInt("isRead"),
                        rs.getString("Phone"));
            }
            rs.close();
                        st.close();
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
            rs.close();
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public List<Form> searchByTittleExist(String tittle, String idAcc) {
        String nameType = getNameFormStudentManager(idAcc);
        List<Form> listForm = new ArrayList<>();
        String query = "select f.IdForm,f.FullName, f.Email, f.TittleForm, f.Content, f.DateCreate,"
                + " f.DateModify,f.Status, f.isRead from Form f join Setting st ON f.IdForm = st.IdForm"
                + " where f.status = 1\n" + "and st.Name = ? and st.IdType = 2";
        if (!tittle.isEmpty()) {
            query += " and f.TittleForm like '%" + tittle + "%';";
        }
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameType);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Form form = new Form(rs.getInt("IdForm"), rs.getString("FullName"),
                        rs.getString("TittleForm"), rs.getString("Content"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getString("Email"), rs.getInt("Status"), rs.getInt("isRead"));
                listForm.add(form);
            }
            rs.close();
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public List<Form> searchByTittleNoExist(String tittle) {
        List<Form> listForm = new ArrayList<>();
        String query = "SELECT * FROM swp392.form where status = 0";
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
            rs.close();
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listForm;
    }
    
    public int countFormNoRead(String idAcc) {
        String nameType = getNameFormStudentManager(idAcc);
        
        String query = "select count(f.isRead) from Form f join Setting st ON f.IdForm = st.IdForm"
                + " where f.status = 1\n" + "and st.Name = ? and st.IdType = 2 and f.isRead = 0;";
        int number = -1;
        try {
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, nameType);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                number = rs.getInt(1);
                return number;
            }
            rs.close();
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }

    //Update
    public void readForm(String idForm) {
        String query = "UPDATE `swp392`.`form`\n"
                + "SET `isRead` = 1 where IdForm = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            st.executeUpdate();
            
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //delete Form
    public void deleteFormById(String idForm) {
        String query = "UPDATE `swp392`.`form`\n"
                + "SET `Status` = 0 where IdForm = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idForm);
            st.executeUpdate();
            
                        st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Insert 
    public void insertForm(String fullName, String titleForm, String content, String email, String phone) {
        String query = "INSERT INTO Form (FullName, TittleForm, Content, Email, Phone)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, titleForm);
            ps.setString(3, content);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertFormReply(String content, String idForm) {
        String query = "INSERT INTO `swp392`.`form_reply`\n"
                + "(`ContentReply`,`IdForm`)\n"
                + "VALUES\n"
                + "(?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, content);
            ps.setString(2, idForm);
            ps.executeUpdate();
            
                        ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertSettingForm(String nameSetting, String idStudent) {
        String sqlGetIdForm = "SELECT * FROM Form\n"
                + "ORDER BY DateCreate DESC\n"
                + "LIMIT 1;";
        String sqlInsertSetting = "INSERT INTO `swp392`.`setting`(\n"
                + "`Name`,\n"
                + "`IdType`,\n"
                + "`IdForm`,\n"
                + "`IdStudent`\n"
                + ")\n"
                + "VALUES(?,?,?,?);";
        try {
            PreparedStatement ps1 = connection.prepareStatement(sqlGetIdForm);
            PreparedStatement psInsert = connection.prepareStatement(sqlInsertSetting);
            
            ResultSet rs = ps1.executeQuery();
            String idForm = "";
            if (rs.next()) {
                idForm = rs.getString("IdForm");
            }
            psInsert.setString(1, nameSetting);
            psInsert.setInt(2, 2);
            psInsert.setString(3, idForm);
            psInsert.setString(4, idStudent);
            psInsert.executeUpdate();
            rs.close();
                        ps1.close();
                        psInsert.close();
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
//        dao.insertForm("Dong", "Bao cao su kiện", "Sự Kiện lỗi", dateNow, "dongnuc2k3@gmail.com");
    }

}
