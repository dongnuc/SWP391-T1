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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
public class StudentClubDao extends DBContext {

    public void updateMemberClubDong(String idStudent, String idClub, String points, String role, String leader, String status) {
        String query = "UPDATE `studentclub` SET status = ?";
        int count = 1;
        if (!points.isBlank()) {
            query += " , `Point` = '" + points + "' ";
        }
        if (!role.isBlank()) {
            query += " , `Role` = '" + role + "' ";
        }
        if (!leader.isBlank()) {
            query += " ,  `leader` = '" + leader + "' ";
        }
        query += " WHERE `IdStudent` = ? AND `IdClub` = ?; ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, idStudent);
            ps.setString(3, idClub);
            ps.executeUpdate();

            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<String> getclubbtid(int id) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent=" + id;
        List<String> listclub = new ArrayList<>();
        String x = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                x = rs.getString("NameClub");
                listclub.add(x);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        return listclub;
    }

    public int getSizeClub(int id) {
        String query = "SELECT  count(*) AS numberOfMember FROM StudentClub where IdClub=?";
        List<Integer> list = new ArrayList();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("numberOfMember"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list.get(0);
    }

    public int getIdStudentByRole(int idclub) {
        int idStudent = 0;

        String query = "SELECT IdStudent FROM StudentClub WHERE IdRole = ? and IdClub=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, 1);
            st.setInt(2, idclub);
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

    public List<StudentClub> getStudentClubbyId(int id) {
        List<StudentClub> list = new ArrayList<>();
        String query = "SELECT * FROM StudentClub where IdClub=?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {

                    StudentClub studentclub = new StudentClub(rs.getInt("Point"), rs.getInt("Status"), rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getDate("DateCreate"), rs.getDate("DateModify"));
                    list.add(studentclub);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public String getroleofclub(int id, String NameClub) {
        String sql = "select *from Student_Club join Club on Student_Club.IdClub=Club.IDClub where"
                + " Student_Club.IdStudent=" + id
                + " and NameClub ='" + NameClub + "'";
        String role = "";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        return role;
    }
//---- Hoang

    public List<StudentClub> getStudentClubs(int idStudent) {
        List<StudentClub> studentClubList = new ArrayList<>();
        String sql = "SELECT * FROM StudentClub WHERE IdStudent = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idStudent);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    StudentClub studentClub = new StudentClub();
                    studentClub.setPoint(rs.getInt("Point"));
                    studentClub.setDatecreate(rs.getDate("DateCreate"));
                    studentClub.setDatemodify(rs.getDate("DateModify"));
                    studentClub.setStatus(rs.getInt("Status"));
                    studentClub.setIdStudent(rs.getInt("IdStudent"));
                    studentClub.setIdClub(rs.getInt("IdClub"));
                    studentClub.setRole(rs.getInt("Role"));
                    studentClub.setLeader(rs.getInt("leader"));
                    studentClubList.add(studentClub);
                }
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentClubList;
    }

    public void insertStudentClub(StudentClub student) {
        String query = "Insert into studentclub (IdStudent,IdClub,Point,Role,leader,DateCreate,DateModify,Status) value(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, student.getIdStudent());
            st.setInt(2, student.getIdClub());
            st.setInt(3, student.getPoint());
            st.setInt(4, student.getRole());
            st.setInt(5, student.getLeader());
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            st.setTimestamp(6, currentTimestamp);
            st.setTimestamp(7, currentTimestamp);
            st.setInt(8, student.getStatus());
            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<StudentClub> getTenStudentClub(int idclub, int page) {
        List<StudentClub> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from studentclub where  IdClub = ? limit 10 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub studentclub = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                list.add(studentclub);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void setStatus(int idclub, int idstudent) {
        String query = "UPDATE studentclub SET Status = CASE WHEN Status = 0 THEN 1 WHEN Status = 1 THEN 0 ELSE Status END WHERE IdClub = ? AND IdStudent = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, idstudent);
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status toggled successfully.");
            } else {
                System.out.println("No records found with the given IdClub and IdStudent.");
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getNumberOfStudentClub(int id) {
        String query = "select count(*) AS numberOfstudentclub from studentclub where Idclub = ?";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfstudentclub");
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void updateStudentClub(StudentClub studentclub) {
        String query = "UPDATE studentclub SET Point = ?, Role= ?, leader= ?,DateCreate=?, DateModify = ? WHERE IdStudent = ? AND IdClub = ?";

        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, studentclub.getPoint());
            st.setInt(2, studentclub.getRole());
            st.setInt(3, studentclub.getLeader());
            st.setDate(4, new java.sql.Date(studentclub.getDatecreate().getTime()));
            st.setDate(5, new java.sql.Date(studentclub.getDatemodify().getTime()));
            st.setInt(6, studentclub.getIdStudent());
            st.setInt(7, studentclub.getIdClub());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public StudentClub getStudentinClub(int idstudent, int idclub) {
        StudentClub student = null;
        String query = "select * from studentclub where IdClub =? and IdStudent =?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, idstudent);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                student = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdCLub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public List<StudentClub> searchStudentClubsByName(int idclub, String studentName, int page) {
        List<StudentClub> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "SELECT sc.IdStudent, sc.IdClub, sc.Point, sc.Role, sc.leader, sc.DateCreate, sc.DateModify, sc.Status, s.NameStudent "
                + "FROM studentclub sc "
                + "INNER JOIN student s ON sc.IdStudent = s.IdStudent "
                + "WHERE sc.IdClub = ? AND s.NameStudent LIKE ? "
                + "LIMIT 10 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setString(2, "%" + studentName + "%");
            st.setInt(3, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub student = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdCLub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));

                list.add(student);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countSearchStudentName(int idclub, String studentName, int page) {
        List<StudentClub> list = new ArrayList<>();
        String query = "SELECT sc.IdStudent, sc.IdClub, sc.Point, sc.Role, sc.leader, sc.DateCreate, sc.DateModify, sc.Status, s.NameStudent "
                + "FROM studentclub sc "
                + "INNER JOIN student s ON sc.IdStudent = s.IdStudent "
                + "WHERE sc.IdClub = ? AND s.NameStudent LIKE ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setString(2, "%" + studentName + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub student = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdCLub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));

                list.add(student);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.size();
    }

    public List<StudentClub> getTenStudentClubbyRole(int idclub, int Role, int page) {
        List<StudentClub> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from studentclub where  IdClub = ? and Role=? limit 10 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, Role);
            st.setInt(3, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub studentclub = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                list.add(studentclub);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getCountStudentClubbyRole(int idclub, int Role) {
        List<StudentClub> list = new ArrayList<>();
        String query = "select * from studentclub where  IdClub = ? and Role=?  ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, Role);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub studentclub = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                list.add(studentclub);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list.size();
    }

    public List<StudentClub> getTenStudentClubbyleader(int idclub, int leader, int page) {
        List<StudentClub> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from studentclub where  IdClub = ? and leader=? limit 10 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, leader);
            st.setInt(3, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub studentclub = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                list.add(studentclub);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getCountStudentClubbyLeader(int idclub, int leader) {
        List<StudentClub> list = new ArrayList<>();
        String query = "select * from studentclub where  IdClub = ? and leader=?  ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, leader);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StudentClub studentclub = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdClub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                list.add(studentclub);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list.size();
    }

    public void insertClubStudentRegistration(ClubStudentRegistration student) {
        String query = "Insert into clubstudentregistration (Idstudent,idclub,Role,fullname,talent,experience,target) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, student.getIdstudent());
            st.setInt(2, student.getIdclub());
            st.setInt(3, student.getRole());
            st.setString(4, student.getFullname());
            st.setString(5, student.getTalent());
            st.setString(6, student.getExperience());
            st.setString(7, student.getTalent());
            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public StudentClub getManagerinClub(int idclub) {
        StudentClub student = null;
        String query = "select * from studentclub where IdClub =? and Role=1";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                student = new StudentClub(rs.getInt("IdStudent"), rs.getInt("IdCLub"), rs.getInt("Point"), rs.getInt("Role"), rs.getInt("leader"), rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public List<ClubStudentRegistration> getTenStudentClubRegistration(int idclub, int page) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from clubstudentregistration where  IdClub = ? limit 10 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getNumberOfClubStudentRegistration(int id) {
        String query = "select count(*) AS numberOfclubstudentregistration from clubstudentregistration where Idclub = ?";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfclubstudentregistration");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<ClubStudentRegistration> searchClubStudentRegistrationByName(int idclub, String name, int page) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from clubstudentregistration where IdClub = ? and fullname Like ? LIMIT 10 offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setString(2, "%" + name + "%");
            st.setInt(3, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int countSearchClubStudentRegistrationByName(int idclub, String name) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        String query = "select * from clubstudentregistration where IdClub = ? and fullname Like ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setString(2, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list.size();
    }

    public List<ClubStudentRegistration> getTenClubStudentRegistrationbyRole(int idclub, int Role, int page) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "select * from clubstudentregistration where  IdClub = ? and Role=? limit 10 offset ? ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, Role);
            st.setInt(3, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getNumberOfClubStudentRegistrationbyRole(int id, int role) {
        String query = "select count(*) AS numberOfclubstudentregistration from clubstudentregistration where Idclub = ? and Role =?";
        try {

            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.setInt(2, role);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfclubstudentregistration");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<ClubStudentRegistration> getTenClubStudentRegistrationbyASC(int id, int page) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "SELECT * FROM clubstudentregistration WHERE IdClub= ? ORDER BY datecreate ASC LIMIT 10 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ClubStudentRegistration> getTenClubStudentRegistrationbyDESC(int id, int page) {
        List<ClubStudentRegistration> list = new ArrayList<>();
        int offset = 10 * (page - 1);
        String query = "SELECT * FROM clubstudentregistration WHERE IdClub= ? ORDER BY datecreate DESC LIMIT 10 OFFSET ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.setInt(2, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClubStudentRegistration student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
                list.add(student);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ClubStudentRegistration getClubStudentRegistration(int idstudent, int idclub) {
        ClubStudentRegistration student = null;
        String query = "select * from clubstudentregistration where IdClub =? and IdStudent =?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, idstudent);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                student = new ClubStudentRegistration(rs.getInt("Idclubstudentregistration"), rs.getInt("Idstudent"), rs.getInt("IdClub"), rs.getInt("Role"), rs.getDate("DateCreate"), rs.getString("fullname"), rs.getString("talent"), rs.getString("experience"), rs.getString("target"), rs.getString("reason"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public void removeClubStudentRegistration(int idstudent, int idclub) {
        String query = "DELETE FROM clubstudentregistration WHERE IdClub = ? AND IdStudent = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, idclub);
            st.setInt(2, idstudent);
            st.executeUpdate();

            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean isStudentInClub(int idstudent, int idclub) {
        // Sử dụng hàm getStudentinClub để lấy thông tin sinh viên trong câu lạc bộ
        StudentClub student = getStudentinClub(idstudent, idclub);

        // Kiểm tra nếu sinh viên tồn tại trong câu lạc bộ
        return student != null;
    }

    public List<StudentClub> getTop5StudentsByPoint(int idClub) {
        List<StudentClub> list = new ArrayList<>();
        String query = "SELECT * FROM StudentClub WHERE IdClub = ? ORDER BY Point DESC LIMIT 5";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, idClub);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    StudentClub studentclub = new StudentClub(
                            rs.getInt("Point"),
                            rs.getInt("Status"),
                            rs.getInt("IdStudent"),
                            rs.getInt("IdClub"),
                            rs.getDate("DateCreate"),
                            rs.getDate("DateModify")
                    );
                    list.add(studentclub);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching top 10 students by point for club " + idClub + ": " + e.getMessage());
        }
        return list;
    }

//-----------------------
    public static void main(String[] args) {
        StudentClubDao dao = new StudentClubDao();
        System.out.println(dao.getStudentClubbyId(1).get(1));

    }

}
