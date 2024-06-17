/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 10t1q
 */
public class EventType {

    private int idEventType;
    private String nameEventType;

    public EventType() {
    }

    public EventType(int idEventType, String nameEventType) {
        this.idEventType = idEventType;
        this.nameEventType = nameEventType;
    }

    public int getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(int idEventType) {
        this.idEventType = idEventType;
    }

    public String getNameEventType() {
        return nameEventType;
    }

    public void setNameEventType(String nameEventType) {
        this.nameEventType = nameEventType;
    }

}
