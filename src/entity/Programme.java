/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Claude
 */
public class Programme {

    private String progFaculty;
    private String progCode;
    private String progName;
    private int tutorialID;
    private int tutGrpCount;

    public int getTutorialID() {
        return tutorialID;
    }

    public void setTutorialID(int tutorialID) {
        this.tutorialID = tutorialID;
    }

    public int getTutGrpCount() {
        return tutGrpCount;
    }

    public void setTutGrpCount(int tutGrpCount) {
        this.tutGrpCount = tutGrpCount;
    }

    public Programme(String progFaculty, String progCode, String progName) {
        this.progFaculty = progFaculty;
        this.progCode = progCode;
        this.progName = progName;
        this.tutorialID = 0;
    }

    public Programme(String progFaculty, String progCode, String progName, int tutorialID) {
        this.progFaculty = progFaculty;
        this.progCode = progCode;
        this.progName = progName;
        this.tutorialID = tutorialID;
    }

    public Programme(String progCode) {
        this.progCode = progCode;
        this.tutGrpCount = 0; // Initialize tutorial group count to 0
    }

    public String getProgFaculty() {
        return progFaculty;
    }

    public void setProgFaculty(String progFaculty) {
        this.progFaculty = progFaculty;
    }

    public String getProgCode() {
        return progCode;
    }

    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    //check if user's input programme already exists in the system
    //compare programme type with another programme type
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Programme programme = (Programme) o;

        // For example, you might consider them equal if their progCode is the same.
        return progCode.equals(programme.progCode);
    }

    public void incrementTutGrpCount() {
        tutGrpCount++;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-35s", progFaculty, progCode, progName);
    }

}
