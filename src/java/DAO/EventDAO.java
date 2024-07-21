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
import java.sql.Timestamp;

/**
 *
 * @author 10t1q
 */
public class EventDAO extends DBContext {
//--------------Hoang

    public String getEventNameById(int idEvent) {
        String eventName = null;
        String sql = "SELECT NameEvent FROM event WHERE IdEvent = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, idEvent);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    eventName = rs.getString("NameEvent");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventName;
    }
//------------------ Hoang
    public List<Event> getEventsByClubId(int clubId) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE IdClub = ? ORDER BY DateCreate DESC , IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, clubId);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getTimestamp("DateCreate"));
                    event.setDateModify(rs.getTimestamp("DateModify"));
                    event.setEnddate(rs.getTimestamp("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getTimestamp("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("Content"));
                    event.setIdEventType(rs.getInt("CategoryEvent"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("Description"));
                    eventList.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }
//------------------ Hoang
    public List<Event> getAllEvent() {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event ORDER BY DateCreate DESC , IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Event event = new Event();
                event.setIdEvent(rs.getInt("IdEvent"));//
                event.setNameEvent(rs.getString("NameEvent"));//
                event.setDatecreate(rs.getTimestamp("DateCreate"));//
                event.setDateModify(rs.getTimestamp("DateModify"));//
                event.setEnddate(rs.getTimestamp("DateEnd"));//
                event.setIdClub(rs.getInt("IdClub"));//
                event.setDateStart(rs.getTimestamp("DateStart"));//
                event.setImage(rs.getString("Image"));//
                event.setContent(rs.getString("Content"));//
                event.setIdEventType(rs.getInt("CategoryEvent"));//
                event.setStatus(rs.getInt("Status"));//
                event.setAddress(rs.getString("Addreess"));//
                event.setDescription(rs.getString("Description"));//
                eventList.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }
//-------------Hoang

    public void addEvent(Event event) {
        String sql = "INSERT INTO event (NameEvent, DateCreate, DateModify, DateEnd, IdClub, DateStart, Image, Content, CategoryEvent, Status, Addreess, Description) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, event.getNameEvent());
            st.setTimestamp(2, event.getDatecreate());//
            st.setTimestamp(3, event.getDateModify());//
            st.setTimestamp(4, event.getEnddate());//
            st.setInt(5, event.getIdClub());
            st.setTimestamp(6, event.getDateStart());//
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
//---------------- Hoang

    public Event getEventById(int idEvent) {
        String sql = "SELECT * FROM event WHERE IdEvent = ?";
        Event event = null;

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idEvent);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));//
                    event.setNameEvent(rs.getString("NameEvent"));//
                    event.setDatecreate(rs.getTimestamp("DateCreate"));//
                    event.setDateModify(rs.getTimestamp("DateModify"));//
                    event.setEnddate(rs.getTimestamp("DateEnd"));//
                    event.setIdClub(rs.getInt("IdClub"));//
                    event.setDateStart(rs.getTimestamp("DateStart"));//
                    event.setImage(rs.getString("Image"));//
                    event.setContent(rs.getString("Content"));//
                    event.setIdEventType(rs.getInt("CategoryEvent"));//
                    event.setStatus(rs.getInt("Status"));//
                    event.setAddress(rs.getString("Addreess"));//
                    event.setDescription(rs.getString("Description"));//
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }
//------------------ Hoang

    public void updateEvent(Event event) {
        String sql = "UPDATE event SET NameEvent = ?, DateModify = ?, DateEnd = ?, IdClub = ?, DateStart = ?, Image = ?, content = ?, CategoryEvent = ?, Status = ?, Addreess = ?, description = ? WHERE IdEvent = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, event.getNameEvent());
            Timestamp sqlDateModify = new Timestamp(event.getDateModify().getTime());
            st.setTimestamp(2, sqlDateModify);
            Timestamp sqlEnddate = new Timestamp(event.getEnddate().getTime());
            st.setTimestamp(3, sqlEnddate);
            st.setInt(4, event.getIdClub());
            Timestamp sqlDateStart = new Timestamp(event.getDateStart().getTime());
            st.setTimestamp(5, sqlDateStart);
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
//------------------ Hoang

    public void deleteEvent(int idEvent) {
        String deleteTasksSql = "DELETE FROM task WHERE IdEvent = ?";
        String deleteEventSql = "DELETE FROM event WHERE IdEvent = ?";

        try (Connection con = DBContext.getConnection()) {
            // Bắt đầu giao dịch
            con.setAutoCommit(false);

            try (PreparedStatement deleteTasksStmt = con.prepareStatement(deleteTasksSql); PreparedStatement deleteEventStmt = con.prepareStatement(deleteEventSql)) {

                // Xóa các bản ghi trong bảng task
                deleteTasksStmt.setInt(1, idEvent);
                deleteTasksStmt.executeUpdate();

                // Xóa bản ghi trong bảng event
                deleteEventStmt.setInt(1, idEvent);
                deleteEventStmt.executeUpdate();

                // Hoàn tất giao dịch
                con.commit();
            } catch (SQLException e) {
                // Nếu có lỗi, rollback giao dịch
                con.rollback();
                e.printStackTrace();
            } finally {
                // Khôi phục chế độ tự động commit
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//------------------ Hoang
    public List<Event> getEventsByType(int idEventType) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE CategoryEvent = ? ORDER BY DateCreate DESC, IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idEventType);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));//
                    event.setNameEvent(rs.getString("NameEvent"));//
                    event.setDatecreate(rs.getTimestamp("DateCreate"));//
                    event.setDateModify(rs.getTimestamp("DateModify"));//
                    event.setEnddate(rs.getTimestamp("DateEnd"));//
                    event.setIdClub(rs.getInt("IdClub"));//
                    event.setDateStart(rs.getTimestamp("DateStart"));//
                    event.setImage(rs.getString("Image"));//
                    event.setContent(rs.getString("Content"));//
                    event.setIdEventType(rs.getInt("CategoryEvent"));//
                    event.setStatus(rs.getInt("Status"));//
                    event.setAddress(rs.getString("Addreess"));//
                    event.setDescription(rs.getString("Description"));//
                    eventList.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }
//------------------ Hoang

    public List<Event> getEventsByName(String eventName) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE NameEvent LIKE ? ORDER BY DateCreate DESC, IdEvent DESC";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, "%" + eventName + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));//
                    event.setNameEvent(rs.getString("NameEvent"));//
                    event.setDatecreate(rs.getTimestamp("DateCreate"));//
                    event.setDateModify(rs.getTimestamp("DateModify"));//
                    event.setEnddate(rs.getTimestamp("DateEnd"));//
                    event.setIdClub(rs.getInt("IdClub"));//
                    event.setDateStart(rs.getTimestamp("DateStart"));//
                    event.setImage(rs.getString("Image"));//
                    event.setContent(rs.getString("Content"));//
                    event.setIdEventType(rs.getInt("CategoryEvent"));//
                    event.setStatus(rs.getInt("Status"));//
                    event.setAddress(rs.getString("Addreess"));//
                    event.setDescription(rs.getString("Description"));//
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
        if (!eventType.isBlank()) {
            query += "and s.Name = '" + eventType + "'";
        }
        if (!nameEvent.isBlank()) {
            query += " and e.NameEvent like '%" + nameEvent + "%";
        }

        query += "Order by e.DateCreate DESC;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event getEvent = new Event(rs.getInt("IdEvent"), rs.getString("NameEvent"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getString("Content"), rs.getString("Addreess"),
                        rs.getTimestamp("DateStart"), rs.getTimestamp("DateEnd"),
                        rs.getInt("IdClub"), rs.getString("Name"),
                        rs.getTimestamp("DateCreate"), rs.getTimestamp("DateModify"), rs.getInt("Status"));
                getEventAll.add(getEvent);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getEventAll;
    }

    public Event getLatestEventByClub(int idClub) {
        Event event = null;
        String sql = "SELECT * FROM event WHERE IdClub = ? ORDER BY DateCreate DESC, IdEvent DESC LIMIT 1";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idClub); // Set the IdClub parameter

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getTimestamp("DateCreate"));
                    event.setDateModify(rs.getTimestamp("DateModify"));
                    event.setEnddate(rs.getTimestamp("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getTimestamp("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("content"));
                    event.setIdEventType(rs.getInt("IdEventType"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("description"));
                    event.setImage(rs.getString("Image"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    public List<Event> getRandomFourEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE Status = 1 ORDER BY RAND() LIMIT 3";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Event event = new Event();
                    event.setIdEvent(rs.getInt("IdEvent"));
                    event.setNameEvent(rs.getString("NameEvent"));
                    event.setDatecreate(rs.getTimestamp("DateCreate"));
                    event.setDateModify(rs.getTimestamp("DateModify"));
                    event.setEnddate(rs.getTimestamp("DateEnd"));
                    event.setIdClub(rs.getInt("IdClub"));
                    event.setDateStart(rs.getTimestamp("DateStart"));
                    event.setImage(rs.getString("Image"));
                    event.setContent(rs.getString("content"));
                    event.setIdEventType(rs.getInt("CategoryEvent"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("description"));
                    event.setImage(rs.getString("Image"));

                    events.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static void main(String[] args) {
        EventDAO daoEvent = new EventDAO();
        List<Event> listEventAll = daoEvent.getRandomFourEvents();
        for (Event event : listEventAll) {
            System.out.println(event.getNameEvent());
        }
    }
}
