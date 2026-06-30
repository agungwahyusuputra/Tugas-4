/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Henryy
 */
 public class Course {
     private String courseID;
    private String code;
    private String coursename;
    private int sks;
    private int semester;
    
    public Course(String courseID,
                  String code,
                  String courseName,
                  int sks,
                  int semester){
        this.courseID = courseID;
        this.code = code;
        this.coursename = courseName;
        this.sks = sks;
        this.semester = semester;
    }
    @Override
    public String toString(){
        return this.code;
    }
    public String getCode(){
        return code;
    }
    public String getCourseName(){
        return coursename;
    }
    public int getSKS(){
        return sks;
    }
    public  int getsemester(){
        return semester;
    }
}
