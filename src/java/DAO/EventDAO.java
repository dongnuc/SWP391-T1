/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.*;

/**
 *
 * @author 10t1q
 */
public class EventDAO extends DBContext {

    public List<Event> getAllEvent() {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event ORDER BY DateCreate DESC , IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Event event = new Event();
                event.setIdEvent(rs.getInt("IdEvent"));
                event.setNameEvent(rs.getString("NameEvent"));
                event.setDatecreate(rs.getDate("DateCreate"));
                event.setDateModify(rs.getDate("DateModify"));
                event.setEnddate(rs.getDate("DateEnd"));
                event.setIdClub(rs.getInt("IdClub"));
                event.setDateStart(rs.getDate("DateStart"));
                event.setImage(rs.getString("Image"));
                event.setContent(rs.getString("content"));
                event.setIdEventType(rs.getInt("IdEventType"));
                event.setStatus(rs.getInt("Status"));
                event.setAddress(rs.getString("Addreess"));
                event.setDescription(rs.getString("description"));
                eventList.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public void addEvent(Event event) {
        String sql = "INSERT INTO event (NameEvent, DateCreate, DateModify, DateEnd, IdClub, DateStart, Image, content, IdEventType, Status, Addreess, description) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, event.getNameEvent());
            st.setDate(2, new java.sql.Date(event.getDatecreate().getTime()));
            st.setDate(3, new java.sql.Date(event.getDateModify().getTime()));
            st.setDate(4, new java.sql.Date(event.getEnddate().getTime()));
            st.setInt(5, event.getIdClub());
            st.setDate(6, new java.sql.Date(event.getDateStart().getTime()));
            st.setString(7, event.getImage());
            st.setString(8, event.getContent());
            st.setInt(9, event.getIdEventType());
            st.setInt(10, event.getStatus());
            st.setString(11, event.getAddress());
            st.setString(12, event.getDescription());

            st.executeUpdate();
            System.out.println("Event added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event getEventById(int idEvent) {
        String sql = "SELECT * FROM event WHERE IdEvent = ?";
        Event event = null;

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idEvent);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getDate("DateCreate"));
                    event.setDateModify(rs.getDate("DateModify"));
                    event.setEnddate(rs.getDate("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getDate("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("content"));
                    event.setIdEventType(rs.getInt("IdEventType"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE event SET NameEvent = ?, DateModify = ?, DateEnd = ?, IdClub = ?, DateStart = ?, Image = ?, content = ?, IdEventType = ?, Status = ?, Addreess = ?, description = ? WHERE IdEvent = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, event.getNameEvent());
            st.setDate(2, new java.sql.Date(event.getDateModify().getTime()));
            st.setDate(3, new java.sql.Date(event.getEnddate().getTime()));
            st.setInt(4, event.getIdClub());
            st.setDate(5, new java.sql.Date(event.getDateStart().getTime()));
            st.setString(6, event.getImage());
            st.setString(7, event.getContent());
            st.setInt(8, event.getIdEventType());
            st.setInt(9, event.getStatus());
            st.setString(10, event.getAddress());
            st.setString(11, event.getDescription());
            st.setInt(12, event.getIdEvent());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int idEvent) {
        String sql = "DELETE FROM event WHERE IdEvent = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idEvent);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getEventsByType(int idEventType) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE IdEventType = ? ORDER BY DateCreate DESC, IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idEventType);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getDate("DateCreate"));
                    event.setDateModify(rs.getDate("DateModify"));
                    event.setEnddate(rs.getDate("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getDate("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("content"));
                    event.setIdEventType(rs.getInt("IdEventType"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("description"));
                    eventList.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<Event> getEventsByName(String eventName) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE NameEvent LIKE ? ORDER BY DateCreate DESC, IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, "%" + eventName + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getDate("DateCreate"));
                    event.setDateModify(rs.getDate("DateModify"));
                    event.setEnddate(rs.getDate("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getDate("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("content"));
                    event.setIdEventType(rs.getInt("IdEventType"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("description"));
                    eventList.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<String> getEvenTypeSetting() {
        String query = "select Name from setting where IdType = 5 and IdEvent is null and Status = 1";
        List<String> listType = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String typeEvent = rs.getString(1);
                listType.add(typeEvent);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listType;
    }

    public List<Event> getAllEventSetting(String nameEvent, String eventType) {
        List<Event> getEventAll = new ArrayList<>();
        String query = "select e.IdEvent,e.Image, e.NameEvent, e.Description, e.Content, e.Addreess, e.DateStart,"
                + " e.DateEnd,e.IdClub, e.DateCreate, e.DateModify, s.Name, e.Status from Event e"
                + " Join setting s ON e.IdEvent = s.IdEvent where 1 = 1 ";
        if(!eventType.isBlank()){
            query += "and s.Name = '" + eventType + "'";
        }
        if(!nameEvent.isBlank()){
            query += " and e.NameEvent like '%" + nameEvent + "%"; 
        }
        
        query += "Order by e.DateCreate DESC;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Event getEvent = new Event(rs.getInt("IdEvent"), rs.getString("NameEvent"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getString("Content"), rs.getString("Addreess"),
                        rs.getDate("DateStart"), rs.getDate("DateEnd"),
                        rs.getInt("IdClub"), rs.getString("Name"),
                        rs.getDate("DateCreate"), rs.getDate("DateModify"), rs.getInt("Status"));
                getEventAll.add(getEvent);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getEventAll;
    }

    public static void main(String[] args) {
        EventDAO daoEvent = new EventDAO();
        List<Event> listEventAll = daoEvent.getAllEventSetting("", "Competitions and Contests");
        System.out.println(listEventAll.size());
    }
}
