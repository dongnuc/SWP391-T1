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
//-----------------------------Hoang

    public void insertPost(Blog blog) {
        String sql = "INSERT INTO blog(IdBlog, TittleBlog, Image, Description, Content, DateCreate, DateModify, categoryBlog, `Show`, Status, IdClub) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ps.setInt(1, blog.getIdBlog());//
            ps.setString(2, blog.getTitleBlog());//
            ps.setString(3, blog.getImage());//
            ps.setString(4, blog.getDescription());//
            ps.setString(5, blog.getContent());//

            // Chuyển đổi java.util.Date thành java.sql.Timestamp
            Timestamp sqlDateCreate = new Timestamp(blog.getDateCreate().getTime());
            ps.setTimestamp(6, sqlDateCreate);//
            Timestamp sqlDateModify = new Timestamp(blog.getDateModify().getTime());
            ps.setTimestamp(7, sqlDateModify);//

            ps.setInt(8, blog.getIdBlogType());//
            ps.setInt(9, blog.getShow());//
            ps.setInt(10, blog.getStatus());//
            ps.setInt(11, blog.getIdClub());//

            ps.executeUpdate();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//------------------ Hoang
    public List<Blog> searchBlogsByTitle(String title) {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE TittleBlog LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog post = new Blog();
                post.setIdBlog(rs.getInt("IdBlog"));
                post.setTitleBlog(rs.getString("TittleBlog"));
                post.setImage(rs.getString("Image"));
                post.setDescription(rs.getString("Description"));
                post.setContent(rs.getString("Content"));
                post.setDateCreate(rs.getTimestamp("DateCreate"));
                post.setDateModify(rs.getTimestamp("DateModify"));
                post.setIdBlogType(rs.getInt("categoryBlog"));
                post.setShow(rs.getInt("Show"));
                post.setStatus(rs.getInt("Status"));
                post.setIdClub(rs.getInt("IdClub"));
                posts.add(post);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

//------------------ Hoang
    public List<Blog> getAllPosts() {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog ORDER BY DateCreate DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

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
                post.setStatus(rs.getInt("Status"));//
                post.setIdClub(rs.getInt("IdClub"));//
                posts.add(post);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    //--------------------Hoang
    public List<Blog> getLatestPosts(int limit) {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog ORDER BY DateCreate DESC LIMIT ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, limit);  // Thiết lập giá trị cho tham số LIMIT
            ResultSet rs = ps.executeQuery();

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
                post.setStatus(rs.getInt("Status"));//
                post.setIdClub(rs.getInt("IdClub"));//
                posts.add(post);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

//---------- Hoang
    public List<Blog> getPostsByClubId(int clubId) {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE IdClub = ? ORDER BY DateCreate DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, clubId);  // Thiết lập giá trị cho tham số IdClub
            ResultSet rs = ps.executeQuery();

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
                post.setStatus(rs.getInt("Status"));//
                post.setIdClub(rs.getInt("IdClub"));//
                posts.add(post);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    //----------------------------Hoang
    public List<Blog> getBlogByIdClub(int IdClub) {
        List<Blog> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE IdClub = ? ORDER BY DateCreate DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, IdClub);
            ResultSet rs = ps.executeQuery();

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
                post.setStatus(rs.getInt("Status"));//
                post.setIdClub(rs.getInt("IdClub"));//
                posts.add(post);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

//--------------------Hoang
    public Blog getPost(int idBlog) {
        String sql = "SELECT * FROM blog WHERE IdBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idBlog);
            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//------------------ Hoang
    public List<Blog> getBlogListByType(int idBlogType) {
        List<Blog> blogList = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE categoryBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idBlogType);
            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }

//------------------ Hoang
    public void updatePost(Blog post) {
        String sql = "UPDATE blog SET TittleBlog = ?, Image = ?, Description = ?, Content = ?, DateModify = ?, categoryBlog = ?, `Show` = ?, Status = ?, IdClub = ? WHERE IdBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, post.getTitleBlog());//
            ps.setString(2, post.getImage());//
            ps.setString(3, post.getDescription());//
            ps.setString(4, post.getContent());//

            Timestamp sqlDateModify = new Timestamp(post.getDateModify().getTime());
            ps.setTimestamp(5, sqlDateModify);//

            ps.setInt(6, post.getIdBlogType());//
            ps.setInt(7, post.getShow());//
            ps.setInt(8, post.getStatus());//
            ps.setInt(9, post.getIdClub());//
            ps.setInt(10, post.getIdBlog());//

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//---------------------- Hoang
    public void deletePost(int idBlog) {
        String sql = "DELETE FROM blog WHERE IdBlog = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idBlog);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTypeBlog() {
        String query = "SELECT Name FROM setting WHERE IdType = 5 AND IdEvent IS NULL";
        List<String> listTypeBlog = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String getType = rs.getString("Name");
                listTypeBlog.add(getType);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
            rs.close();
            ps.close();
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
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Blog> getRandomFiveBlogsByClub() {
        List<Blog> blogs = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE Status = 1 ORDER BY RAND() LIMIT 4";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setIdBlog(rs.getInt("IdBlog"));//
                blog.setTitleBlog(rs.getString("TittleBlog"));//
                blog.setImage(rs.getString("Image"));//
                blog.setDescription(rs.getString("Description"));//
                blog.setShow(rs.getInt("Show"));//
                blog.setStatus(rs.getInt("Status"));//
                blog.setIdClub(rs.getInt("IdClub"));//
                blog.setDateCreate(rs.getTimestamp("DateCreate"));//
                blog.setDateModify(rs.getTimestamp("DateModify"));//
                blogs.add(blog);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public List<Blog> getLatestThreeBlogsByClub(int idClub) {
        List<Blog> blogs = new ArrayList<>();
        String sql = "SELECT * FROM blog WHERE IdClub = ? ORDER BY DateCreate DESC, IdBlog DESC LIMIT 3";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idClub); // Set the IdClub parameter
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setIdBlog(rs.getInt("IdBlog"));//
                blog.setTitleBlog(rs.getString("TittleBlog"));//
                blog.setImage(rs.getString("Image"));//
                blog.setDescription(rs.getString("Description"));//
                blog.setShow(rs.getInt("Show"));//
                blog.setStatus(rs.getInt("Status"));//
                blog.setIdClub(rs.getInt("IdClub"));//
                blog.setDateCreate(rs.getTimestamp("DateCreate"));//
                blog.setDateModify(rs.getTimestamp("DateModify"));//
                blogs.add(blog);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
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
