/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author 10t1q
 */
public class EventTask {
    private int idEventTask;
    private String nameTask;
    private String description;
    private String content ;
    private int idEvent ;
    private int idClub ;
    private Timestamp dateCreate ;
    private Timestamp dateModify ;
    private Timestamp deadline ;
    private int department;
    private float budget ;
    private int Status ;

    public EventTask() {
    }

    public EventTask(String nameTask, String description, String content, int idEvent, int idClub, Timestamp deadline, int department, float budget, int Status) {
        this.nameTask = nameTask;
        this.description = description;
        this.content = content;
        this.idEvent = idEvent;
        this.idClub = idClub;
        this.deadline = deadline;
        this.department = department;
        this.budget = budget;
        this.Status = Status;
    }

    
    
    public int getIdEventTask() {
        return idEventTask;
    }

    public void setIdEventTask(int idEventTask) {
        this.idEventTask = idEventTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Timestamp getDateModify() {
        return dateModify;
    }

    public void setDateModify(Timestamp dateModify) {
        this.dateModify = dateModify;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    
}
