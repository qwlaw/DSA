/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Claude
 */
public class InputValidation {

    public static boolean alphabetValidation(String str) {
        //create a pattern object
        Pattern regexPattern = Pattern.compile("^[a-zA-Z]+$");
        //create a matcher object
        Matcher matcher = regexPattern.matcher(str);
        //check if the matcher matches the string
        return matcher.matches();
    }
    
     public static boolean numberValidation(String str) {
        //create a pattern object
        Pattern regexPattern = Pattern.compile("^[0-9]+$");
        //create a matcher object
        Matcher matcher = regexPattern.matcher(str);
        //check if the matcher matches the string
        return matcher.matches();
    }
    
}
