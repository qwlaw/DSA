/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Claude
 */
public class Faculty {
    private String progFaculty;
    private int progCount;
    
    public Faculty(String progFaculty){
        this.progFaculty = progFaculty;
        this.progCount = 1;
    }
    
    public Faculty(String progFaculty, int progCount){
        this.progFaculty = progFaculty;
        this.progCount = progCount;
    }

    public String getProgFaculty() {
        return progFaculty;
    }

    public void setProgFaculty(String progFaculty) {
        this.progFaculty = progFaculty;
    }

    public int getProgCount() {
        return progCount;
    }

    public void setProgCount(int progCount) {
        this.progCount = progCount;
    }
    
    public void incrementProgCount(){
        progCount++;
    }
    
}
