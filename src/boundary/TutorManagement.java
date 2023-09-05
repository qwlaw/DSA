/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.ManageTutor;
import java.util.Scanner;

/**
 *
 * @author Claude
 */
public class TutorManagement {
     Scanner input = new Scanner(System.in);
    ManageTutor me = new ManageTutor();

    public void menu() {
        int user_choice = 0;
        do {
            System.out.println("**********************************");
            System.out.println("(1) Add new Tutorial Group");
            System.out.println("(2) Add new student");
            System.out.println("(3) Add student to Tutorial Group");
            System.out.println("(4) Search Tutorial Group");
            System.out.println("(5) Display All Tutorial Group");
            System.out.println("(6) Remove Tutorial Group");
            System.out.println("Press 0 to exit.");
            System.out.println("**********************************");
            System.out.print("Enter your choice:");
            user_choice = input.nextInt();

            switch (user_choice) {
                case 1:
                    me.NewTutorial();
                    break;
                case 2:
                    me.NewStudent();
                    break;
                case 3:
                    me.addStudentToTutorial();
                    break;
                case 4:
                    me.findTutorial();
                    break;
                case 5:
                    me.showTutorial();
                    break;
                case 6:
                    me.removeTutorial();
                    break;
                case 0:
                    me.storeDb();
                    break;
                default:
                    System.out.println("Good Bye");
            }
        } while (user_choice != 0);
    }
//
//    public static void main(String[] args) {
//        new TutorManagement().menu();
//    }
}
