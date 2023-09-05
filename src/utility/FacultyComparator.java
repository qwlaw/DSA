/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import entity.Programme;
import java.util.Comparator;

/**
 *
 * @author Claude
// */
public class FacultyComparator implements Comparator<Programme> {

    //custom comparison logic for sorting based programme name
    @Override
    public int compare(Programme p1, Programme p2) {
        
        //compares programme faculty in case-insensitive manner
        return p1.getProgFaculty().compareToIgnoreCase(p2.getProgFaculty());
    }
    
}
