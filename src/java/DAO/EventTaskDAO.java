/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import Model.*;

/**
 *
 * @author 10t1q
 */
public class EventTaskDAO extends DBContext {
    
    public void insertEventTask(EventTask evenTask) {
        String sql = "INSERT INTO task (NameTask, Description, Content, IdEvent, IdClub, Deadline, Department, Budget, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, evenTask.getNameTask());//
            stmt.setString(2, evenTask.getDescription());//
            stmt.setString(3, evenTask.getContent());//
            stmt.setInt(4, evenTask.getIdEvent());//
            stmt.setInt(5, evenTask.getIdClub());//
            Timestamp sqlDeadline = new Timestamp(evenTask.getDeadline().getTime());
            stmt.setTimestamp(6, sqlDeadline);//
            stmt.setInt(7, evenTask.getDepartment());//
            stmt.setFloat(8, evenTask.getBudget());//
            stmt.setInt(9, evenTask.getStatus());//
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
