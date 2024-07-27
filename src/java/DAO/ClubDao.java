/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 84358
 */
public class ClubDao extends DBContext {

    public List<Accounts> getAccountsNewInClubDong(String idClub) {
        List<Accounts> listAcc = new ArrayList<>();
        String query = " select s.IdStudent, s.NameStudent, sc.Role from studentclub sc join student s ON sc.IdStudent = s.IdStudent where idClub = ? \n"
                + " order by sc.DateCreate desc limit 5 offset 0";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idRole = rs.getString("Role");
                String nameRole = getRoleClubDong(idRole);
                Accounts acc = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                        0, nameRole, 1);
                listAcc.add(acc);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listAcc;
    }

    public HashMap<String, String> getListClubManagerByIdAccDong(String idAcc) {
        HashMap<String, String> listClubManager = new HashMap<>();
        String query = "select c.IdClub, c.NameClub  from studentclub sc left join club c On sc.IdClub = c.IdClub\n"
                + " where sc.Role = 1 and sc.Status = 1 and sc.IdStudent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idAcc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listClubManager.put(rs.getString(1), rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClubManager;
    }

    public boolean checkManagerClub(String idAcc, String idClub) {
        String query = " select * from StudentClub where Role = 1 and IdStudent = ? and IdClub = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idAcc);
            ps.setString(2, idClub);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Accounts> getAccountsNewInClub(String idClub) {
        List<Accounts> listAcc = new ArrayList<>();
        String query = " select s.IdStudent, s.NameStudent, sc.Role from studentclub sc join student s ON sc.IdStudent = s.IdStudent where idClub = ? \n"
                + " order by sc.DateCreate desc limit 5 offset 0";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idRole = rs.getString("Role");
                String nameRole = getRoleClubDong(idRole);
                Accounts acc = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                        0, nameRole, 1);
                listAcc.add(acc);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listAcc;
    }

    public HashMap<String, String> numberRoleInClubDong(String idClub) {
        HashMap<String, String> listRoleNumber = new HashMap<>();
        String query = " select s.valueSetting, count(sc.IdStudent) as number \n"
                + " from studentclub sc join settings s On sc.Role = s.idSetting \n"
                + " where sc.IdClub = ? group by s.valueSetting";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listRoleNumber.put(rs.getString(1), rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listRoleNumber;
    }

    public int countStudentInClubDong(String idClub) {
        String query = " select count(*) from studentclub where status = 1 and IdClub = " + idClub;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int countBlogInClubDong(String idClub) {
        String query = "select count(*) from blog where status = 1 and IdClub = " + idClub;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int countEventInClubDong(String idClub) {
        String query = "select count(*) from event where status = 1 and IdClub = " + idClub;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int getClubManagerByIdAccDong(String idAcc) {
        String query = " select IdClub from studentclub sc where Role = 1 and IdStudent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idAcc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int isLeaderInClubDong(String idClub, String idStudent) {
        String query = " select leader from studentclub where IdStudent = ? and IdClub = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(2, idClub);
            ps.setString(1, idStudent);
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

    public Accounts getMemberInClubDong(String idClub, String idStudent) {
        String query = "select s.IdStudent, s.NameStudent, sc.Point, sc.Role, sc.DateCreate, sc.DateModify,sc.Status from student s join studentclub sc ON s.IdStudent = sc.IdStudent\n"
                + " where sc.IdStudent = " + idClub + " and sc.IdClub = " + idStudent;
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String idRole = rs.getString("Role");
                String nameRole = getRoleClubDong(idRole);
                return new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                        rs.getInt("Point"), nameRole, rs.getInt("Status"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public HashMap<String, String> getAllRoleDong(String status) {
        HashMap<String, String> listRole = new HashMap<>();
        String query = "select idSetting, valueSetting from settings where status = ? and typeSetting = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listRole.put(rs.getString("idSetting"), rs.getString("valueSetting"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listRole;
    }

    public String getRoleClubDong(String idSetting) {
        String query = "select valueSetting from settings where idSetting = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idSetting);
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

    public int pagetMemberInClubDong(String idClub, String search, String role, String status) {
        String query = " select count(*) from studentclub sc join student s on sc.IdStudent = s.IdStudent\n"
                + " where sc.IdClub = ? and sc.Status = ?";
        if (!role.equals("All")) {
            query += " and sc.Role = " + role + " ";
        }
        if (!search.isBlank()) {
            query += " and c.NameStudent like '%" + search + "%' ";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ps.setString(2, status);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numberPage = rs.getInt(1);
                if (numberPage % 5 == 0) {
                    return numberPage / 5;
                } else {
                    numberPage = numberPage / 5 + 1;
                    return numberPage;
                }

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return 1;
    }

    public List<Accounts> getMemberInClubDong(String idClub, String search, String role, String status, int page) {
        List<Accounts> listMember = new ArrayList<>();
        String query = "select s.IdStudent,s.NameStudent,sc.Point, sc.Role,sc.Status from studentclub sc join student s on sc.IdStudent = s.IdStudent\n"
                + " where sc.IdClub = ? and sc.Status = ?";
        if (!role.equals("All")) {
            query += " and sc.Role = " + role + " ";
        }
        if (!search.isBlank()) {
            query += " and s.NameStudent like '%" + search + "%' ";
        }
        query += " order by s.IdStudent limit 5 offset ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ps.setString(2, status);
            ps.setInt(3, page * 5 - 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idRole = rs.getString("Role");
                String nameRole = getRoleClubDong(idRole);
                Accounts getAcc = new Accounts(rs.getInt("IdStudent"), rs.getString("NameStudent"),
                        rs.getInt("Point"), nameRole, rs.getInt("Status"));
                listMember.add(getAcc);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMember;
    }

    public HashMap<String, String> countStudentInClubDong() {
        HashMap<String, String> listStudent = new HashMap<>();
        String query = "  SELECT c.NameClub, COUNT(sc.IdStudent) AS NumberOfStudents\n"
                + "FROM Club c LEFT JOIN StudentClub sc ON c.IdClub = sc.IdClub\n"
                + "where sc.Status = 1 GROUP BY c.NameClub HAVING COUNT(sc.IdStudent) > 0;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listStudent.put(rs.getString(1), rs.getString(2));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listStudent;
    }

    public int countNumberClubDong() {
        String query = "select count(*) from club where status = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int countStudentNoClubDong() {
        String query = "select count(distinct IdStudent) from studentclub where status = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public int countNumberClubResDong() {
        String query = "select count(*) from registerclub where status = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public HashMap<String, String> getAllCategoryClubDong(String status) {
        HashMap<String, String> listCategory = new HashMap<>();
        String query = "select * from settings where typeSetting = 3 and status = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String key = rs.getString("idSetting");
                String value = rs.getString("valueSetting");
                listCategory.put(key, value);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCategory;
    }

    public boolean checkNameDuplicateDong(String name, String idClub) {
        String query = "select * from club where NameClub = '" + name + "' ";
        if (idClub != null && !idClub.isBlank()) {
            query += " and IdClub !=" + idClub + " ";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int numberPageClubDong(String category, String search, String status) {
        String query = "select count(*) from club where 1 = 1 and Status = ? ";
        if (!category.equals("All")) {
            query += " and CategoryClub = " + category + " ";
        }
        if (!search.isBlank()) {
            query += " and NameClub like '%" + search + "%' ";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numberPage = rs.getInt(1);
                if (numberPage % 5 == 0) {
                    numberPage /= 5;
                } else {
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

    public List<Clubs> getAllClubDong(String search, String category, String status, int page) {
        List<Clubs> listClubs = new ArrayList<>();
        String query = "select * from club c join settings s on c.CategoryClub = s.idSetting and c.status = ? ";
        if (!category.equals("All")) {
            query += " and c.CategoryClub = " + category + " ";
        }
        if (!search.isBlank()) {
            query += " and c.NameClub like '%" + search + "%' ";
        }
        query += "order by c.IdClub limit 5 offset ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, page * 5 - 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clubs getClub = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getInt("Point"), rs.getString("valueSetting"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getInt("Status"));
                listClubs.add(getClub);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClubs;
    }

    public Clubs getClubByIdDong(String idClub) {
        String query = "select * from club c join settings s on c.CategoryClub = s.idSetting where idClub = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getInt("Point"), rs.getString("valueSetting"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"),
                        rs.getInt("Status"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//    update
    public void updateClubDong(String idClub, String nameClub, String point, String typeClub, String status) {
        String query = "UPDATE `club` SET \n";
        int count = 0;
        if (!nameClub.isEmpty()) {
            query += " `NameClub` = '" + nameClub + "'";
            count++;
        }
        if (!point.isEmpty()) {
            if (count > 0) {
                query += ", ";
            }
            query += " `Point` = '" + point + "' ";
            count++;
        }
        if (!status.isEmpty()) {
            if (count > 0) {
                query += ", ";
            }
            query += " `Status` = '" + status + "' ";
        }
        query += " where `IdClub` = " + idClub + ";";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();

            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //insert
    public void insertClubDong(String name, String points, String dateCreate, String idManager,
            String category, String status) {
        String query = "INSERT INTO `club`\n"
                + "(`NameClub`,`Point`,`CategoryClub`,`DateCreate`,`Status`)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, points);
            ps.setString(3, category);
            ps.setString(4, dateCreate);
            ps.setString(5, status);
            ps.executeUpdate();

            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//------------------ Hoang

    public String getClubNameByID(int IdClub) {
        String NameClub = null;
        String sql = "SELECT NameClub FROM club WHERE IdClub = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, IdClub);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                NameClub = rs.getString("NameClub");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NameClub;
    }

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
            rs.close();
            st.close();
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
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
            rs.close();
            st.close();
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
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
            rs.close();
            st.close();
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
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<String> gettypeclubAll() {
        List<String> listTypeClub = new ArrayList<>();
        String query = "SELECT valueSetting FROM settings where typeSetting = 3";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String typeclub = rs.getString("valueSetting");
                listTypeClub.add(typeclub);
            }
            rs.close();
            st.close();
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
        String query = "SELECT * FROM studentclub where IdStudent = ?";
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
            rs.close();
            st.close();
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
                return new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
            }
            rs.close();
            st.close();
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
        String nameClub = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idClub);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nameClub = rs.getString("NameClub");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameClub;
    }

    public int getNumberOfClub() {
        String query = "select count(*) AS numberOfClub from club ";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfClub");
            }
            rs.close();
            st.close();
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
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
            rs.close();
            st.close();

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
                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return club;
    }
// public String getClubNameByID(int id) {
//        Clubs club = null;
//        String query = " select * from club where IdClub = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(query);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"),rs.getInt("CategoryClub"),rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
//                }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return club.getNameclub();
//    }

    public Clubs getClubbyname(String nameclub) {
        Clubs club = null;
        String query = " select * from club where NameClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameclub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
            }
            rs.close();
            st.close();
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

            st.close();
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

    public void insertRegisterClub(String nameclub, String reason, int member, int idstudent, int category, String target, String plan) {
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

            st.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<RegisterClub> getNineRegisterCLub(int page) {
        List<RegisterClub> list = new ArrayList<>();
        int offset = 9 * (page - 1);
        String query = "SELECT * FROM registerclub LIMIT 9 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, offset);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                list.add(new RegisterClub(rs.getInt("IdClubRegister"), rs.getString("NameClub"), rs.getString("Reason"), rs.getInt("Member"), rs.getInt("IdStudent"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getString("target"), rs.getString("plan"), rs.getString("refuse"), rs.getInt("Category")));

            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getNumberOfRegisterClub() {
        String query = "select count(*) AS numberOfRegisterClub from registerclub ";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfRegisterClub");
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
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
            rs.close();
            st.close();
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
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return registerclub;
    }

    public String getTypeClubById(int idClub) {
    String query = "SELECT valueSetting FROM settings WHERE typeSetting = 3 AND idSetting = ?";
    String typeClub = null;
    
    Clubs club = getClubbyId(idClub); // Fetch the club details
    
    if (club != null) {
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, club.getCategoryclub());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                typeClub = rs.getString("valueSetting");
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                + " FROM club c join Setting st ON c.IdClub = st.IdClub where st.IdClub is not null and st.IdType = 3";
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
            rs.close();
            ps.close();

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
            rs.close();
            st.close();
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
            rs.close();
            st.close();
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
            rs.close();
            st.close();
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
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkNameClub(String nameClub) {
        String query = "select c.NameClub "
                + " from club c JOIN setting st ON c.IdClub = st.IdClub\n"
                + " where st.IdClub is not null and st.IdType = 3 and c.status = 1 and c.NameClub = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nameClub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            st.close();
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
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listClub;
    }
//     update setting 

    public void updateClub(String idClub, String nameClub, String point, String typeClub, String status) {
        String query = "UPDATE `club`\n"
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

            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getRolebyId(int id) {
        String query = "SELECT valueSetting  FROM settings where typeSetting=1  and idSetting=? ";
        String role = null;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("valueSetting");
                }
                rs.close();
                st.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }

    public int getSettingbyValue(String value) {
        String query = "select idSetting from settings where valueSetting = ?";
        int role = 0;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, value);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getInt("idSetting");
                }
                rs.close();
                st.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }

    public String getValuebySetting(int id) {
        String query = "select valueSetting from settings where idSetting  = ?";
        String role = null;
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("valueSetting");
                }
                rs.close();
                st.close();
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
                Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                listClub.add(club);
            }
            rs.close();
            st.close();
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
                    Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                    listClub.add(club);
                }
                rs.close();
                st.close();
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
                rs.close();
                st.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return idStudent;
    }

    public List<Clubs> getOtherClub(int category, int id) {
        List<Clubs> listClub = new ArrayList<>();

        String clubQuery = "select * from club where Status =1 and CategoryClub = ? and IdClub!=? limit 3 ";

        try (PreparedStatement st = connection.prepareStatement(clubQuery)) {
            st.setInt(1, category);
            st.setInt(2, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Clubs club = new Clubs(rs.getInt("IdClub"), rs.getString("NameClub"), rs.getInt("Point"), rs.getInt("CategoryClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"), rs.getString("Image"), rs.getString("Title"), rs.getString("Description"));
                    listClub.add(club);
                }
                rs.close();
                st.close();
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
                rs.close();
                st.close();
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
//        System.out.println(dao.getNameById(10));
//        List<Accounts> listAcc = dao.getMemberInClubDong("1", "", "All", "1", 1);
//        System.out.println(listAcc.size());
//        System.out.println(dao.pagetMemberInClubDong("1", "", "All", "1"));
        Accounts acc = dao.getMemberInClubDong("9", "2");
        System.out.println(acc);
    }
}
