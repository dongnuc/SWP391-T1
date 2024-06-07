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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.*;
/**
 *
 * @author 10t1q
 */
public class BlogTypeDAO extends DBContext {
    public List<BlogType> getAllPosts() {
        List<BlogType> posts = new ArrayList<>();
        String sql = "SELECT * FROM BlogType";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BlogType post = new BlogType();
                post.setIdBlogType(rs.getInt("IdBlogType"));
                post.setNameBlogType(rs.getString("NameBlogType"));
                
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    public BlogType getBlogTypeByID(int id) {
    String sql = "SELECT * FROM BlogType WHERE IdBlogType = ?";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            BlogType blogType = new BlogType();
            blogType.setIdBlogType(rs.getInt("IdBlogType"));
            blogType.setNameBlogType(rs.getString("NameBlogType"));
            return blogType;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Return null if no matching record is found
}

}
