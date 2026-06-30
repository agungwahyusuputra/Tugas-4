/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.KRS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.DBConnection;
import model.Course;
import model.Student;
import model.Lecturer;
/**
 *
 * @author Henryy
 */
public class KRSDAO {
    private Connection connection;
    public KRSDAO(){
        try{
            connection = DBConnection.getConnection();
        }catch (SQLException ex){
            Logger.getLogger(KRSDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public int create(KRS krs){
        try{
            String sql = "INSERT INTO krs(code, nim, nidn,semester,score,grade)VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, krs.getcourse().getCode());
            stmt.setString(2, krs.getstudent().getNim());
            stmt.setString(3, krs.getLecturer().getnidn());
            stmt.setInt(4, krs.getsemester());
            stmt.setDouble(5, krs.getScore());
            stmt.setString(6, krs.getGrade());
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
            
        }    
    }
    public List<KRS>getKRS(){
        List<KRS>listkrs= new ArrayList<>();
        
        CourseDAO courseDAO = new CourseDAO();
        StudentDAO studentDAO = new StudentDAO();
        LecturerDAO lecturerDAO = new LecturerDAO();
        
        try{
            String sql = "SELECT * FROM krs";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String code  = rs.getString("code");
                String nim  = rs.getString("nim");
                String nidn  = rs.getString("nidn");
                
                int semester = rs.getInt("semester");
                double score = rs.getDouble("score");
                String grade = rs.getString("grade");
                
                Course course = courseDAO.getByCode(code);
                Student student = studentDAO.getByNim(nim);
                Lecturer lecturer = lecturerDAO.getByNidn(nidn);
                 
               KRS krs = new KRS(course, score, grade, lecturer, semester, student);
               listkrs.add(krs);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listkrs;
    }
    public int update(KRS krs, String nim){
        try{
            String sql = "UPDATE krs SET code=?, nidn=?, semester=?,  score=?, grade=?, WHERE nim=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, krs.getcourse().getCode());
            stmt.setString(2, krs.getLecturer().getnidn());
            stmt.setString(3, String.valueOf(krs.getsemester()));
            stmt.setString(4, String.valueOf(krs.getScore()));
            stmt.setString(5, krs.getGrade());
            return 1;
        }catch(SQLException e){
             e.printStackTrace();
             
        return 0;
        
        }
}
    public int delete(String nim){
        try{
            String sql= "DELETE FROM krs WHERE nim=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            return 0;
        }
}   
}
