/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ArrayQueueDSA;
import adt.ListInterface;
import adt.QueueInterfaceDSA;
import dao.ProgrammeInitializer;
import entity.Programme;
import entity.Tutorial;
import entity.student;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Claude
 */
public class ManageTutor {

    ProgrammeInitializer dbP = new ProgrammeInitializer();
    private ListInterface<Programme> programmeList = dbP.initializeProgrammes();

    private QueueInterfaceDSA<Tutorial> tutorialDetails = new ArrayQueueDSA<>();
    private QueueInterfaceDSA<student> studentDetails = new ArrayQueueDSA<>();
    private Scanner input = new Scanner(System.in);

    public ManageTutor() {
//        createDb();
//        loadDb();

        if (tutorialDetails.getNumberOfEntries() == 0) {
            tutorialDetails.enqueue(new Tutorial("RDS", 9001, "Tan Ah Good", "5", "Mathematics"));
            tutorialDetails.enqueue(new Tutorial("RSW", 9002, "Ong Ah Huat", "3", "Physics"));
            tutorialDetails.enqueue(new Tutorial("RAS", 9003, "Lim Ah Gao", "2", "Finance"));
            tutorialDetails.enqueue(new Tutorial("RIT", 9004, "Lim Xiao Mei", "6", "Business"));
            tutorialDetails.enqueue(new Tutorial("RWM", 9005, "Yong Ah Qing", "3", "English"));
        }
        if (tutorialDetails.getNumberOfEntries() == 0) {
            studentDetails.enqueue(new student(001, "Ali", "Male", 20, "ali@gmail.com", "Setapak, Kuala Lumpur", 53300));
            studentDetails.enqueue(new student(002, "Abu", "Male", 21, "abu@gmail.com", "Setapak, Kuala Lumpur", 53300));
            studentDetails.enqueue(new student(003, "Ah Qiang", "Male", 25, "ahqiang@gmail.com", "Gombak, Kuala Lumpur", 53500));
            studentDetails.enqueue(new student(004, "Hailey", "Female", 20, "hailey@gmail.com", "Subang Jaya, Selangor", 78800));
        }
    }

    //Create database
    private void createDb() {
        try {
            File tutorialFile = new File("C:\\Users\\user\\Downloads\\Tutorial.txt");
            if (!tutorialFile.exists()) {
                tutorialFile.createNewFile();
            }

            File studentFile = new File("C:\\Users\\user\\Downloads\\student.txt");
            if (!studentFile.exists()) {
                studentFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //load data from database if have data 
    private void loadDb() {
        File[] files = new File("C:\\Users\\user\\Downloads\\assignmentDSAtxt").listFiles();
        for (File file : files) {
            if (file.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    switch (file.getName()) {
                        case "Tutorial.txt":
                            tutorialDetails = (ArrayQueueDSA<Tutorial>) ois.readObject();
                            break;
                        case "student.txt":
                            studentDetails = (ArrayQueueDSA<student>) ois.readObject();
                            break;
                        default:
                            System.out.println("Unknown file to load into arraylist " + file.getName());
                    }

                    ois.close();
                    System.out.println("The progress of the programs is loaded from the database.");
                } catch (EOFException e) {
                    // First time use this system
                    System.out.println("The database is empty");
                    System.out.println("Your progress will be stored in the database.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Store data after using the system
    public void storeDb() {
        File[] files = new File("C:\\Users\\user\\Downloads\\assignmentDSAtxt").listFiles();

        for (File file : files) {
            if (file.exists()) {
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    switch (file.getName()) {
                        case "Tutorial.txt":
                            oos.writeObject(tutorialDetails);
                            break;
                        case "student.txt":
                            oos.writeObject(studentDetails);
                            break;
                        default:
                            System.out.println("Unknown file stored in the database to be serialized: " + file.getName());
                    }
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Your progress has been stored in the database.");
    }

    //Queue without passing 
    public QueueInterfaceDSA<Tutorial> NewTutorialFromProgramme(QueueInterfaceDSA<Tutorial> tutorialGroup) {
        System.out.println("\n\n");
        System.out.println("---------------------------------");
        System.out.println("     ADD NEW Tutorial Group      ");
        System.out.println("---------------------------------");
        System.out.println("Please enter programme code: ");
        String progCode = input.nextLine();

        boolean progFound = false;

        //check if the programme of the tutorial group exist in the programme list
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme p = programmeList.getEntry(i);
            String programmeCode = p.getProgCode();
            // int tutGrpCount = p.getTutGrpCount();

            //if programme exist, proceed to get details for new tut grp .
            if (progCode.equalsIgnoreCase(programmeCode)) {
                progFound = true;
            }
        }

        if (progFound) {
            System.out.println("Please enter Tutorial ID (e.g. 9001): ");
            int tutorialID = input.nextInt();
            //Check event occur
            Tutorial tutorials = tutorialGroup.getEntry(new Tutorial(tutorialID));
            if (tutorials != null) {
                System.out.println("\n\n >>Tutorial Group ID had exist. Try again");

            } else {
                input.nextLine();//buffer
                System.out.println("Please enter Tutor Name: ");
                String TutorName = input.nextLine();
                System.out.println("Please enter student pax : ");
                String studentPax = input.nextLine();
                System.out.println("Type of subject : ");
                String subject = input.nextLine();
                System.out.println("---------------------------------");
                System.out.println("---------------------------------");
                tutorialGroup.enqueue(new Tutorial(progCode, tutorialID, TutorName, studentPax, subject));
            }
        } else {
            MessageUI.programmeNotFoundMsg();
        }

        return tutorialGroup;
    }

    //queue wihtout passing
    public void NewTutorial() {
        System.out.println("\n\n");
        System.out.println("---------------------------------");
        System.out.println("     ADD NEW Tutorial Group      ");
        System.out.println("---------------------------------");
        System.out.println("Please enter programme code: ");
        String progCode = input.nextLine();

        boolean progFound = false;

        //check if the programme of the tutorial group exist in the programme list
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme p = programmeList.getEntry(i);
            String programmeCode = p.getProgCode();
            // int tutGrpCount = p.getTutGrpCount();

            //if programme exist, proceed to get details for new tut grp .
            if (progCode.equalsIgnoreCase(programmeCode)) {
                progFound = true;
            }
        }

        if (progFound) {
            System.out.println("Please enter Tutorial ID: ");
            int tutorialID = input.nextInt();
            //Check event occur
            Tutorial tutorials = tutorialDetails.getEntry(new Tutorial(tutorialID));
            if (tutorials != null) {
                System.out.println("\n\n >>Tutorial Group ID had exist. Try again");

            } else {
                input.nextLine();//buffer
                System.out.println("Please enter Tutor Name: ");
                String TutorName = input.nextLine();
                System.out.println("Please enter student pax : ");
                String studentPax = input.nextLine();
                System.out.println("Type of subject : ");
                String subject = input.nextLine();
                System.out.println("---------------------------------");
                System.out.println("---------------------------------");
                tutorialDetails.enqueue(new Tutorial(progCode, tutorialID, TutorName, studentPax, subject));
            }
        } else {
            MessageUI.programmeNotFoundMsg();
        }

    }

    public void NewStudent() {
        System.out.println("---------------------------------");
        System.out.println("           ADD NEW STUDENT       ");
        System.out.println("---------------------------------");
        System.out.println("Enter Student ID : ");
        int a_id = input.nextInt();
        student students = studentDetails.getEntry(new student(a_id));
        if (students != null) {
            System.out.println("Student ID alrady exist try again.");

        } else {
            input.nextLine();//buffer
            System.out.println("Please enter Student name : ");
            String stuName = input.nextLine();
            System.out.println("Please enter Student Gender : ");
            String stuGender = input.nextLine();
            System.out.println("Please enter Age : ");
            int stuAge = input.nextInt();
            System.out.println("Please enter Email : ");
            String stuEmail = input.nextLine();
            System.out.println("Please enter Address : ");
            String stuAddress = input.nextLine();
            System.out.println("Please enter Post Code : ");
            int stuPostCode = input.nextInt();
            studentDetails.enqueue(new student(a_id));
            System.out.println("Student Added successfully");
        }
    }

    public void findTutorial() {
        System.out.println("---------------------------------");
        System.out.println("        FIND TUTORIAL GROUP      ");
        System.out.println("---------------------------------");
        System.out.println("Enter Tutorial Group : ");
        int id = input.nextInt();
        input.nextLine();//buffer
        Tutorial tutorials = tutorialDetails.getEntry(new Tutorial(id));
        if (tutorials != null) {
            System.out.println("Tutorial Group Info : \n" + tutorials);

        } else {
            System.out.println("Tutorial Group NOT FOUND !");
        }
    }

    public void addStudentToTutorial() {
        System.out.println("Please enter Student ID : ");
        int id_student = input.nextInt();
        student idstudent = studentDetails.getEntry(new student(id_student));
        if (idstudent == null) {
            System.out.println("No such student ID");
        } else {
            System.out.println("Enter the Tutorial Group ID to add the student : ");
            int e_id = input.nextInt();
            Tutorial tutorial2 = tutorialDetails.getEntry(new Tutorial(e_id));

            if (tutorial2 == null) {
                System.out.println("No such Tutorial Group. Student does not added succesfully");
            } else {
                tutorial2.addStudentToTutorial(idstudent);
                System.out.println("Student added succesfully");
            }
        }
    }

    public void showTutorial() {

        for (int i = 0; i < tutorialDetails.getNumberOfEntries(); i++) {
            System.out.println("Tutorial Group : " + tutorialDetails.getEntry(i + 1));
        }

    }

    public void showTutorialFromProgramme() {
          System.out.println("\nTutorial Group List:");
            System.out.println("====================\n");
            System.out.printf("%5s %-15s %-15s %-15s %-15s\n", "No.", "Programme Code", "Tutor Name", "Student Pax", "Subject");
            System.out.printf("%5s %-15s %-15s %-15s %-15s\n", "---", "--------------", "----------------", "----------------", "----------");
            
        for (int i = 0; i < tutorialDetails.getNumberOfEntries(); i++) {
            Tutorial t = tutorialDetails.getEntry(i + 1);
            //System.out.println("Tutorial Group : " + tutorialDetails.getEntry(i + 1));
            System.out.printf("%5d %-10s %-15s %-35s\n", i, t.getProgCode(), t.gettutorName(), t.getStudentPax(), t.getSubject());

        }

    }

    public void removeTutorial() {
        System.out.println("---------------------------------");
        System.out.println("      REMOVE TUTORIAL GROUP      ");
        System.out.println("---------------------------------");
        System.out.println("Do you want to remove lastest event?");
        System.out.println("         (1) Yes // (2) No          ");
        int choice = input.nextInt();

        if (choice == 1) {
            tutorialDetails.dequeue();
            System.out.println("You have successfull remove a Tutorial Group");
        } else {
            System.out.println("No Tutorial Group had been remove");
        }

    }

    public QueueInterfaceDSA<Tutorial> removeTutorialFromProgramme(QueueInterfaceDSA<Tutorial> tutorialGroup) {
        System.out.println("---------------------------------");
        System.out.println("      REMOVE TUTORIAL GROUP      ");
        System.out.println("---------------------------------");
        System.out.println("Do you want to remove lastest event?");
        System.out.println("         (1) Yes // (2) No          ");
        int choice = input.nextInt();

        if (choice == 1) {
            tutorialGroup.dequeue();
            System.out.println("You have successfull remove a Tutorial Group");
        } else {
            System.out.println("No Tutorial Group had been remove");
        }
        return tutorialGroup;
    }

}
