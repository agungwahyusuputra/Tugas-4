/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;
import dao.StudentDAO;
/**
 *
 * @author Henryy
 */
public class StudentController {
    private StudentDAO studentDAO = new StudentDAO();
    
    public int create(Student student){
        return studentDAO.create(student);
    }
    public List<Student>getstudent(){
        return studentDAO.getStudents();
    }
    public int update(Student student, String nim){
        return studentDAO.update(student, nim);
    }
    public int delete(String nim){
        return studentDAO.delete(nim);
    }
       
}
