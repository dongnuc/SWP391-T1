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
import java.util.HashMap;

/**
 *
 * @author 10t1q
 */
public class EventDAO extends DBContext {

    public HashMap<String, String> eventReportDong(String idClub, String year) {
        HashMap<String, String> listReport = new HashMap<>();
        String query = "SELECT\n"
                + "    CASE\n"
                + "        WHEN MONTH(DateStart) BETWEEN 1 AND 4 THEN 'Q1'\n"
                + "        WHEN MONTH(DateStart) BETWEEN 5 AND 8 THEN 'Q2'\n"
                + "        WHEN MONTH(DateStart) BETWEEN 9 AND 12 THEN 'Q3'\n"
                + "        ELSE 'Other'\n"
                + "    END AS Quarter,\n"
                + "    COUNT(IdEvent) AS NumberOfEvents\n"
                + "FROM Event\n"
                + "WHERE IdClub = ? AND YEAR(DateStart) = ? \n"
                + "GROUP BY Quarter\n"
                + "ORDER BY FIELD(Quarter, 'Q1', 'Q2', 'Q3');";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idClub);
            ps.setString(2, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listReport.put(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listReport;
    }

//--------------Hoang
    public String getEventNameById(int idEvent) {
        String eventName = null;
        String sql = "SELECT NameEvent FROM event WHERE IdEvent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idEvent);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                eventName = rs.getString("NameEvent");
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventName;
    }

//------------------ Hoang
    public List<Event> getEventsByClubId(int clubId) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE IdClub = ? ORDER BY DateCreate DESC, IdEvent DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, clubId);
            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    //-----Hoàng
    public List<Event> getRecentEvents(int limit) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event ORDER BY DateCreate DESC, IdEvent DESC LIMIT ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, limit); // Set the value for LIMIT
            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

//------------------ Hoang
    public List<Event> getAllEvent() {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event ORDER BY DateCreate DESC, IdEvent DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

//-------------Hoang
    public void addEvent(Event event) {
        String sql = "INSERT INTO event (NameEvent, DateCreate, DateModify, DateEnd, IdClub, DateStart, Image, Content, CategoryEvent, Status, Addreess, Description) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, event.getNameEvent());
            ps.setTimestamp(2, event.getDatecreate());// Set the DateCreate timestamp
            ps.setTimestamp(3, event.getDateModify());// Set the DateModify timestamp
            ps.setTimestamp(4, event.getEnddate());// Set the DateEnd timestamp
            ps.setInt(5, event.getIdClub());// Set the IdClub
            ps.setTimestamp(6, event.getDateStart());// Set the DateStart timestamp
            ps.setString(7, event.getImage());// Set the Image
            ps.setString(8, event.getContent());// Set the Content
            ps.setInt(9, event.getIdEventType());// Set the CategoryEvent
            ps.setInt(10, event.getStatus());// Set the Status
            ps.setString(11, event.getAddress());// Set the Address
            ps.setString(12, event.getDescription());// Set the Description

            ps.executeUpdate();
            System.out.println("Event added successfully.");

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//---------------- Hoang
    public Event getEventById(int idEvent) {
        String sql = "SELECT * FROM event WHERE IdEvent = ?";
        Event event = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idEvent);

            try (ResultSet rs = ps.executeQuery()) {
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
                    event.setContent(rs.getString("Content"));
                    event.setIdEventType(rs.getInt("CategoryEvent"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("Description"));
                }
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

//------------------ Hoang
    public void updateEvent(Event event) {
        String sql = "UPDATE event SET NameEvent = ?, DateModify = ?, DateEnd = ?, IdClub = ?, DateStart = ?, Image = ?, Content = ?, CategoryEvent = ?, Status = ?, Addreess = ?, Description = ? WHERE IdEvent = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, event.getNameEvent());
            ps.setTimestamp(2, event.getDateModify());
            ps.setTimestamp(3, event.getEnddate());
            ps.setInt(4, event.getIdClub());
            ps.setTimestamp(5, event.getDateStart());
            ps.setString(6, event.getImage());
            ps.setString(7, event.getContent());
            ps.setInt(8, event.getIdEventType());
            ps.setInt(9, event.getStatus());
            ps.setString(10, event.getAddress());
            ps.setString(11, event.getDescription());
            ps.setInt(12, event.getIdEvent());

            ps.executeUpdate();
            System.out.println("Event updated successfully.");

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//------------------ Hoang
    public void deleteEvent(int idEvent) {
        String deleteTasksSql = "DELETE FROM task WHERE IdEvent = ?";
        String deleteEventSql = "DELETE FROM event WHERE IdEvent = ?";

        try {
            // Bắt đầu giao dịch
            connection.setAutoCommit(false);

            try (PreparedStatement deleteTasksStmt = connection.prepareStatement(deleteTasksSql); PreparedStatement deleteEventStmt = connection.prepareStatement(deleteEventSql)) {

                // Xóa các bản ghi trong bảng task
                deleteTasksStmt.setInt(1, idEvent);
                deleteTasksStmt.executeUpdate();

                // Xóa bản ghi trong bảng event
                deleteEventStmt.setInt(1, idEvent);
                deleteEventStmt.executeUpdate();

                // Hoàn tất giao dịch
                connection.commit();
                System.out.println("Event and associated tasks deleted successfully.");

            } catch (SQLException e) {
                // Nếu có lỗi, rollback giao dịch
                connection.rollback();
                e.printStackTrace();
            } finally {
                // Khôi phục chế độ tự động commit
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//------------------ Hoang
    public List<Event> getEventsByType(int idEventType) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE CategoryEvent = ? ORDER BY DateCreate DESC, IdEvent DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idEventType);

            try (ResultSet rs = ps.executeQuery()) {
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

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

//------------------ Hoang
    public List<Event> getEventsByName(String eventName) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE NameEvent LIKE ? ORDER BY DateCreate DESC, IdEvent DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + eventName + "%");

            try (ResultSet rs = ps.executeQuery()) {
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

            ps.close();
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

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idClub); // Set the IdClub parameter

            try (ResultSet rs = ps.executeQuery()) {
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
                    event.setContent(rs.getString("Content"));
                    event.setIdEventType(rs.getInt("CategoryEvent"));
                    event.setStatus(rs.getInt("Status"));
                    event.setAddress(rs.getString("Addreess"));
                    event.setDescription(rs.getString("Description"));
                }
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

    public List<Event> getRandomFourEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE Status = 1 ORDER BY RAND() LIMIT 4";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            try (ResultSet rs = ps.executeQuery()) {
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
                    events.add(event);
                }
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public static void main(String[] args) {
        EventDAO daoEvent = new EventDAO();
        List<Event> listEventAll = daoEvent.getAllEvent();
        System.out.println(listEventAll.size());
        
    }
}
