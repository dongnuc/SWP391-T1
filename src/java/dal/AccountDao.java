/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Entity.Accounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class AccountDao extends DBContext{
    public  List<Accounts> getAll() {
        List<Accounts> list=new ArrayList<>();
        String sql = "select *from Account ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Accounts c = new Accounts(rs.getInt("id"), rs.getInt("role"),
                        rs.getString("account"), rs.getString("password"));

                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int getidaccount() {
        String sql = "select count(*)from Account";
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
    public void insertAccount(int id, String account, String password, int role) {
        String sql = "INSERT INTO Account (id, account, password,role) VALUES"
                + " (?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, account);
            st.setString(3, password);
            st.setInt(4, role);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
    public void Resetpassword(String password, String account) {
        String sql = "UPDATE Account SET password = ? WHERE account = ?";
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
        String sql = "select *from account where account= ?";

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
        public static void main(String[] args) {
        AccountDao ac=new AccountDao();
        String password=ac.getoldpassword("huynhe170275@fpt.edu.vn");
        System.out.println(password);
    }
    
}
