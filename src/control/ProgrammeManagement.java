/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import utility.FacultyComparator;
import adt.ArrayList;
import adt.ListInterface;
import adt.QueueInterfaceDSA;
import boundary.ProgrammeManagementUI;
import dao.ProgrammeInitializer;
import dao.TutorialInitializer;
import entity.Faculty;
import entity.Programme;
import entity.Tutorial;
import java.util.Comparator;
import utility.InputValidation;
import utility.MessageUI;

/**
 *
 * @author Claude
 */
public class ProgrammeManagement {

    //programme 
    //(unsorted)
    ProgrammeInitializer dbP = new ProgrammeInitializer();
    private ListInterface<Programme> programmeList = dbP.initializeProgrammes();

    //tutorial
    TutorialInitializer dbT = new TutorialInitializer();
    private QueueInterfaceDSA<Tutorial> tutorialDetails = dbT.initializeTutorial();
    ManageTutor tutor = new ManageTutor();

    //faculty
    private ListInterface<Faculty> facultyList = new ArrayList<>();

    //UI
    private final ProgrammeManagementUI progUI = new ProgrammeManagementUI();
    
    

    public void menu() {
        int choice;
        do {
            choice = progUI.menu();
            switch (choice) {
                case 0:
                    MessageUI.exitMessage();
                    break;
                case 1:
                    addProgramme();
                    //displayProgramme();
                    break;
                case 2:
                    displayProgramme();
                    break;
                case 3:
                    updateProgramme();
                    //displayProgramme();
                    break;
                case 4:
                    removeProgramme();
                    //displayProgramme();
                    break;
                case 5:
                    searchProgramme();
                    break;
                case 6:
                    sortProgramme();
                    break;
                case 7:
                    addTutorialGrp();
                    break;
                case 8:
                    removeTutorialGrp();
                    break;
                case 9:
                    displayTutorialGrpList();
                    break;
                case 10:
                    ttlNoOfProgReport();
                    break;
                case 11:
                    ttlNoOfTutGrpReport();
                    break;
                default:
                    MessageUI.exitProgrammeMenuMsg();
                //System.out.print("Exiting Programme Menu");
            }
        } while (choice != 0);
    }

    //output format
    public void displayProgramme() {
        // programmeList.bubbleSort(Programme);
        progUI.listProgrammes(getAllProgrammes());

    }

    public String getAllProgrammes() {
        String outputStr = "";

        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            outputStr = outputStr + "   " + i + "  " + programmeList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    private String getSortedProgrammes(ListInterface<Programme> sortedList) {
        String outputStr = "";

        for (int i = 1; i <= sortedList.getNumberOfEntries(); i++) {
            outputStr = outputStr + "   " + i + "  " + sortedList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    //functions (programmes)
    public void addProgramme() {
        progUI.addProgrammeHeader();
        Programme newProg = progUI.inputProgrammeDetails();

        //if programme already exist (false), display error msg
        if (programmeList.contains(newProg)) {
            MessageUI.programmeExistMsg();
        } else {
            programmeList.add(newProg);
            MessageUI.programmeAddedMsg();
            displayProgramme();
        }
    }

    public void updateProgramme() {
        displayProgramme();
        progUI.updateProgrammeHeader();
        int progNumber = progUI.programmeIndexInput();

        Programme updatedProg = progUI.inputProgrammeDetails();

        if (programmeList.contains(updatedProg)) {
            MessageUI.programmeExistMsg();
        } else {
            programmeList.replace(progNumber, updatedProg);
            MessageUI.programmeUpdatedMsg();
        }
    }

    public void removeProgramme() {
        displayProgramme();
        progUI.removeProgrammeHeader();
        int progNumber = progUI.programmeIndexInput();
        programmeList.remove(progNumber);
    }

    public void searchProgramme() {
//        displayProgramme();
        progUI.searchProgrammeHeader();
        //get user input (programme code)
        String progCode = progUI.programmeCodeInput();

        //find for the entire item using programme code
        for (int i = 1; i < programmeList.size(); i++) {
            Programme programme = programmeList.getEntry(i);
            if (programme.getProgCode().equalsIgnoreCase(progCode)) {
                progUI.printProgrammeDetails(programme);
            }
        }
    }

    public void sortProgramme() {
        //sorted
        ListInterface<Programme> sortedList = sortByProgFaculty();
        progUI.listProgrammes(getSortedProgrammes(sortedList));

    }

    public ListInterface<Programme> sortByProgFaculty() {
        Comparator<Programme> progFacultyComparator = new FacultyComparator();
        // Create a copy of the original list
        ListInterface<Programme> copyList = new ArrayList<>();
        for (int i = 1; i <= programmeList.size(); i++) {
            copyList.add(programmeList.getEntry(i));
        }

        // Sort the copy using mergeSort
        copyList.mergeSort(progFacultyComparator);

        return copyList; // Return the sorted result
    }

    public void addTutorialGrp() {

        //call add tutorial group method from Tutorial Management System
        tutor.NewTutorialFromProgramme(tutorialDetails);
        //QueueInterfaceDSA<Tutorial> t = tutor.NewTutorialFromProgramme(tutorialDetails);

    }

    public void removeTutorialGrp() {
        tutor.removeTutorialFromProgramme(tutorialDetails);
    }

    public void displayTutorialGrpList() {
        progUI.displayTutorialGroupHeader();

        //get programme of tutorial group that user desires
        String tutGrpProgCode = progUI.programmeCodeInput();

        boolean progFound = false;

        //check if the programme of the tutorial group exist in the programme list
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme p = programmeList.getEntry(i);
            String progCode = p.getProgCode();

            //if programme exist, then its is true
            if (tutGrpProgCode.equalsIgnoreCase(progCode)) {
                progFound = true;
            }
        }

        //if programme exist, check for the tutorial group in the programme
        if (progFound) {
            progUI.listTutorialGroupHeader();
            for (int j = 0; j < tutorialDetails.getNumberOfEntries(); j++) {
                if (tutGrpProgCode.equalsIgnoreCase(tutorialDetails.getEntry(j + 1).getProgCode())) {
                    Tutorial t = tutorialDetails.getEntry(j + 1);
                    progUI.listTutorialGroupContent(t);

                }
            }
        } else {
            MessageUI.programmeNotFoundMsg();
        }

    }

    public void ttlNoOfProgReport() {
        //clear facultyList before generate report, so that the count is accurate
        facultyList.clear();

        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme programme = programmeList.getEntry(i);
            String progFacultyCode = programme.getProgFaculty();
            boolean facultyExist = false;

            //compare if the faculty alrdy exist, increment programme count
            for (int j = 1; j <= facultyList.getNumberOfEntries(); j++) {
                Faculty faculty = facultyList.getEntry(j);
                if (faculty.getProgFaculty().equals(progFacultyCode)) {
                    faculty.incrementProgCount();
                    facultyExist = true;
                    break;
                }
            }

            //if faculty doesnt exist, create new instance of faculty 
            if (!facultyExist) {
                Faculty newFaculty = new Faculty(progFacultyCode);
                facultyList.add(newFaculty);
            }
        }

        //generate report
        progUI.totalNoOfProgReportHeader();
        for (int i = 1; i <= facultyList.getNumberOfEntries(); i++) {
            Faculty faculty = facultyList.getEntry(i);
            //System.out.println("Faculty: " + faculty.getProgFaculty() + ", Total no. of Programs: " + faculty.getProgCount());
            System.out.printf("%5d %-10s %-15s\n", i, faculty.getProgFaculty(), faculty.getProgCount());
            //System.out.printf( "%-5d %s",i , progUI.printTotalNoOfProgReport(faculty));
        }

    }

    public void ttlNoOfTutGrpReport() {
        //programmeList.clear();

        //check if programme exist
        for (int i = 1; i <= tutorialDetails.getNumberOfEntries(); i++) {
            Tutorial t = tutorialDetails.getEntry(i);
            String tutGrpProgCode = t.getProgCode();
            // boolean tutGrpIdExist = false;

            //compare if the tutorialID alrdy exist. if yes, increment tutorial grp count
            for (int j = 1; j <= programmeList.getNumberOfEntries(); j++) {
                Programme p = programmeList.getEntry(j);
                if (p.getProgCode().equals(tutGrpProgCode)) {
                    p.incrementTutGrpCount();
                    // tutGrpIdExist= true;
                    //break;
                }
            }
        }
        //generate report
        progUI.totalNoOfTutorialGrpReportHeader();
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            System.out.printf("%5d %-10s %-20s\n", i, programmeList.getEntry(i).getProgCode(), programmeList.getEntry(i).getTutGrpCount());
            //System.out.printf( "%-5d %s",i , progUI.printTotalNoOfProgReport(faculty));
        }
    }
    
     public static void validateNumber(String s){
        if (!InputValidation.numberValidation(s))
            MessageUI.invalidNumberInputMessage();
    }
     
      public static void validateAlphabet(String s){
        if (!InputValidation.alphabetValidation(s))
            MessageUI.invalidAlphabetInputMessage();
    }

    public static void main(String[] args) {
        ProgrammeManagement progManagement = new ProgrammeManagement();
        progManagement.menu();

    }
}
//if not exist
//}

