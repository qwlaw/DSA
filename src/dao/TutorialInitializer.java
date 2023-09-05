/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArrayQueueDSA;
import adt.QueueInterfaceDSA;
import entity.Tutorial;

/**
 *
 * @author Claude
 */
public class TutorialInitializer {

    public QueueInterfaceDSA<Tutorial> initializeTutorial() {
        QueueInterfaceDSA<Tutorial> tutorialDetails = new ArrayQueueDSA<>();
        tutorialDetails.enqueue(new Tutorial("RDS", 9001, "Tan Ah Good", "5", "Mathematics"));
        tutorialDetails.enqueue(new Tutorial("RSW", 9002, "Ong Ah Huat", "3", "Physics"));
        tutorialDetails.enqueue(new Tutorial("RAS", 9003, "Lim Ah Gao", "2", "Finance"));
        tutorialDetails.enqueue(new Tutorial("RIT", 9004, "Lim Xiao Mei", "6", "Business"));
        tutorialDetails.enqueue(new Tutorial("RWM", 9005, "Yong Ah Qing", "3", "English"));

        return tutorialDetails;
    }

    public static void main(String[] args) {
        var q = new TutorialInitializer();
        QueueInterfaceDSA<Tutorial> tutorialDetails = q.initializeTutorial();
        System.out.println("\nTutorial group:\n" + tutorialDetails);
    }
}
