/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import dao.CourseDAO;
import java.util.List;
import model.Course;
/**
 *
 * @author Henryy
 */
public class CourseController {
    private CourseDAO courseDAO = new CourseDAO();
    public List<Course>getAll(){
        return courseDAO.getAll();
    }
     public int create(Course course) {
        return courseDAO.create(course);
     }
     public int update(Course course, String selectedcode){
        return courseDAO.update(course, selectedcode);
    }
     public int delete(String code){
    return courseDAO.delete(code);
    }
}
