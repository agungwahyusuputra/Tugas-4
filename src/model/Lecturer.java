/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Person;



/**
 *
 * @author Henryy
 */
 public class Lecturer extends Person{
    private String nidn;
    private String Keahlian;
    
    public Lecturer(String IDDosen,
                    String name,
                    String nidn,
                    String Keahlian) {
        super(IDDosen, name);
        
        this.nidn = nidn;
        this.Keahlian = Keahlian;
    }
    public String toString() {
    return this.nidn;
}
     public String getnidn(){
        return nidn;
    }
    public String getName(){
        return name;
    }
    public String getKeahlian(){
        return Keahlian;
    }

public String getIDDosen() {
    return idCard; 
}
}
