/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Hau
 */
public class RegisterClub {
    private int idRegister;
    private String nameclub;
    private String reason;
    private int idStudent;
    private int status;
    private int idtypeclub;

    public RegisterClub() {
    }

    public RegisterClub(int idRegister, String nameclub, String reason, int idStudent, int status, int idtypeclub) {
        this.idRegister = idRegister;
        this.nameclub = nameclub;
        this.reason = reason;
        this.idStudent = idStudent;
        this.status = status;
        this.idtypeclub = idtypeclub;
    }

    public int getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(int idRegister) {
        this.idRegister = idRegister;
    }

    public String getNameclub() {
        return nameclub;
    }

    public void setNameclub(String nameclub) {
        this.nameclub = nameclub;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdtypeclub() {
        return idtypeclub;
    }

    public void setIdtypeclub(int idtypeclub) {
        this.idtypeclub = idtypeclub;
    }

    

   
}
