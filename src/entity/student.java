/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author claude
 */
import java.io.Serializable;

public class student implements Serializable{
    private String stuName;
    private int stuID;
    private String stuGender;
    private int stuAge;
    private String stuEmail;
    private String stuAddress;
    private int stuPostCode;
    
    public student(){
        stuName = null;
        stuID = 0;
        stuGender = null;
        stuAge = 0;
        stuEmail = null;
        stuAddress = null;
        stuPostCode = 0;
    }
    
    public student(int a_id){
        stuName = null;
        stuID = 0;
        stuGender = null;
        stuAge = 0;
        stuEmail = null;
        stuAddress = null;
        stuPostCode = 0;
    }
    
    public student(int studentID, String studentName, String studentGander, int studentAge, String studentEmail, String studentAddress, int studentPostCode){
        this.stuName = studentName;
        this.stuID = studentID;
        this.stuGender = studentGander;
        this.stuAge = studentAge;
        this.stuEmail = studentEmail;
        this.stuAddress = studentAddress;
        this.stuPostCode = studentPostCode;   
    }
     
    
    //     Setter
    public void setstuID(int studID){
        stuID = studID;
    }  
    public void setstuName(String studName){
        stuName = studName;
    }   

    public void setstuGender(String studGender){
        stuGender = studGender;
    }   
    public void setstuAge(int studAge ){
        stuAge = studAge;
    }   
    public void setstuEmail(String studEmail){
        stuEmail = studEmail;
    } 
    public void setstuAddress(String studAddress ){
        stuAddress = studAddress;
    }  
    public void setstuPostCode(int studPostCode ){
       stuPostCode = studPostCode;
    }
    
    //Getter
    public int getstuID(){
       return stuID;
    } 
    public String getstuName(){
        return stuName; 
    }   
    public String getstuGender(){
        return stuGender;
    }   
    public int getstuAge(){
        return stuAge;
    }   
    public String getstuEmail(){
        return stuEmail;
    } 
    public String getstuAddress(){
        return stuAddress;
    }  
    public int getsetPostCode(){
       return stuPostCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final student other = (student) obj;

        if (this.stuID != other.stuID) {
            return false;
        }

        return true;
    }
    
    @Override
    public String toString(){

        return "Student ID:"+stuID+", Student Name: "+stuName+", Gender: "
                +stuGender+", Age : "+stuAge+", Email ："+stuEmail
                +", Address : "+stuAddress+", Post Code "
                + "Quantity : "+stuPostCode;
    }
    
    
}
