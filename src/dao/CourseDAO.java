package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

public class CourseDAO {

    private Connection connection;

    public CourseDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> getAll() {

        List<Course> course = new ArrayList<>();

        try {
            String sql = "SELECT * FROM course";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("courseID");
                String code = rs.getString("code");
                String name = rs.getString("name");
                int sks = rs.getInt("SKS");
                int semester = rs.getInt("semester");
              course.add(new Course(code, code, name, sks, semester));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    public int create(Course course) {

        try {
            String sql = "INSERT INTO course(code, name, SKS, semester) VALUES(?,?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, String.valueOf(course.getSKS()));
            stmt.setString(4, String.valueOf(course.getsemester()));
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Course getByCode(String code){
    try{
        String sql = "SELECT * FROM course WHERE code=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, code);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            String nama = rs.getString("name");
            int sks = rs.getInt("sks");
            int semester = rs.getInt("semester");

            return new Course(code,code, nama, sks, semester);
        }

    }catch(SQLException e){
        e.printStackTrace();
    }
    return null;
    }
    
    public int update(Course course, String code) {

        try {

            String sql = "UPDATE course SET name=?, sks=?, semester=? WHERE Code=?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getSKS());
            stmt.setInt(3, course.getsemester());
            stmt.setString(4, code);
            stmt.executeUpdate();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int delete(String code) {

        try {

            String sql = "DELETE FROM course WHERE Code=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, code);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}