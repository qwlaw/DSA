/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Claude
 */
public class MessageUI {

    public static void invalidChoiceMessage() {
        System.out.println("\n>> Invalid choice");
        System.out.println(">> Please try again.. ");    
    }

    public static void exitMessage() {
        System.out.println("\n>> Exiting system..");
    }
    
     public static void invalidInputMessage() {
        System.out.println("\n>> Input is invalid..");
        System.out.println("Please try again.. ");    
    }
     
     public static void invalidNumberInputMessage() {
        System.out.println("\n>> Input is invalid. Expecting input integer type !");
        System.out.println("Please try again.. ");    
    }
     
     public static void invalidAlphabetInputMessage() {
        System.out.println("\n>> Input is invalid. Expecting input integer type !");
        System.out.println("Please try again.. ");    
    }

    //Add Prog
     public static void programmeExistMsg() {
        System.out.println(">> This programme already exists in system !");
        System.out.println(">> Please try again.. ");    
    }
     
     public static void programmeAddedMsg() {
        System.out.println(">> Programme Added Successfully !");
    }
     
     //Update Prog
       public static void programmeUpdatedMsg() {
        System.out.println(">> Programme Updated Successfully !");
    }
       
    public static void tutGrpNotFoundMsg() {
        System.out.println(">> This tutorial group does not exist in system yet !");
        System.out.println(">> Please try again.. ");
    }

    public static void programmeNotFoundMsg() {
        System.out.println("\n\n>> This programme does not exist in system !");
        System.out.println(">> Please add this programme before adding tutorial group...");
    }
    
    //exit
    public static void exitProgrammeMenuMsg() {
        System.out.println(">> Exiting Programme Management Menu..");
    }
    

}
