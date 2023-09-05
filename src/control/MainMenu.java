///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package control;
//
//import boundary.MainMenuUI;
//import utility.MessageUI;
//
///**
// *
// * @author Claude
// */
//public class MainMenu {
//
//    ProgrammeManagement programmeManagement = new ProgrammeManagement();
//    TutorManagement tutorManagement = new TutorManagement();
//    MainMenuUI mainMenuUi = new MainMenuUI();
//
//    public void menu() {
//        int choice;
//        do {
//            choice = mainMenuUi.maixnMenu();
//            switch (choice) {
//                case 0:
//                    MessageUI.exitMessage();
//                    break;
//                case 1:
//                    programmeManagement.menu();
//                    break;
//                case 2:
//                    tutorManagement.menu();
//                    break;
//                case 3:
//                    //updateProgramme();
//                    //displayProgramme();
//                    break;
//                default:
//                    System.out.print("Exit program");
//            }
//        } while (choice != 0);
//    }
//    
//    
//    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.menu();
//       
//    }
//
//}
//
//
