/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author Claude
 */
public class MainMenuUI {
    Scanner scanner = new Scanner(System.in);
     
    public int mainMenu(){
        int choice;
        System.out.println("\n\nMain Menu");
        System.out.println("=========");
        System.out.println("1. Programme Management");
        System.out.println("2. Tutorial Management");
        System.out.println("3. Course Management");
        System.out.print("Please enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    
}
