/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Hau
 */
public class TypeClub {
    private int IdTypeClub;
    private String NameTypeClub;

    public TypeClub() {
    }

    public TypeClub(int IdTypeClub, String NameTypeClub) {
        this.IdTypeClub = IdTypeClub;
        this.NameTypeClub = NameTypeClub;
    }

    public int getIdTypeClub() {
        return IdTypeClub;
    }

    public void setIdTypeClub(int IdTypeClub) {
        this.IdTypeClub = IdTypeClub;
    }

    public String getNameTypeClub() {
        return NameTypeClub;
    }

    public void setNameTypeClub(String NameTypeClub) {
        this.NameTypeClub = NameTypeClub;
    }
    
}
