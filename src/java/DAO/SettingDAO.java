/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.util.List;
import Model.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 10t1q
 */
public class SettingDAO extends DBContext{
    //--------------- Hoang
    public List<Settings> getAllSettings() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings";

        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Settings settings = new Settings();
                settings.setIdSetting(rs.getInt("idSetting"));
                settings.setValueSetting(rs.getString("valueSetting"));
                settings.setTypeSetting(rs.getInt("typeSetting"));
                settings.setIdStudent(rs.getInt("idStudent"));
                settings.setDateCreate(rs.getTimestamp("DateCreate")); 
                settings.setDateModify(rs.getTimestamp("DateModify"));
                settings.setStatus(rs.getInt("status"));
                settingsList.add(settings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return settingsList;
    }
    public List<Settings> getSettingsBlog() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting ='4'";

        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Settings settings = new Settings();
                settings.setIdSetting(rs.getInt("idSetting"));
                settings.setValueSetting(rs.getString("valueSetting"));
                settings.setTypeSetting(rs.getInt("typeSetting"));
                settings.setIdStudent(rs.getInt("idStudent"));
                settings.setDateCreate(rs.getTimestamp("DateCreate"));
                settings.setDateModify(rs.getTimestamp("DateModify"));
                settings.setStatus(rs.getInt("Status"));
                settingsList.add(settings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }
    
    public List<Settings> getSettingsClub() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting ='1'";

        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Settings settings = new Settings();
                settings.setIdSetting(rs.getInt("idSetting"));
                settings.setValueSetting(rs.getString("valueSetting"));
                settings.setTypeSetting(rs.getInt("typeSetting"));
                settings.setIdStudent(rs.getInt("idStudent"));
                settings.setDateCreate(rs.getTimestamp("DateCreate"));
                settings.setDateModify(rs.getTimestamp("DateModify"));
                settings.setStatus(rs.getInt("Status"));
                settingsList.add(settings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }
    
     public List<Settings> getSettingsEvent() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting ='5'";

        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Settings settings = new Settings();
                settings.setIdSetting(rs.getInt("idSetting"));
                settings.setValueSetting(rs.getString("valueSetting"));
                settings.setTypeSetting(rs.getInt("typeSetting"));
                settings.setIdStudent(rs.getInt("idStudent"));
                settings.setDateCreate(rs.getTimestamp("DateCreate"));
                settings.setDateModify(rs.getTimestamp("DateModify"));
                settings.setStatus(rs.getInt("Status"));
                settingsList.add(settings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }
    
    public Settings getSettingById(int idSetting) {
        String sql = "SELECT * FROM settings WHERE idSetting = ?";
        Settings settings = null;

        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idSetting);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    settings = new Settings();
                    settings.setIdSetting(rs.getInt("idSetting"));
                    settings.setValueSetting(rs.getString("valueSetting"));
                    settings.setTypeSetting(rs.getInt("typeSetting"));
                    settings.setIdStudent(rs.getInt("idStudent"));
                    settings.setDateCreate(rs.getTimestamp("DateCreate")); // Use getTimestamp() here
                    settings.setDateModify(rs.getTimestamp("DateModify")); // Use getTimestamp() here
                    settings.setStatus(rs.getInt("Status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settings;
    }
    
    public String getValueSettingById(int idSetting) {
    String valueSetting = null;
    String sql = "SELECT valueSetting FROM settings WHERE idSetting = ?";

    try (Connection con = DBContext.getConnection(); 
         PreparedStatement st = con.prepareStatement(sql)) {
        
        st.setInt(1, idSetting);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                valueSetting = rs.getString("valueSetting");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return valueSetting;
}

    //-----------------------------------------
}
