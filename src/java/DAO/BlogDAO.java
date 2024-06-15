package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Blog;

public class BlogDAO extends DBContext {

    public void insertPost(Blog blog) {
        String sql = "INSERT INTO blog(IdBlog,TittleBlog,Image,Description,Content,DateCreate,DateModify,IdBlogType,`Show`,Status,IdClub) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
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
            stmt.setInt(8, blog.getIdBlogType());
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
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

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
        String sql = "SELECT * FROM blog WHERE IdBlog = ?";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, idBlog);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
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
                    return post;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Blog> getBlogListByType(int idBlogType) {
        List<Blog> blogList = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE IdBlogType = ?";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement st = con.prepareStatement(sql)) {
             
            st.setInt(1, idBlogType);
            try (ResultSet rs = st.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }

    public void updatePost(Blog post) {
        String sql = "UPDATE blog SET TittleBlog = ?, Image = ?, Description = ?, Content = ?, DateModify = ?, IdBlogType = ?, `Show` = ?, Status = ?, IdClub = ? WHERE IdBlog = ?";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setString(1, post.getTitleBlog());
            stmt.setString(2, post.getImage());
            stmt.setString(3, post.getDescription());
            stmt.setString(4, post.getContent());
            java.sql.Date sqlDateModify = new java.sql.Date(post.getDateModify().getTime());
            stmt.setDate(5, sqlDateModify);
            stmt.setInt(6, post.getIdBlogType());
            stmt.setInt(7, post.getShow());
            stmt.setInt(8, post.getStatus());
            stmt.setInt(9, post.getIdClub());
            stmt.setInt(10, post.getIdBlog());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int idBlog) {
        String sql = "DELETE FROM blog WHERE IdBlog = ?";
        
        try (Connection con = DBContext.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, idBlog);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
