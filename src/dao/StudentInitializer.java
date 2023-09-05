///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package dao;
//
//import adt.ArrayList;
//import adt.ListInterface;
//import entity.Student;
//
///**
// *
// * @author Claude
// */
//public class StudentInitializer {
//
//    //create an array of Student objects for one tutorial group
//    public ListInterface<ListInterface<Student>> initializeMultipleTutGrpStuds() {
//        ListInterface<Student> tutGrpStud1 = new ArrayList<>();
//        tutGrpStud1.add(new Student("21WMR00221", "Lim Lai Lo"));
//        tutGrpStud1.add(new Student("20WMR36767", "Samantha"));
//
//        ListInterface<Student> tutGrpStud2 = new ArrayList<>();
//        tutGrpStud2.add(new Student("23WMR09856", "Abel"));
//        tutGrpStud2.add(new Student("21WMR23414", "Elma"));
//
//        ListInterface<Student> tutGrpStud3 = new ArrayList<>();
//        tutGrpStud3.add(new Student("23WMR34698", "Zoe"));
//        tutGrpStud3.add(new Student("23WMR34698", "David"));
//
//        ListInterface<ListInterface<Student>> allTutGrpStudent = new ArrayList();
//        allTutGrpStudent.add(tutGrpStud1);
//        allTutGrpStudent.add(tutGrpStud2);
//        allTutGrpStudent.add(tutGrpStud3);
//        
//        return allTutGrpStudent;
//    }
//    
//    public ListInterface<Student> initializeStudent(){
//        ListInterface<Student> tutGrpStud = new ArrayList<>();
//        tutGrpStud.add(new Student("21WMR00221", "Lim Lai Lo"));
//        tutGrpStud.add(new Student("20WMR36767", "Samantha"));
//        tutGrpStud.add(new Student("23WMR09856", "Abel"));
//        tutGrpStud.add(new Student("21WMR23414", "Elma"));
//        tutGrpStud.add(new Student("21WMR45645", "William"));
//        tutGrpStud.add(new Student("21WMR56098", "Zoe"));
//        tutGrpStud.add(new Student("21WMR45068", "Wilson"));
//        
//        return tutGrpStud;
//    }
//
//    public static void main(String[] args) {
//
//        StudentInitializer stud = new StudentInitializer();
//       // ListInterface<ListInterface<Student>> allTutGrpStudent = stud.initializeStudent();
//        ListInterface<Student> tutGrpStudent = stud.initializeStudent();
//        System.out.println(tutGrpStudent);
//    }
//}
