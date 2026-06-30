/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Course;
import model.Lecturer;


/**
 *
 * @author Henryy
 */
public class KRS {

    
    private Course Course;
    private double score;
    private String grade;
    private Lecturer lecturer;
    private int semester;
    private Student student;
    public Object getsemester;
    
    public KRS(Course Course, double score, String grade, Lecturer lecturer, int semester, Student student){
        
        this.Course = Course;
        this.score = score;
        this.grade = setGrade();
        this.lecturer = lecturer;
        this.semester = semester;
        this.student = student;
    }

    
     public void setLecturer(Lecturer lecturer){
         this.lecturer = lecturer;
     }
     public void setSemester(int semester){
         this.semester = semester;
     }
     public int getsemester(){
         return semester;
     }
     public Lecturer getLecturer(){
         return lecturer;
     }
     public Student getstudent(){
         return student;
     }
    public Course getcourse(){
        return Course;
    }
    public double getScore(){
        return score;
    }
    public String getGrade(){
        return grade;
    }
    private String setGrade() {
       if(score >= 85)
           return "A";
       else if(score >= 75)
           return "B";
       else if(score >= 60)
           return "C";
       else 
           return "D";
    }
    
}
