/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 10t1q
 */
public class BlogType {
    private int idBlogType;
    private String nameBlogType;

    public BlogType() {
    }

    public BlogType(int idBlogType, String nameBlogType) {
        this.idBlogType = idBlogType;
        this.nameBlogType = nameBlogType;
    }

    public int getIdBlogType() {
        return idBlogType;
    }

    public void setIdBlogType(int idBlogType) {
        this.idBlogType = idBlogType;
    }

    public String getNameBlogType() {
        return nameBlogType;
    }

    public void setNameBlogType(String nameBlogType) {
        this.nameBlogType = nameBlogType;
    }
    
    
}
