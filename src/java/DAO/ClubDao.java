/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Accounts;
import Model.Clubs;
import Model.RegisterClub;
import Model.Role;
import Model.TypeClub;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class ClubDao extends DBContext {

    public List<String> getAllClub() {
        List<String> list = new ArrayList<>();
        String sql = "select * from Club ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//               //int id, String name, String email, String password, String sdt, int gender, Date date, Date datecreate, Date datemodify, int status, int role
                String x = rs.getString("NameClub");
                list.add(x);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TypeClub> gettypeclubAll() {
        List<TypeClub> listTypeClub = new ArrayList<>();
        String query = "select * from typeclub";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                TypeClub typeclub = new TypeClub(rs.getInt(1), rs.getString(2));
                listTypeClub.add(typeclub);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeClub;
    }

    public List<Role> getAllRole(String idClub){
        String query = "select DISTINCT  sc.IdRole from Student s join studentclub sc on s.IdStudent = sc.IdStudent where sc.IdClub = ?";
        List<Role> listRole = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String idRole = rs.getString("sc.IdRole");
                Role role = getRoleById(idRole);
                listRole.add(role);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listRole;
    }
    
     public Role getRoleById(String idRole){
        String query = "SELECT * FROM swp391.role where IdRole = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idRole);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Role(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Clubs> getClubAll() {
        List<Clubs> listClub = new ArrayList<>();
        String query = "select * from club";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Clubs club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }

    public int getNumberOfClub() {
        String query = "select count(*) AS numberOfClub from club ";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfClub");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Clubs> getNineClubs(int page) {
        List<Clubs> listClub = new ArrayList<>();
        int offset = 9 * (page - 1);
        String query = "select * from club limit 9 offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, offset);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }

    public void insertClub(Clubs club) {

        String query = "INSERT INTO Club (NameClub, Point, DateCreate, DateModify, Status, IdTypeClub,Image,description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, club.getNameclub());
            st.setInt(2, club.getPoint());
            st.setString(3, club.getDatecreate());
            st.setString(4, club.getModify());
            st.setInt(5, club.getStatus());
            st.setInt(6, club.getType());
            st.setString(7, club.getImg());
            st.setString(8, club.getDescription());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Clubs getClubbyId(int id) {
        Clubs club = null;
        String query = " select * from club where IdClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club;
    }

    public Clubs getClubbyname(String nameclub) {
        Clubs club = null;
        String query = " select * from club where NameClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameclub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club;
    }

    public boolean updateClub(Clubs club) {
        String query = "UPDATE Club SET NameClub = ?, Point = ?, DateCreate = ?, DateModify = ?, Status = ?, IdTypeClub = ?,Where IdClub=? ";

        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, club.getNameclub());
            st.setInt(2, club.getPoint());
            st.setString(3, club.getDatecreate());
            st.setString(4, club.getModify());
            st.setInt(5, club.getStatus());
            st.setInt(6, club.getType());
            st.setInt(7, club.getClub());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật club: " + e.getMessage());
            return false;
        }
    }

    public void removeClub(int clubId) {
        String query = "DELETE FROM Club WHERE IdClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, clubId);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeRegisteerClub(int IdClubRegister) {
        String query = "DELETE FROM registerclub WHERE IdClubRegister = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, IdClubRegister);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertRegisterClub(String nameclub, String reason, int idstudent, int idtypeclub) {
        String query = "insert into registerclub (NameClub, Reason, IdStudent,IdTypeClub) VALUES (?, ? ,?,? );";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameclub);
            st.setString(2, reason);
            st.setInt(3, idstudent);
            st.setInt(4, idtypeclub);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<RegisterClub> printAllRegisterClub() {
        List<RegisterClub> list = new ArrayList();
        String query = "SELECT * FROM registerclub";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nameclub = rs.getString(2);
                String reason = rs.getString(3);
                int idstudent = rs.getInt(4);
                int status = rs.getInt(5);
                int idtypeclub = rs.getInt(6);
                list.add(new RegisterClub(id, nameclub, reason, idstudent, status, idtypeclub));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void setStatusClub(int id) {
        String query = "update swp39111.registerclub set Status = 1 where IdClubRegister = ?";

        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public RegisterClub getRegisterClubbyId(int id) {
        RegisterClub registerclub = null;
        String query = " select * from registerclub where IdClubRegister = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                registerclub = new RegisterClub(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registerclub;
    }

    public TypeClub gettypeclubbyID(int id) {
        TypeClub typeclub = null;
        String query = "select * from typeclub where IdTypeClub=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                typeclub = new TypeClub(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return typeclub;
    }

    public static void main(String[] args) {
        ClubDao dao = new ClubDao();
//        List<Clubs> list = dao.getNineClubs(3);
//        for (Clubs club : list) {
//            System.out.println(club.getNameclub());
//        }
            System.out.println(dao.getClubbyId(34).getImg());
    }
}
