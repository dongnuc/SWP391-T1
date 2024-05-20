/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentDao extends DBContext {

    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();
        String query = "select * from Student";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String gender = "";
                if(rs.getInt(6) == 1){
                    gender = "Male"; 
                }else{
                    gender = "Female";
                }
                
                Student st = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), gender, rs.getDate(7), rs.getDate(8), rs.getDate(9), rs.getByte(10));
                listStudent.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listStudent;
    }
    
    
    
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
          List<Student> listStudent = dao.getAllStudent();
          System.out.println(listStudent.get(0).getEmailSt());
    }

}
