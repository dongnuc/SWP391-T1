/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Controller.Guest.MyRegistration;
import Model.Accounts;
import Model.EventRegistration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 84358
 */
public class EventRegistrationDao extends DBContext {

    public void insertMemberEvent(String phone, String idEvent, String name, String gmail, int status) {
        String sql = "INSERT INTO eventregister (Phone, IdEvent, Name, Gmail, Status) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phone);
            st.setString(2, idEvent);
            st.setString(3, name);
            st.setString(4, gmail);
            st.setInt(5, status);

            st.executeUpdate();
        } catch (Exception e) {

        }
    }
    public void UpdateNameandPhone(String ideventregister,String phone ,String Name) {
        String sql = "UPDATE eventregister SET Phone = ?, Name = ? WHERE EventRegisterId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phone);
            st.setString(2, Name);
            st.setString(3, ideventregister);

            st.executeUpdate();
        } catch (Exception e) {

        }
    }
   public boolean CheckregisterEvent(String idevent, String gmail) {
    String sql = "SELECT COUNT(*) FROM eventregister WHERE IdEvent = ? AND gmail = ?;";
    try { 
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, idevent);
        st.setString(2, gmail);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; 
        }
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    return false; // Trả về false mặc định nếu có lỗi xảy ra
}
    
    public EventRegistration getEventRegistration(int ideventregistration) {
        String sql = "SELECT * FROM eventregister where EventRegisterId = ?";
        EventRegistration x=null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ideventregistration);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                 x = new EventRegistration(rs.getInt("EventRegisterId"),
                         rs.getInt("IdEvent"),
                         rs.getString("Name"),
                         rs.getString("Status"),
                         rs.getString("Note"),
                         rs.getString("Phone"),
                         rs.getString("Name"),
                         rs.getString("Gmail"));
                

            }

        } catch (Exception e) {

        }
        return x;
    }

    public List<EventRegistration> getMyEventRegistration(String gmail) {
        List<EventRegistration> list = new ArrayList<>();
        String query = "SELECT * FROM eventregister e join event v"
                + " on e.IdEvent=v.IdEvent where e.Gmail = ? and 1=1";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, gmail);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EventRegistration x = new EventRegistration(rs.getInt("eventregisterid"),rs.getString("NameEvent"),
                        rs.getDate("DateStart"),
                        rs.getDate("DateEnd"), rs.getString("Addreess"), rs.getString("Status"));
                list.add(x);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<EventRegistration> getbypage(int id, String sort, String gmail, String search) {
        List<EventRegistration> list = new ArrayList<>();
        String sql = "SELECT * FROM eventregister e join event v"
                + " on e.IdEvent=v.IdEvent where e.Gmail = ? and 1=1 ";
        if (search != null) {
            sql += " AND (v.NameEvent LIKE '%" + search + "%' OR v.Description LIKE '%" + search + "%' OR v.Addreess LIKE '%" + search + "%') ";
        }
        if (sort != null && sort.equals("past")) {
            sql += " And v.DateEnd <  NOW() ";
        } else if (sort.equals("present")) {
            sql += " AND NOW() BETWEEN v.DateStart AND v.DateEnd";
        } else if (sort.equals("future")) {
            sql += " AND v.DateStart > NOW()";
        }
        sql += " LIMIT 5 OFFSET ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gmail);
            st.setInt(2, id * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EventRegistration x = new EventRegistration(rs.getInt("eventregisterid"),rs.getString("NameEvent"),
                        rs.getDate("DateStart"),
                        rs.getDate("DateEnd"), rs.getString("Addreess"), rs.getString("Status"));
                list.add(x);

            }

        } catch (Exception e) {
        }
        return list;
    }

    public int numberpage(String gmail, String sort, String search) {
        String sql = "select count(*) from  eventregister e join event v"
                + " on e.IdEvent=v.IdEvent where e.Gmail = ? and 1=1  ";
        if (search != null) {
            sql += " AND (v.NameEvent LIKE '%" + search + "%' OR v.Description LIKE '%" + search + "%' OR v.Addreess LIKE '%" + search + "%') ";
        }
        if (sort != null && sort.equals("past")) {
            sql += " And v.DateEnd <  NOW() ";
        } else if (sort.equals("present")) {
            sql += " AND NOW() BETWEEN v.DateStart AND v.DateEnd";
        } else if (sort.equals("future")) {
            sql += " AND v.DateStart > NOW()";
        }
        int number = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gmail);
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

    public List<EventRegistration> getmemberclub(int id, String sort, String idevent,String search) {
        List<EventRegistration> list = new ArrayList<>();
        String sql = "SELECT * FROM eventregister e join event v"
                + " on e.IdEvent=v.IdEvent where v.IdEvent = ? and 1=1 ";
        if (sort != null && sort.equals("past")) {
            sql += " And v.DateEnd <  NOW() ";
        } else if (sort.equals("present")) {
            sql += " AND NOW() BETWEEN v.DateStart AND v.DateEnd";
        } else if (sort.equals("future")) {
            sql += " AND v.DateStart > NOW()";
        }
        if (search != null&&!search.isEmpty()) {
            sql += " AND v.NameEvent LIKE '%" + search + "%'";
        }
        sql += " LIMIT 5 OFFSET ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, idevent);
            st.setInt(2, id * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EventRegistration x = new EventRegistration(
                        rs.getInt("EventRegisterId"), rs.getInt("IdEvent"),
                        rs.getString("NameEvent"), rs.getString(6),
                        rs.getString("Note"), rs.getString("Phone"),
                        rs.getString("Name"), rs.getString("Gmail"));
                list.add(x);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Integer> getIDEvent(String idclub, String sort) {
        List<Integer> list = new ArrayList<>();
        String sql = "SELECT * FROM event where IdClub= ?";
        if (sort != null && sort.equals("past")) {
            sql += " And DateEnd <  NOW() ";
        } else if (sort.equals("present")) {
            sql += " AND NOW() BETWEEN DateStart AND DateEnd";
        } else if (sort.equals("future")) {
            sql += " AND DateStart > NOW()";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, idclub);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("IdEvent");
                list.add(x);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int numberpages(String sort, String idevent,String search) {
        String sql = "select count(*) from  eventregister e join event v"
                + " on e.IdEvent=v.IdEvent where v.IdEvent = ? and 1=1  ";

        if (sort != null && sort.equals("past")) {
            sql += " And v.DateEnd <  NOW() ";
        } else if (sort.equals("present")) {
            sql += " AND NOW() BETWEEN v.DateStart AND v.DateEnd";
        } else if (sort.equals("future")) {
            sql += " AND v.DateStart > NOW()";
        }
        if (search != null&&!search.isEmpty()) {
            sql += " AND v.NameEvent LIKE '%" + search + "%'";
        }
        int number = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, idevent);
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

    public void UpdateStatus(int ideventregister, String action, String reason) {
        String sql = "UPDATE eventregister SET Status = ? , Note =? WHERE EventRegisterId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, action);
            st.setInt(3, ideventregister);
            st.setString(2, reason);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<String> GetClubofManager(int idstudent) {
        List<String> list=new ArrayList<>();
        String sql = "SELECT * \n"
                + "FROM swp391huy.studentclub \n"
                + "WHERE IdStudent=? \n"
                + "AND (Leader='1' OR Role='1');";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idstudent);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("IdClub"));
            }
            
            
        } catch (Exception e) {
        }
        return list;
    }
    public String getNameEvent(int idevent){
        String x="";
        String sql = "select *from Event where IdEvent=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idevent);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                x=rs.getString("NameEvent");
            }
            
            
        } catch (Exception e) {
        }
        return x;
        
    }

    public static void main(String[] args) {
        EventRegistrationDao d = new EventRegistrationDao();
        
//        System.out.println(list.size());
        List<String> lisss=d.GetClubofManager(17);
        EventRegistration my=d.getEventRegistration(1);

        String abc=d.getNameEvent(6);
        System.out.println(abc);
                
    }

}
