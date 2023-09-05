/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArrayList;
import adt.ListInterface;
import entity.Programme;

/**
 *
 * @author Claude
 */
public class ProgrammeInitializer {
    //  Method to return a collection of with hard-coded entity values
  public ListInterface<Programme> initializeProgrammes() {
    ListInterface<Programme> programmeList = new ArrayList<>();
    programmeList.add(new Programme("FOCS", "RDS", "Bachelor in Data Science"));
    programmeList.add(new Programme("FOCS", "RSW", "Bachelor in Software Engineering"));
    programmeList.add(new Programme("FAFB", "RAS", "Bachelor in Accountancy"));
    programmeList.add(new Programme("FOCS", "RIT", "Bachelor in Information Technology"));
    programmeList.add(new Programme("FAFB", "RWM", "Bachelor in Finance"));
    programmeList.add(new Programme("FCCI", "RMM", "Bachelor in Multimedia"));


    return programmeList;
  }

  public static void main(String[] args) {
    var p = new ProgrammeInitializer();
    ListInterface<Programme> programme = p.initializeProgrammes();
    System.out.println("\nProgramme:\n" + programme);
  }
}
