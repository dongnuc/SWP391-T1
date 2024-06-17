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
public class EventTypeDAO {
 
    public List<EventType> getAllEventTypes() {
        List<EventType> eventTypeList = new ArrayList<>();
        String sql = "SELECT * FROM EventType";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                EventType eventType = new EventType();
                eventType.setIdEventType(rs.getInt("IdEventType"));
                eventType.setNameEventType(rs.getString("NameEventType"));
                
                eventTypeList.add(eventType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventTypeList;
    }
    
    public EventType getEventTypeByID(int id) {
        String sql = "SELECT * FROM EventType WHERE IdEventType = ?";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql)) {
             
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    EventType eventType = new EventType();
                    eventType.setIdEventType(rs.getInt("IdEventType"));
                    eventType.setNameEventType(rs.getString("NameEventType"));
                    return eventType;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
