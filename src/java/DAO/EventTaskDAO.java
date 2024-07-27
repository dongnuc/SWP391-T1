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

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            try (ResultSet rs = ps.executeQuery()) {
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
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventTasks;
    }

//-------------Hoang
    public void insertEventTask(EventTask eventTask) {
        String sql = "INSERT INTO task (NameTask, Description, Content, IdEvent, IdClub, Deadline, Department, Budget, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, eventTask.getNameTask());
            ps.setString(2, eventTask.getDescription());
            ps.setString(3, eventTask.getContent());
            ps.setInt(4, eventTask.getIdEvent());
            ps.setInt(5, eventTask.getIdClub());
            Timestamp sqlDeadline = new Timestamp(eventTask.getDeadline().getTime());
            ps.setTimestamp(6, sqlDeadline);
            ps.setInt(7, eventTask.getDepartment());
            ps.setFloat(8, eventTask.getBudget());
            ps.setInt(9, eventTask.getStatus());

            ps.executeUpdate();
            System.out.println("EventTask added successfully.");

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//-------------Hoang
    public boolean deleteEventTaskById(int idTask) {
        String sql = "DELETE FROM task WHERE IdTask = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idTask);
            int rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//-------------Hoang
    public List<EventTask> getEventTaskByIdClub(int idClub) {
        List<EventTask> eventTaskList = new ArrayList<>();
        String sql = "SELECT * FROM task WHERE IdClub = ? ORDER BY DateCreate DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idClub);

            try (ResultSet rs = ps.executeQuery()) {
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

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventTaskList;
    }

//-------------Hoang
    public EventTask getEventTaskByIdTask(int idTask) {
        EventTask eventTask = null;
        String sql = "SELECT * FROM task WHERE IdTask = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idTask);

            try (ResultSet rs = ps.executeQuery()) {
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

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventTask;
    }

//-------------Hoang
    public boolean updateEventTask(EventTask eventTask) {
        String sql = "UPDATE task SET NameTask = ?, Description = ?, "
                + "Content = ?, Deadline = ?, Department = ?, Budget = ?, Status = ? "
                + "WHERE IdTask = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, eventTask.getNameTask());
            ps.setString(2, eventTask.getDescription());
            ps.setString(3, eventTask.getContent());
            ps.setTimestamp(4, new Timestamp(eventTask.getDeadline().getTime()));
            ps.setInt(5, eventTask.getDepartment());
            ps.setFloat(6, eventTask.getBudget());
            ps.setInt(7, eventTask.getStatus());
            ps.setInt(8, eventTask.getIdEventTask());

            int rowsUpdated = ps.executeUpdate();
            ps.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
