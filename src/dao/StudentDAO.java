/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.DBConnection;
/**
 *
 * @author Henryy
 */
public class StudentDAO {
    private Connection connection;
    public StudentDAO(){
        try{
            connection = DBConnection.getConnection();
        }catch (SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public int create(Student student){
        try{
            String sql = "INSERT INTO students(cardID, NIM, name, studyProgram)VALUES(?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getstudyProgram());
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            return 0;
        }    
    }
    public List<Student>getStudents(){
        List<Student>students = new ArrayList<>();
        try{
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("studentID");
                String cardID  = rs.getString("cardID");
                String NIM  = rs.getString("NIM");
                String name  = rs.getString("name");
                String studyProgram  = rs.getString("studyProgram");
                
                students.add(new Student(cardID,name,NIM,studyProgram));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    public int update(Student student, String nim){
        try{
            String sql = "UPDATE students SET cardID=?, name=?, studyProgram=? WHERE NIM=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getstudyProgram());
            stmt.setString(4, nim);
            stmt.executeUpdate();
             return 1;
        }catch(SQLException e){
             e.printStackTrace();
        return 0;
        }
    }
    public Student getByNim(String nim){
    try{
        String sql = "SELECT * FROM students WHERE NIM=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nim);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            String idcard = rs.getString("cardID");
            String nama = rs.getString("name");
            String studyProgram = rs.getString("studyProgram");

            return new Student(idcard, nama, nim, studyProgram);
        }

    }catch(SQLException e){
        e.printStackTrace();
    }
    return null;
    }
    public int delete(String nim){
        try{
            String sql= "DELETE FROM students WHERE NIM=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            return 0;
        }
    }
}