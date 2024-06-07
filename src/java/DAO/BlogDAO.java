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
        String sql = "INSERT INTO blog(IdBlog,TittleBlog,Image,Description,Content,DateCreate,DateModify,IdBlogType,`Show`,Status,IdClub) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, blog.getIdBlog());
            stmt.setString(2, blog.getTitleBlog());
            stmt.setString(3, blog.getImage());
            stmt.setString(4, blog.getDescription());
            stmt.setString(5, blog.getContent());
            java.sql.Date sqlDateCreate = new java.sql.Date(blog.getDateCreate().getTime());
            stmt.setDate(6, sqlDateCreate);
            java.sql.Date sqlDateModify = new java.sql.Date(blog.getDateModify().getTime());
            stmt.setDate(7, sqlDateModify);
            stmt.setInt(9, blog.getShow());
            stmt.setInt(8,blog.getIdBlogType());
            stmt.setInt(10, blog.getStatus());
            stmt.setInt(11, blog.getIdClub());
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
                post.setContent(rs.getString("Content"));
                post.setDateCreate(rs.getDate("DateCreate"));
                post.setDateModify(rs.getDate("DateModify"));
                post.setIdBlogType(rs.getInt("IdBlogType"));
                post.setShow(rs.getInt("Show"));
                post.setStatus(rs.getInt("Status"));
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
                post.setContent(rs.getString("Content"));
                post.setDateCreate(rs.getDate("DateCreate"));
                post.setDateModify(rs.getDate("DateModify"));
                post.setIdBlogType(rs.getInt("IdBlogType"));
                post.setShow(rs.getInt("Show"));
                post.setStatus(rs.getInt("Status"));
                post.setIdClub(rs.getInt("IdClub"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
     
     public List<Blog> getBlogListByType(int idBlogType) {
    List<Blog> blogList = new ArrayList<>();
    String sql = "SELECT * FROM blog WHERE IdBlogType = ?";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, idBlogType);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Blog blog = new Blog();
            blog.setIdBlog(rs.getInt("IdBlog"));
            blog.setTitleBlog(rs.getString("TittleBlog"));
            blog.setImage(rs.getString("Image"));
            blog.setDescription(rs.getString("Description"));
            blog.setContent(rs.getString("Content"));
            blog.setDateCreate(rs.getDate("DateCreate"));
            blog.setDateModify(rs.getDate("DateModify"));
            blog.setShow(rs.getInt("Show"));
            blog.setStatus(rs.getInt("Status"));
            blog.setIdClub(rs.getInt("IdClub"));
            blogList.add(blog);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return blogList;
}

  }
