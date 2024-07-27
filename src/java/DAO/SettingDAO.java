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
public class SettingDAO extends DBContext {

    //--------------- Hoang
    public List<Settings> getAllSettings() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            try (ResultSet rs = ps.executeQuery()) {
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
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }

    //----------------------Hoang
    public List<Settings> getSettingsBlog() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 4); // typeSetting = 4

            try (ResultSet rs = ps.executeQuery()) {
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
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }

    //-------------Hoang  
    public List<Settings> getSettingsClub() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1); // typeSetting = 1

            try (ResultSet rs = ps.executeQuery()) {
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
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }

    //------------------ Hoang
    public List<Settings> getSettingsEvent() {
        List<Settings> settingsList = new ArrayList<>();
        String sql = "SELECT * FROM settings WHERE typeSetting = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 5); // typeSetting = 5

            try (ResultSet rs = ps.executeQuery()) {
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
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settingsList;
    }

    //------------------ Hoang
    public Settings getSettingById(int idSetting) {
        Settings settings = null;
        String sql = "SELECT * FROM settings WHERE idSetting = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idSetting);

            try (ResultSet rs = ps.executeQuery()) {
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

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return settings;
    }

    //---Hoang
    public String getValueSettingById(int idSetting) {
        String valueSetting = null;
        String sql = "SELECT valueSetting FROM settings WHERE idSetting = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idSetting);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    valueSetting = rs.getString("valueSetting");
                }
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valueSetting;
    }

    //-----------------------------------------
}
