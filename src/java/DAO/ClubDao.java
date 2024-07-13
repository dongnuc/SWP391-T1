/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.*;
import java.sql.Connection;
import java.sql.Date;
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
                String x = rs.getString("NameClub");
                list.add(x);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Clubs> getClubAll() {
        List<Clubs> listClub = new ArrayList<>();
        String query = "select * from club";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                 listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }

    public List<Clubs> getNineClubsbyIDtypeclub(int page, int id) {
        List<Clubs> listClub = new ArrayList<>();
        int offset = 9 * (page - 1);
        String query = "select * from club where IdTypeClub=? limit 9 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }

    public int getNumberOfClubbyID(int id) {
        String query = "SELECT COUNT(*) AS numberOfClub FROM club WHERE CategoryClub = ? ";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getInt("numberOfClub");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<String> gettypeclubAll() {
        List<String> listTypeClub = new ArrayList<>();
        String query = "SELECT valueSetting FROM settings where typeSetting = 3" ;
        try {
            
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                String typeclub = rs.getString("valueSetting");
                listTypeClub.add(typeclub);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeClub;
    }
    public boolean isNameClubDuplicate(String nameclub) {
        List<Clubs> listclub = getClubAll();
        for (Clubs club : listclub) {
            if (club.getNameclub().equalsIgnoreCase(nameclub)) {
                return true;
            }
        }
        return false;
    }

    public List<Clubs> getListClubsById(String idAcc) {
        String query = "SELECT * FROM swp391.studentclub where IdStudent = ?";
        List<Clubs> getClubs = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idAcc);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idClub = rs.getString(1);
                Clubs club = getClubsById(idClub);
                getClubs.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getClubs;
    }

    public Clubs getClubsById(String idClub) {
        String query = "SELECT * FROM club where IdClub = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//    public List<Role> getAllRole(String idClub) {
//        String query = "select DISTINCT  sc.IdRole from Student s join studentclub sc on s.IdStudent = sc.IdStudent where sc.IdClub = ?";
//        List<Role> listRole = new ArrayList<>();
//
//        try {
//            PreparedStatement st = connection.prepareStatement(query);
//            st.setString(1, idClub);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                String idRole = rs.getString("sc.IdRole");
//                Role role = getRolebyId(idRole);
//                listRole.add(role);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return listRole;
//    }

  
    

    public String getNameById(int idClub) {
        String query = "SELECT * FROM club WHERE IdClub = ?";
        Clubs club = null;

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, idClub);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (club != null) ? club.getNameclub() : null;
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
        String query = "select * from club where Status=1 limit 9 offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, offset);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                 listClub.add(club);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }

     public void insertClub(Clubs club) {
        
        String query = "INSERT INTO Club (NameClub, Point,CategoryClub, DateCreate, DateModify, Status,Image,title,Description) VALUES (?, ?,?,?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, club.getNameclub());
            st.setInt(2, club.getPoint());
            st.setInt(3, club.getCategoryclub());
            st.setTimestamp(4, new java.sql.Timestamp(club.getDatecreate().getTime()));
            st.setTimestamp(5, new java.sql.Timestamp(club.getModify().getTime()));
            st.setInt(6, club.getStatus());
            st.setString(7, club.getImage());
            st.setString(8, club.getTitle());
            st.setString(9, club.getDescription());
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
                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club;
    }
 public String getClubNameByID(int id) {
        Clubs club = null;
        String query = " select * from club where IdClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club.getNameclub();
    }
    public Clubs getClubbyname(String nameclub) {
        Clubs club = null;
        String query = " select * from club where NameClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameclub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club;
    }

    public boolean updateClub(Clubs club) {
        String query = "UPDATE club SET Point = ?, DateCreate = ?, DateModify = ?, Status = ?, description = ?, Title = ?,CategoryClub = ? WHERE IdClub = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, club.getPoint());
            
            if (club.getDatecreate() != null) {
                st.setTimestamp(2, new java.sql.Timestamp(club.getDatecreate().getTime()));
            } else {
                st.setNull(2, java.sql.Types.TIMESTAMP);
            }
            
            if (club.getModify() != null) {
                st.setTimestamp(3, new java.sql.Timestamp(club.getModify().getTime()));
            } else {
                st.setNull(3, java.sql.Types.TIMESTAMP);
            }
            
            st.setInt(4, club.getStatus());
            st.setString(5, club.getDescription());
            st.setString(6, club.getTitle());
            st.setInt(7, club.getCategoryclub());
            st.setInt(8, club.getClub());
            
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

  public void insertRegisterClub(String nameclub, String reason, int member, int idstudent,int category, String target, String plan) {
        String query = "insert into registerclub (NameClub, Reason,Member, IdStudent,Category,target,plan) VALUES (?, ?,? ,?,?,?,? );";
        try {
            
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameclub);
            st.setString(2, reason);
            st.setInt(3, member);
            st.setInt(4, idstudent);
            st.setInt(5, category);
            st.setString(6, target);
            st.setString(7, plan);
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
                list.add(new RegisterClub(rs.getInt("IdClubRegister"), rs.getString("NameClub"), rs.getString("Reason"), rs.getInt("Member"), rs.getInt("IdStudent"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getString("target"), rs.getString("plan"), rs.getString("refuse"), rs.getInt("Category")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

   

    public RegisterClub getRegisterClubbyId(int id) {
        RegisterClub registerclub = null;
        String query = " select * from registerclub where IdClubRegister = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                registerclub = new RegisterClub(rs.getInt("IdClubRegister"), rs.getString("NameClub"), rs.getString("Reason"), rs.getInt("Member"), rs.getInt("IdStudent"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getString("target"), rs.getString("plan"), rs.getString("refuse"), rs.getInt("Category"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registerclub;
    }

    public String getTypeClubById(int idClub) {
        String query = "SELECT valueSetting FROM settings WHERE typeSetting = 3 AND idSetting = ?";
        String typeClub = null;
        Clubs club = getClubbyId(idClub);

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, club.getCategoryclub());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    typeClub = rs.getString("valueSetting");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return typeClub;
    }

    public boolean updateClubImage(int clubId, String imagePath) {
        String query = "UPDATE Club SET Image = ? WHERE IdClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, imagePath);
            st.setInt(2, clubId);

            int rowsUpdated = st.executeUpdate();
            st.close();

            return rowsUpdated > 0; // Trả về true nếu cập nhật thành công, ngược lại là false
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật ảnh club: " + e.getMessage());
            return false;
        }
    }

    public int numberPageClub(String nameType, String nameSearch) {
        List<Clubs> listClubs = new ArrayList<>();
        String query = "SELECT count(*) \n"
                + " FROM swp392.club c join Setting st ON c.IdClub = st.IdClub where st.IdClub is not null and st.IdType = 3";
        if (!nameType.isEmpty()) {
            query += " and st.Name = '" + nameType + "'";
        }
        if (!nameSearch.isEmpty()) {
            query += " and c.NameClub like '%" + nameSearch + "%';";
        }
        int numberPage = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberPage = rs.getInt(1);
            }
            if (numberPage % 5 == 0) {
                numberPage /= 5;
            } else {
                numberPage = (numberPage / 5) + 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return numberPage;
    }

    public List<String> getTypeClub() {
        List<String> listTypeClub = new ArrayList<>();
        String query = "select * from setting where IdType = 3 and IdClub is null;";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nameType = rs.getString("Name");
                listTypeClub.add(nameType);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeClub;
    }

    public List<Clubs> getClubByPage(int pageCurrent, String nameType, String nameSearch) {
        List<Clubs> listClubs = new ArrayList<>();
        String query = "select c.IdClub, c.NameClub, c.Description, c.Image, c.Point,\n"
                + " st.Name,c.DateCreate,c.DateModify,c.Status\n"
                + " from club c JOIN setting st ON c.IdClub = st.IdClub\n"
                + " where st.IdType = 3 ";
        if (!nameType.isEmpty()) {
            query += "and st.Name = '" + nameType + "'";
        }
        if (!nameSearch.isEmpty()) {
            query += " and c.NameClub like '%" + nameSearch + "%'";
        }

        query += " ORDER BY c.IdClub LIMIT 5 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, pageCurrent * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Clubs getClub = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getInt("Point"), rs.getString("Name"), rs.getDate("DateCreate"),
                        rs.getDate("DateModify"), rs.getInt("Status"));
                listClubs.add(getClub);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClubs;
    }

    public List<Clubs> getClubPublic(int pageCurrent, String nameType, String nameSearch) {
        List<Clubs> listClubs = new ArrayList<>();
        String query = "select c.IdClub, c.NameClub, c.Description, c.Image, c.Point,\n"
                + " st.Name,c.DateCreate,c.DateModify,c.Status\n"
                + " from club c JOIN setting st ON c.IdClub = st.IdClub\n"
                + " where st.IdClub is not null and st.IdType = 3 and c.status = 1";
        if (!nameType.isEmpty()) {
            query += "and st.Name = '" + nameType + "'";
        }
        if (!nameSearch.isEmpty()) {
            query += " and c.NameClub like '%" + nameSearch + "%';";
        }

        query += "ORDER BY c.IdClub LIMIT 5 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, pageCurrent * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Clubs getClub = new Clubs(rs.getInt("IdClub"), rs.getString("Name"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getInt("Point"), rs.getString("Name"), rs.getDate("DateCreate"),
                        rs.getDate("DateModify"), rs.getInt("Status"));
                listClubs.add(getClub);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClubs;
    }
    
     public Clubs getClubByIdSetting(String idClub) {
        String query = "select c.IdClub, c.NameClub, c.Description, c.Image, c.Point,\n"
                + " st.Name,c.DateCreate,c.DateModify,c.Status\n"
                + " from club c JOIN setting st ON c.IdClub = st.IdClub\n"
                + " where st.IdClub is not null and st.IdType = 3 and c.status = 1 and st.IdClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, idClub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getInt("Point"), rs.getString("Name"), rs.getDate("DateCreate"),
                        rs.getDate("DateModify"), rs.getInt("Status"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     public boolean checkNameClub(String nameClub){
         String query = "select c.NameClub " 
                + " from club c JOIN setting st ON c.IdClub = st.IdClub\n"
                + " where st.IdClub is not null and st.IdType = 3 and c.status = 1 and c.NameClub = ?";
         try {
             PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameClub);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
         } catch (Exception e) {
             System.out.println(e);
         }
         return false;
     }
      public List<Clubs> searchClubs(String searchQuery, int page) {
        List<Clubs> listClub = new ArrayList<>();
        int offset = 9 * (page - 1);
        String query = "SELECT * FROM club WHERE NameClub LIKE ? LIMIT 9 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, "%" + searchQuery + "%");
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }
//     update setting 
      public void updateClub(String idClub, String nameClub, String point, String typeClub, String status) {
        String query = "UPDATE `swp392`.`club`\n"
                + "SET\n ";
        int count = 0;
        if (!nameClub.isEmpty()) {
            query += " `NameClub` = '" + nameClub + "'";
            count++;
        }
        if (!point.isEmpty()) {
            if (count > 0) {
                query += ", ";
            }
            query += " `Point` = " + point;
            count++;
        }
        if (!status.isEmpty()) {
            if (count > 0) {
                query += ", ";
            }
            query += " `Status` = " + status;
        }
        query += " where `IdClub` = " + idClub + ";";
        System.out.println(query);
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

public String getRolebyId(int id) {
        String query = "SELECT valueSetting  FROM settings where typeSetting=1  and idSetting=? ";
        String role=null;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("valueSetting");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }
public int getSettingbyValue (String value) {
        String query = "select idSetting from settings where valueSetting = ?";
        int role=0;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, value);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getInt("idSetting");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }
public String getValuebySetting (int id) {
        String query = "select valueSetting from settings where idSetting  = ?";
        String role=null;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("valueSetting");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }
public int searchClubSize(String searchQuery) {
        List<Clubs> listClub = new ArrayList<>();
        String query = "SELECT * FROM club WHERE NameClub LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, "%" + searchQuery + "%");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub.size();
    }
public List<Clubs> getNineClubsByType(int page, int category) {
        List<Clubs> listClub = new ArrayList<>();
        int offset = 9 * (page - 1);
        
        String clubQuery = "SELECT * FROM club WHERE  Status=1 and CategoryClub = ? LIMIT 9 OFFSET ?";
        
        try (PreparedStatement st = connection.prepareStatement(clubQuery)) {
            st.setInt(1, category);
            st.setInt(2, offset);
            
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listClub;
    }
public int getIdStudentByRole(int idclub) {
        int idStudent = 0;

        String query = "select IdStudent from studentclub where Role = 1 and IdClub =?  ";

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, idclub);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    idStudent = rs.getInt("IdStudent");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return idStudent;
    }
public List<Clubs> getOtherClub(int category,int id) {
        List<Clubs> listClub = new ArrayList<>();
        
        String clubQuery = "select * from club where Status =1 and CategoryClub = ? and IdClub!=? limit 3 ";
        
        try (PreparedStatement st = connection.prepareStatement(clubQuery)) {
            st.setInt(1, category);
            st.setInt(2, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listClub;
    }
public List<Clubs> getRandomClub() {
    List<Clubs> listClub = new ArrayList<>();
    
    String clubQuery = "SELECT * FROM club WHERE Status = 1 ORDER BY RAND() LIMIT 3";
    
    try (PreparedStatement st = connection.prepareStatement(clubQuery)) {
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Clubs club = new Clubs(
                    rs.getInt("IdClub"), 
                    rs.getString("NameClub"), 
                    rs.getInt("Point"),
                    rs.getInt("CategoryClub"),
                    rs.getDate("DateCreate"),
                    rs.getDate("DateModify"),
                    rs.getInt("Status"),
                    rs.getString("Image"),
                    rs.getString("Title"),
                    rs.getString("Description")
                );
                listClub.add(club);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return listClub;
}
    public static void main(String[] args) {
        ClubDao dao = new ClubDao();
//        List<Clubs> list = dao.getRandomClub();
//        for (Clubs club : list) {
//            System.out.println(club.getNameclub());
//        }
//        System.out.println(dao.getClubbyId(34).getType());
//        dao.updateClubImage(34, "images/" + "11.png");
//        List<Clubs> getClub = dao.getClubByPage(1, "", "");
        System.out.println(dao.getNameById(10));
        

    }
}
