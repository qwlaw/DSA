/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayQueueDSA;
import adt.QueueInterfaceDSA;
/**
 *
 * @author Claude
 */


public class Tutorial implements java.io.Serializable {
//attributes
    private String progCode;
    private int tutorialID;
    private String tutorName;
    private String studentPax;
    private String subject;

    //one event consists of many assests
    private QueueInterfaceDSA<student> tutorialStudent;

 
    public Tutorial(String progCode, int tutorialID, String tutorName, String studentPax, String subject) {
        this.progCode = progCode;
        this.tutorialID = tutorialID;
        this.tutorName = tutorName;
        this.studentPax = studentPax;
        this.subject = subject;
        this.tutorialStudent = new ArrayQueueDSA<>();
    }

    public Tutorial(int tutorialID) {
        this.tutorialID = tutorialID;
        this.tutorialStudent = new ArrayQueueDSA<>();
    }

    public Tutorial(int tutorialID, String tutorName, String studentPax, String subject,
            QueueInterfaceDSA<student> sTudent) {
        this.tutorialID = tutorialID;
        this.tutorName = tutorName;
        this.studentPax = studentPax;
        this.subject = subject;
        this.tutorialStudent = sTudent;
    }

    public void setAllStudent(QueueInterfaceDSA<student> sTudent) {
        this.tutorialStudent = sTudent;
    }

    public void setID(int tutorialID) {
        this.tutorialID = tutorialID;
    }

    public void settutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public void setStudentPax(String studentPax) {
        this.studentPax = studentPax;
    }

    public int getID() {
        return tutorialID;
    }

    public String gettutorName() {
        return tutorName;
    }

    public String getStudentPax() {
        return studentPax;
    }

    public QueueInterfaceDSA<student> getAllStudent() {
        return tutorialStudent;
    }

    public void addStudentToTutorial(student a) {
        tutorialStudent.enqueue(a);
    }

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

        final Tutorial other = (Tutorial) obj;

        return this.tutorialID == other.tutorialID;
    }

    public String getProgCode() {
        return progCode;
    }

    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }
    
       public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTutorialID() {
        return tutorialID;
    }

    public void setTutorialID(int tutorialID) {
        this.tutorialID = tutorialID;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public QueueInterfaceDSA<student> getTutorialStudent() {
        return tutorialStudent;
    }

    public void setTutorialStudent(QueueInterfaceDSA<student> tutorialStudent) {
        this.tutorialStudent = tutorialStudent;
    }


    @Override
    public String toString() {
        String all = "\nProgramme Code: " + progCode + "\nTutorial ID : " + tutorialID + "\nTutor Name : " + tutorName + "\nStudent Pax : " + studentPax + "\nSubject : "
                + subject + "\n";

        return all;
    }
}

