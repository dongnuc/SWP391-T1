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
import java.util.Date;
import java.util.List;

/**
 *
 * @author 84358
 */
public class AccountDao extends DBContext{
    public  List<Accounts> getAll() {
        List<Accounts> list=new ArrayList<>();
        String sql = "select *from Student ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//               //int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role
                 Accounts c= new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                         rs.getString("Email"), rs.getString("password"),
                         rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"),
                         rs.getDate("DateCreate"), rs.getDate("DateModify"),
                         rs.getInt("Status"), rs.getInt("role"));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int getidaccount() {
        String sql = "select count(*)from Student";
        int x = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                x = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return x;
    }
    public void insertAccount(String account, String password, Date date,String name) {
        String sql = "INSERT INTO Student (Email,password,role,status,DateCreate,NameStudent) VALUES"
                + " (?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            st.setString(2, password);
            st.setInt(3, 1);
            st.setInt(4, 1);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(5, sqlDate);
            st.setString(6, name);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
    public void insertAccountGoogle(String account,Date date,String Name) {
        String sql = "INSERT INTO Student (Email,role,DateCreate,status,NameStudent) VALUES"
                + " (?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            st.setInt(2, 1);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(3, sqlDate);
            st.setInt(4, 1);
            st.setString(5, Name);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
    public void Resetpassword(String password, String account) {
        String sql = "UPDATE Student SET password = ? WHERE email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setString(2, account);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
        public String getoldpassword(String account) {
        String password = "";
        String sql = "select *from Student where Email= ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (Exception e) {
        }
        return password;
    }
        public int getidofaccount(String account) {
        int id=0;
        String sql = "select *from account where account= ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
        }
        return id;
    }
        public int getrole(String account) {
        int id=0;
        String sql = "select *from Student where Email= ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("role");
            }
        } catch (Exception e) {
        }
        return id;
    }
    
        // 
        
        public List<Accounts> getAllAccByIdClub(String idClub){
            String query = "select * from Student s join studentclub sc on s.IdStudent = sc.IdStudent where sc.IdClub = ?";
            List<Accounts> listAccount = new ArrayList<>();
            ClubDao clubDao = new ClubDao();
            try {
                PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String idRole = rs.getString(19);
                
                Accounts acc = new Accounts(rs.getInt(1), rs.getString(2), rs.getInt(6), rs.getDate(7), rs.getInt(13), rs.getInt("sc.Status"), rs.getInt(19));
                listAccount.add(acc);
            }
            } catch (Exception e) {
                System.out.println(e);
            }
            return listAccount;
        }
        
        
        public static void main(String[] args) {
        AccountDao db=new AccountDao();
        int y=db.getrole("huynhe170275@fpt.edu.vn");
//        System.out.println(y);
        List<Accounts> getAll = db.getAllAccByIdClub("1");
            System.out.println(getAll.size());

    }
    
}
