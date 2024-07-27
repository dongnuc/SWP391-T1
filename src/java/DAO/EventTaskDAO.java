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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10t1q
 */
public class EventTaskDAO extends DBContext {
    //----------------Hoang
    public List<EventTask> getAllEventTasks() {
    List<EventTask> eventTasks = new ArrayList<>();
    String sql = "SELECT * FROM task";

    try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
        while (rs.next()) {
            EventTask eventTask = new EventTask();
            eventTask.setIdEventTask(rs.getInt("IdTask"));
            eventTask.setNameTask(rs.getString("NameTask"));
            eventTask.setDescription(rs.getString("Description"));
            eventTask.setIdEvent(rs.getInt("IdEvent"));
            eventTask.setIdClub(rs.getInt("IdClub"));
            eventTask.setDateCreate(rs.getTimestamp("DateCreate"));
            eventTask.setDateModify(rs.getTimestamp("DateModify"));
            eventTask.setStatus(rs.getInt("Status"));
            eventTask.setContent(rs.getString("Content"));
            eventTask.setDeadline(rs.getTimestamp("Deadline"));
            eventTask.setDepartment(rs.getInt("Department"));
            eventTask.setBudget(rs.getFloat("Budget"));
            eventTasks.add(eventTask);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return eventTasks;
}
    
//-------------Hoang
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
//-------------Hoang
    public boolean deleteEventTaskById(int IdTask) {
    String sql = "DELETE FROM task WHERE IdTask = ?";

    try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
        st.setInt(1, IdTask);
        int rowsAffected = st.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
//-------------Hoang
    public List<EventTask> getEventTaskByIdClub(int IdClub) {
        List<EventTask> eventTaskList = new ArrayList<>();
        String sql = "SELECT * FROM task WHERE IdClub = ? ORDER BY DateCreate DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, IdClub);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    EventTask eventTask = new EventTask();
                    eventTask.setIdEventTask(rs.getInt("IdTask"));
                    eventTask.setNameTask(rs.getString("NameTask"));
                    eventTask.setDescription(rs.getString("Description"));
                    eventTask.setIdEvent(rs.getInt("IdEvent"));
                    eventTask.setIdClub(rs.getInt("IdClub"));
                    eventTask.setDateCreate(rs.getTimestamp("DateCreate"));
                    eventTask.setDateModify(rs.getTimestamp("DateModify"));
                    eventTask.setStatus(rs.getInt("Status"));
                    eventTask.setContent(rs.getString("Content"));
                    eventTask.setDeadline(rs.getTimestamp("Deadline"));
                    eventTask.setDepartment(rs.getInt("Department"));
                    eventTask.setBudget(rs.getFloat("Budget"));
                    eventTaskList.add(eventTask);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventTaskList;
    }
//-------------Hoang
    public EventTask getEventTaskByIdTask(int IdTask) {
    EventTask eventTask = null;
    String sql = "SELECT * FROM task WHERE IdTask = ?";

    try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
        st.setInt(1, IdTask);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                eventTask = new EventTask();
                eventTask.setIdEventTask(rs.getInt("IdTask"));
                eventTask.setNameTask(rs.getString("NameTask"));
                eventTask.setDescription(rs.getString("Description"));
                eventTask.setIdEvent(rs.getInt("IdEvent"));
                eventTask.setIdClub(rs.getInt("IdClub"));
                eventTask.setDateCreate(rs.getTimestamp("DateCreate"));
                eventTask.setDateModify(rs.getTimestamp("DateModify"));
                eventTask.setStatus(rs.getInt("Status"));
                eventTask.setContent(rs.getString("Content"));
                eventTask.setDeadline(rs.getTimestamp("Deadline"));
                eventTask.setDepartment(rs.getInt("Department"));
                eventTask.setBudget(rs.getFloat("Budget"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return eventTask;
}
//-------------Hoang
    public boolean updateEventTask(EventTask eventTask) {
    String sql = "UPDATE task SET NameTask = ?, Description = ?, " +
                 "Content = ?, Deadline = ?, Department = ?, Budget = ?, Status = ? " +
                 "WHERE IdTask = ?";

    try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
        st.setString(1, eventTask.getNameTask());
        st.setString(2, eventTask.getDescription());
        st.setString(3, eventTask.getContent());
        st.setTimestamp(4, eventTask.getDeadline());
        st.setInt(5, eventTask.getDepartment());
        st.setFloat(6, eventTask.getBudget());
        st.setInt(7, eventTask.getStatus());
        st.setInt(8, eventTask.getIdEventTask());

        int rowsUpdated = st.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


}
