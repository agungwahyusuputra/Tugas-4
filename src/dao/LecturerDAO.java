/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Lecturer;
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
public class LecturerDAO {
    private Connection connection;
    public LecturerDAO(){
        try{
            connection = DBConnection.getConnection();
        }catch (SQLException ex){
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public int create(Lecturer lecturer){
        try{
            String sql = "INSERT INTO Lecturer(IDDosen, nidn, name, Keahlian)VALUES(?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getIDDosen());
            stmt.setString(2, lecturer.getnidn());
            stmt.setString(3, lecturer.getName());
            stmt.setString(4, lecturer.getKeahlian());
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            return 0;
        }    
    }
    public Lecturer getByNidn(String nidn){
    try{
        String sql = "SELECT * FROM lecturer WHERE nidn=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nidn);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            String IDDosen = rs.getString("IDDosen");
            String nama = rs.getString("name");
            String Keahlian = rs.getString("keahlian");

            return new Lecturer(IDDosen, nama, nidn, Keahlian);
        }

    }catch(SQLException e){
        e.printStackTrace();
    }

    return null;
}
    public List<Lecturer>getLecturer(){
        List<Lecturer>lecturer = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Lecturer";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String IDDosen  = rs.getString("IDDosen");
                String nidn  = rs.getString("nidn");
                String name  = rs.getString("name");
                String Keahlian  = rs.getString("Keahlian");
                
               lecturer.add(new Lecturer(IDDosen, name, nidn, Keahlian));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lecturer;
    }
    public int update(Lecturer lecturer, String nidn){
        try{
            String sql = "UPDATE Lecturer SET IDDosen=?, name=?, Keahlian=? WHERE nidn=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getIDDosen());
            stmt.setString(2, lecturer.getName());
            stmt.setString(3, lecturer.getKeahlian());
            stmt.setString(4, nidn);
            stmt.executeUpdate();
             return 1;
        }catch(SQLException e){
             e.printStackTrace();
        return 0;
        }
}
    public int delete(String nidn){
        try{
            String sql= "DELETE FROM Lecturer WHERE nidn=?";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, nidn);
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            return 0;
        }
}   
}
