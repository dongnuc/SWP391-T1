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
    public  Accounts getAccount(String email) {
        Accounts c=new Accounts();
        String sql = "select *from Student where email = '"+email+"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//               //int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role
                  c= new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                         rs.getString("Email"), rs.getString("password"),
                         rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"),
                         rs.getDate("DateCreate"), rs.getDate("DateModify"),
                         rs.getInt("Status"), rs.getInt("role"),rs.getString("Image"),rs.getString("Note"));
                
            }
        } catch (Exception e) {
        }
        return c;
    }
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
     public Accounts getAccountbyID(int id) {
        Accounts account = null;
        String query = "select * from student where IdStudent=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                account = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"), rs.getString("Email"), rs.getString("password"), rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getInt("Role"),rs.getString("Image"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return account;
    }
 public String getNamebyID(int id) {
        Accounts account = null;
        String query = "select * from Student where IdStudent=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                account = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"), rs.getString("Email"), rs.getString("password"), rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getInt("Role"),rs.getString("Image"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return account.getName();
    }
    public void insertAccount(String account, String password, Date date,String name) {
        String sql = "INSERT INTO Student (Email,password,role,status,DateCreate,NameStudent) VALUES"
                + " (?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account);
            st.setString(2, password);
            st.setInt(3, 0);
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
        public Accounts getAccountEmail(String email) {
        String sql = "select * from Student where Email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("IdStudent");
                String name = rs.getString("NameStudent");
                email = rs.getString("Email");
                String password = rs.getString("password");
                String sdt = rs.getString("Phone");
                int gender = rs.getInt("Gender");
                Date date = rs.getDate("Dob");
                Date datecreate = rs.getDate("DateCreate");
                Date datemodify = rs.getDate("DateModify");
                int status = rs.getInt("Status");
                int role = rs.getInt("role");

                Accounts acc = new Accounts(id, name, email, password, sdt, gender, date, datecreate, datemodify, status, role);
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        public void insertAccountadmin(String email, String password,String name,String gender,String status,String role,String phone) {
        String sql = "INSERT INTO Student (Email,password,role,status,NameStudent,Phone,Gender) VALUES"
                + " (?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3,role );
            st.setString(4, status);
            st.setString(5, name);
            st.setString(6, phone);
            st.setString(7, gender);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
        public void UpdateAccounts(String email, String name, String phone, int gender, String dob,String status,String note) {
    String sql = "UPDATE Student SET NameStudent = ?, Phone = ?, Gender = ?, Dob = ? ,Status = ?,Note=? WHERE email = ?";
    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, name);
        st.setString(2, phone);
        st.setInt(3, gender);
        st.setString(4, dob);
        st.setString(5, status);
        st.setString(7, email);
        st.setString(6, note);
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
    public void UpdateImage(String email, String image) {
    String sql = "UPDATE Student SET Image = ? WHERE email = ?";
    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, image);
        st.setString(2, email);
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
public void UpdateAccount(String email, String name, String phone, int gender, String dob) {
    String sql = "UPDATE Student SET NameStudent = ?, Phone = ?, Gender = ?, Dob = ? WHERE email = ?";
    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, name);
        st.setString(2, phone);
        st.setInt(3, gender);
        st.setString(4, dob);
        st.setString(5, email);
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
        public List<Accounts> getbypage(int id, String search, String status, String sort) {
        List<Accounts> list = new ArrayList<>();
        String sql = "SELECT * FROM Student where 1=1 ";
        if (search != null) {
            sql += " AND (Email LIKE '%" + search + "%' OR Phone LIKE '%" + search + "%' OR NameStudent LIKE '%" + search + "%') ";
        }
        if (!status.equals("all")) {
            sql += " AND Status Like '%" + status + "%' ";
        }
        if (sort != null && sort.equals("IdStudent")) {
            sql += " ORDER BY IdStudent ";
        } else if (sort.equals("NameStudent")) {
            sql += " ORDER BY NameStudent ";
        } else if (sort.equals("Email")) {
            sql += " ORDER BY Email ";
        } else {
            sql += " ORDER BY Phone ";
        }

        sql += " LIMIT 5 OFFSET ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Accounts c = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                        rs.getString("Email"), rs.getString("password"),
                        rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getInt("Status"), rs.getInt("role"), rs.getString("Image"));
                list.add(c);
            }

        } catch (Exception e) {
        }
        return list;
    }
        public int numberpage(String search,String status) {
        String sql = "select count(*) from Student where 1=1 ";
        if(search !=null){
            sql +=" AND Email Like '%"+search+"%' ";
        }
        if(!status.equals("all")){
            sql +=" AND Status Like '%"+status+"%' ";
        }
        int number = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        if (number % 5 == 0) {
            number = number / 5;
        } else {
            number = number / 5 + 1;
        }
        return number;

    }
    public void UpdateStatus(String email,String status) {
    String sql = "UPDATE Student SET status = ? WHERE email = ?";
    try (PreparedStatement st = connection.prepareStatement(sql)) {
        if(status.equals("1")){
            st.setString(1, "0");
        }
        if(status.equals("0")){
            st.setString(1, "1");
        }
        st.setString(2, email);
        
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
    
    public Accounts getAccountByIdSetting(String idAccout){
        String qurery = "SELECT * FROM swp392.student where IdStudent = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(qurery);
            ps.setString(1, idAccout);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"), 
                        rs.getString("Email"),rs.getString("password"), 
                        rs.getString("Phone"),rs.getInt("Status"),
                        rs.getInt("Role"), rs.getString("TokenEmail"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<String> getAccAssumeForm(){
        List<String> getIdAcc = new ArrayList<>();
        String query = "select IdStudent from setting where IdType = 2 and IdForm is null";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String idAcc = rs.getString(1);
                getIdAcc.add(idAcc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getIdAcc;
    }
public String getEmailbyID(int id) {
        Accounts account = null;
        String query = "select * from Student where IdStudent=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                account = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"), rs.getString("Email"), rs.getString("password"), rs.getString("Phone"), rs.getInt("Gender"), rs.getDate("Dob"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getInt("Role"),rs.getString("Image"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return account.getEmail();
    }
        
        public static void main(String[] args) {
        AccountDao db=new AccountDao();
            System.out.println(db.getNamebyID(1));

    }
    
}
