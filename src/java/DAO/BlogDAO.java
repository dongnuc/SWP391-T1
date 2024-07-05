package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Blog;
import java.sql.Timestamp;

public class BlogDAO extends DBContext {
//--------------------------------------------------------

    public void insertPost(Blog blog) {
        String sql = "INSERT INTO blog(IdBlog, TittleBlog, Image, Description, Content, DateCreate, DateModify, categoryBlog, `Show`, Status, IdClub) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, blog.getIdBlog());//
            stmt.setString(2, blog.getTitleBlog());//
            stmt.setString(3, blog.getImage());//
            stmt.setString(4, blog.getDescription());//
            stmt.setString(5, blog.getContent());//

            // Chuyển đổi java.util.Date thành java.sql.Timestamp
            Timestamp sqlDateCreate = new Timestamp(blog.getDateCreate().getTime());
            stmt.setTimestamp(6, sqlDateCreate);//
            Timestamp sqlDateModify = new Timestamp(blog.getDateModify().getTime());
            stmt.setTimestamp(7, sqlDateModify);//

            stmt.setInt(8, blog.getIdBlogType());//
            stmt.setInt(9, blog.getShow());//
            stmt.setInt(10, blog.getStatus());//
            stmt.setInt(11, blog.getIdClub());//

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//------------------------------------
    public List<Blog> getAllPosts() {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Blog post = new Blog();
                post.setIdBlog(rs.getInt("IdBlog"));//
                post.setTitleBlog(rs.getString("TittleBlog"));//
                post.setImage(rs.getString("Image"));//
                post.setDescription(rs.getString("Description"));//
                post.setContent(rs.getString("Content"));//
                post.setDateCreate(rs.getTimestamp("DateCreate"));//
                post.setDateModify(rs.getTimestamp("DateModify"));//
                post.setIdBlogType(rs.getInt("categoryBlog"));//
                post.setShow(rs.getInt("Show"));//
                post.setStatus(rs.getInt("Status"));
                post.setIdClub(rs.getInt("IdClub"));//
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
//-------------------------------------------------------

    public Blog getPost(int idBlog) {
        String sql = "SELECT * FROM blog WHERE IdBlog = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idBlog);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Blog post = new Blog();
                    post.setIdBlog(rs.getInt("IdBlog"));//
                    post.setTitleBlog(rs.getString("TittleBlog"));//
                    post.setImage(rs.getString("Image"));//
                    post.setDescription(rs.getString("Description"));//
                    post.setContent(rs.getString("Content"));//
                    post.setDateCreate(rs.getTimestamp("DateCreate"));//
                    post.setDateModify(rs.getTimestamp("DateModify"));//
                    post.setIdBlogType(rs.getInt("categoryBlog"));//
                    post.setShow(rs.getInt("Show"));//
                    post.setStatus(rs.getInt("Status"));//
                    post.setIdClub(rs.getInt("IdClub"));//
                    return post;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//------------

    public List<Blog> getBlogListByType(int idBlogType) {
        List<Blog> blogList = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE categoryBlog = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idBlogType);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Blog blog = new Blog();
                    blog.setIdBlog(rs.getInt("IdBlog"));//
                    blog.setTitleBlog(rs.getString("TittleBlog"));//
                    blog.setImage(rs.getString("Image"));//
                    blog.setDescription(rs.getString("Description"));//
                    blog.setContent(rs.getString("Content"));//
                    blog.setDateCreate(rs.getTimestamp("DateCreate"));//
                    blog.setDateModify(rs.getTimestamp("DateModify"));//
                    blog.setShow(rs.getInt("Show"));//
                    blog.setIdBlogType(rs.getInt("categoryBlog"));//
                    blog.setStatus(rs.getInt("Status"));//
                    blog.setIdClub(rs.getInt("IdClub"));//
                    blogList.add(blog);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }
//------------------------------------------------------------------
    public void updatePost(Blog post) {
        String sql = "UPDATE blog SET TittleBlog = ?, Image = ?, Description = ?, Content = ?, DateModify = ?, categoryBlog = ?, `Show` = ?, Status = ?, IdClub = ? WHERE IdBlog = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, post.getTitleBlog());
            stmt.setString(2, post.getImage());
            stmt.setString(3, post.getDescription());
            stmt.setString(4, post.getContent());
            Timestamp sqlDateModify = new Timestamp(post.getDateModify().getTime());
            stmt.setTimestamp(5, sqlDateModify);
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
//-----------------------------------------------------

    public void deletePost(int idBlog) {
        String sql = "DELETE FROM blog WHERE IdBlog = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idBlog);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTypeBlog() {
        String query = "select Name from setting where IdType = 5 and IdEvent is null";
        List<String> listTypeBlog = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String getType = rs.getString(1);
                listTypeBlog.add(getType);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listTypeBlog;
    }

    public List<Blog> getAllBlogSetting(String tittle, String typeBlog) {
        List<Blog> listBlog = new ArrayList<>();
        String query = "select b.IdBlog, b.Image, b.TittleBlog, b.Description, b.Content, b.Show, st.Name,\n"
                + " b.IdClub, b.DateCreate,b.DateModify,b.Status from Blog b join setting st on b.IdBlog = st.IdBlog where 1 = 1 and b.Status = 1 ";
        if (!typeBlog.isBlank()) {
            query += " and st.Name = " + typeBlog + " ";
        }
        if (!tittle.isBlank()) {
            query += " and b.tittleBlog like '%" + tittle + "%";
        }
        query += " order by b.IdBlog DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog getBlog = new Blog(rs.getInt("IdBlog"), rs.getString("TittleBlog"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getString("content"), rs.getString("Name"), rs.getInt("IdClub"),
                        rs.getInt("Show"), rs.getInt("Status"), rs.getTimestamp("DateCreate"),
                        rs.getTimestamp("DateModify"));
                listBlog.add(getBlog);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listBlog;
    }

    public Blog getBlogSetting(String idBlog) {
        String query = "select b.IdBlog, b.Image, b.TittleBlog, b.Description, b.Content, b.Show, st.Name,\n"
                + " b.IdClub, b.DateCreate,b.DateModify,b.Status from Blog b join setting st on b.IdBlog = st.IdBlog"
                + " where b.Status = 1 and b.IdBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idBlog);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Blog getBlog = new Blog(rs.getInt("IdBlog"), rs.getString("TittleBlog"),
                        rs.getString("Image"), rs.getString("Description"),
                        rs.getString("content"), rs.getString("Name"), rs.getInt("IdClub"),
                        rs.getInt("Show"), rs.getInt("Status"), rs.getTimestamp("DateCreate"),
                        rs.getTimestamp("DateModify"));
                return getBlog;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        BlogDAO daoBlog = new BlogDAO();
        List<Blog> getBlog = daoBlog.getAllBlogSetting("", "");
        System.out.println(getBlog.size());
        List<String> listTypeBlog = daoBlog.getTypeBlog();
        for (String string : listTypeBlog) {
            System.out.println(string);
        }
    }

}
