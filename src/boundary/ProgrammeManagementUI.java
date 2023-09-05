/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.ProgrammeManagement;
import entity.Programme;
import entity.Tutorial;
import java.util.Scanner;
import utility.InputValidation;
import utility.MessageUI;

/**
 *
 * @author Claude
 */
public class ProgrammeManagementUI {

   // ProgrammeManagement programmeManagement = new ProgrammeManagement();
    Scanner scanner = new Scanner(System.in);

    public int menu() {
        int choice;
        System.out.println("\n\nProgramme Management Menu");
        System.out.println("=========================");
        System.out.println("1. Add Programme");
        System.out.println("2. Display all Programme");
        System.out.println("3. Update Programme Details");
        System.out.println("4. Remove Programme");
        System.out.println("5. Search a Programme");
        System.out.println("6. Sort Programmes based on Faculty"); //can use to show tutorail grp number
        System.out.println("7. Add a Tutorial Group to a Programme");
        System.out.println("8. Remove a Tutorial Group to a Programme");
        System.out.println("9. Display all Tutorial Group for a Programme");
        System.out.println("10. Report 1: Total Number of Programmes for Each Faculty");
        System.out.println("11. Report 2: Total Number of Tutorial Groups for Each Programme");
        System.out.println("0. Exit");
        System.out.print("Please enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        String s = Integer.toString(choice);
        //ProgrammeManagement.validateNumber(s);
        return choice;
    }

    public void listProgrammes(String outputStr) {
        System.out.println("\nProgramme List:");
        System.out.println("=================\n");
        System.out.printf("%5s %-10s %-15s %-35s\n", "No.", "Faculty", "Programme Code", "Programme Name");
        System.out.printf("%5s %-10s %-15s %-35s\n", "---", "-------", "--------------", "----------------------------");
        System.out.println(outputStr);
    }

//    public void listTutorialGroups(String outputStr) {
//        System.out.println("\nTutorial Group List:");
//            System.out.println("====================\n");
//            System.out.printf("%5s %-15s %-15s %-15s %-15s\n", "No.", "Programme Code", "Tutor Name", "Student Pax", "Subject");
//            System.out.printf("%5s %-15s %-15s %-15s %-15s\n", "---", "--------------", "----------------", "----------------", "----------");
//        System.out.println(outputStr);
//    }
    public void printProgrammeDetails(Programme programme) {
        System.out.println("\n\nProgramme Details");
        System.out.println("-----------------");
        System.out.println("Faculty:" + programme.getProgFaculty());
        System.out.println("Programme Code:" + programme.getProgCode());
        System.out.println("Programme Name: " + programme.getProgName());
    }

//        public void printTutorialGroupDetails(TutorialGroup tutorial) {
//        System.out.println("\n\nTutorial Group Details");
//        System.out.println("-----------------------");
//        System.out.println("Group Number:" + tutorial.getTutGrpNo());
//        System.out.println("Students:\n" + tutorial.getStudent());
//    }
    public Programme inputProgrammeDetails() {

        String progFaculty = programmeFacultyInput();
        String progCode = programmeCodeInput();
        String progName = programmeNameInput();

//        int quantity = inputQuantity();
        System.out.println();
        return new Programme(progFaculty, progCode, progName);
    }

    public String programmeFacultyInput() {
        System.out.print("Enter faculty (e.g. FOCS): ");
        String faculty = scanner.nextLine();
        InputValidation.alphabetValidation(faculty);
        return faculty;
    }

    public String programmeCodeInput() {
        System.out.print("Enter programme code (e.g. RDS): ");
        String code = scanner.nextLine();
        InputValidation.alphabetValidation(code);
        return code;
    }

    public String programmeNameInput() {
        System.out.print("Enter programme name: ");
        String name = scanner.nextLine();
        InputValidation.alphabetValidation(name);
        return name;
    }

    public int programmeIndexInput() {
        System.out.print("Enter No. of the programme: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        String indexString = Integer.toString(index);
        InputValidation.numberValidation(indexString);
        
        return index;
    }

//    public TutorialGroup inputTutorialGroupDetails() {
//
//        //get tutorial grp input
//     String progCode = programmeCodeInput();
//     int tutGrpNo = tutGrpNoInput();
//     
//     System.out.println();
//     return new TutorialGroup(progCode, tutGrpNo);
//    }
    public int tutGrpNoInput() {
        System.out.print("Enter No. of the Tutorial Group: ");
        int tutGroupNo = scanner.nextInt();
        scanner.nextLine();
        return tutGroupNo;
    }

    //Headers
    public void addProgrammeHeader() {
        System.out.print("\n\nAdd Programme\n");
        System.out.println("===============");
    }

    public void removeProgrammeHeader() {
        System.out.print("\n\nRemove Programme\n");
        System.out.println("==================");
    }

    public void updateProgrammeHeader() {
        System.out.print("\n\nUpdate Programme Details\n");
        System.out.println("========================");
    }

    public void searchProgrammeHeader() {
        System.out.print("\n\nSearch a Programme\n");
        System.out.println("====================");
    }

    public void ProgrammeHeader() {
        System.out.print("\n\n Add a Tutorial Group to a Programme\n");
        System.out.println("==================================");
    }

    public void totalNoOfProgReportHeader() {

        System.out.println("\n\nTotal Number of Programme for Each Faculty Report(Highest to Lowest)");
        System.out.println("======================================================================\n");
        System.out.printf("%5s %-10s %-15s\n", "No.", "Faculty", "Total No. of Programmes");
        System.out.printf("%5s %-10s %-15s\n", "---", "-------", "-----------------------");
    }

    public void totalNoOfTutorialGrpReportHeader() {

        System.out.println("\n\nTotal Number of Tutorial Group for Each Programme Report(Highest to Lowest)");
        System.out.println("======================================================================\n");
        System.out.printf("%5s %-10s %-20s\n", "No.", "Programme", "Total No. of Tutorial Groups");
        System.out.printf("%5s %-10s %-20s\n", "---", "---------", "----------------------------");
    }
//    public String printTotalNoOfProgReport(Faculty faculty){
//       string output = System.out.printf("%5s %-10s %-15s\n", "", faculty.getProgFaculty(), faculty.getProgCount());
//    }

    public void addTutGrpToProgrammeHeader() {
        System.out.print("\n\nAdd Tutorial Group To Programme\n");
        System.out.println("=================================");
    }

    public void displayTutorialGroupHeader() {
        System.out.print("\n\nDisplay Tutorial Group for a Programme\n");
        System.out.println("========================================");
    }

    public void listTutorialGroupHeader() {
        System.out.println("\n\nTutorial Group List:");
        System.out.println("---------------------\n");
        System.out.printf("%-12s %-15s %-12s %-15s\n", "Tutorial ID", "Tutor Name", "Student Pax", "Subject");
        System.out.printf("%-12s %-15s %-12s %-15s\n", "-----------", "--------------", "-----------", "--------------");
    }

    public void listTutorialGroupContent(Tutorial t) {
        System.out.printf("%-12d %-15s %-12s %-15s\n", t.getTutorialID(), t.gettutorName(), t.getStudentPax(), t.getSubject());
    }

   
}
