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

public class BlogDAO extends DBContext{

    public void insertPost(Blog blog) {
        String sql = "INSERT INTO blog(IdBlog,TittleBlog,Image,Description,DateCreate,DateModify,`Show`,Status,IdClub) VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, blog.getIdBlog());
            stmt.setString(2, blog.getTitleBlog());
            stmt.setString(3, blog.getImage());
            stmt.setString(4, blog.getDescription());
            java.sql.Date sqlDateCreate = new java.sql.Date(blog.getDateCreate().getTime());
            stmt.setDate(5, sqlDateCreate);
            java.sql.Date sqlDateModify = new java.sql.Date(blog.getDateModify().getTime());
            stmt.setDate(6, sqlDateModify);
            stmt.setString(7, blog.getShow());
            stmt.setString(8, blog.getStatus());
            stmt.setInt(9, blog.getIdClub());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Blog> getAllPosts() {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Blog post = new Blog();
                post.setIdBlog(rs.getInt("IdBlog"));
                post.setTitleBlog(rs.getString("TittleBlog"));
                post.setImage(rs.getString("Image"));
                post.setDescription(rs.getString("Description"));
                post.setDateCreate(rs.getDate("DateCreate"));
                post.setDateModify(rs.getDate("DateModify"));
                post.setShow(rs.getString("Show"));
                post.setStatus(rs.getString("Status"));
                post.setIdClub(rs.getInt("IdClub"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    
     public Blog getPost(int idBlog) {
        Blog post = null;
        String sql = "SELECT * FROM blog WHERE IdBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idBlog);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post = new Blog();
                post.setIdBlog(rs.getInt("IdBlog"));
                post.setTitleBlog(rs.getString("TittleBlog"));
                post.setImage(rs.getString("Image"));
                post.setDescription(rs.getString("Description"));
                post.setDateCreate(rs.getDate("DateCreate"));
                post.setDateModify(rs.getDate("DateModify"));
                post.setShow(rs.getString("Show"));
                post.setStatus(rs.getString("Status"));
                post.setIdClub(rs.getInt("IdClub"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
  }
