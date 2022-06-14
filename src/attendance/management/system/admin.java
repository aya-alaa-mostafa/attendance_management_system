/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ok
 */
public class admin extends person implements Serializable {

    public admin() {

    }

    public admin(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);
    }

    public void addNewStudent(String user, String pass, int id, String fname, String lname, int age, int level, double GPA,boolean fe,ArrayList<course> courses) {
        student x = new student(user, pass, id, fname, lname, age, level, GPA,fe,courses);
        if (x.addStudent()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayStudents() {
        student x = new student();
        System.out.println(x.displayAllStudents());
    }

    public void searchForStudent(int id) {
        student x = new student();
        System.out.println(x.searchStudent(id));
    }

     public void updateStudent(int oldID,int n_id,String n_username,String n_pass,String n_fname,String n_lname,int n_age,int n_level,double gpa) {
        student x = new student();
        if (x.updateStudent(oldID,n_id, n_username,n_pass, n_fname, n_lname, n_age, n_level, gpa)) {
            System.out.println("Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteStudent(int Id) {
        student x = new student();
        if (x.deleteStudent(Id)) {
           System.out.println("Student: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

    public void addNewProf(String user, String pass, int id, String fname, String lname, int age,ArrayList<course> courses) {
        teacher x = new teacher(user, pass, id, fname, lname, age,courses);
        if (x.addProf()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayProfs() {
        teacher x = new teacher();
        System.out.println(x.displayAllProfs());
    }

    public void searchForProf(int id) {
        teacher x = new teacher();
        System.out.println(x.searchProf(id));
    }

    public void updateProf(int oldID,int n_id,String n_username,String n_pass,String n_fname,String n_lname,int n_age) {
        teacher x = new teacher();
        if (x.updateProf(oldID,n_id, n_username,n_pass, n_fname, n_lname, n_age)) {
            System.out.println("Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }


    public void deleteProf(int Id) {
        teacher x = new teacher();
        if (x.deleteProf(Id)) {
            System.out.println("Prof: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

    @Override
    public String toString() {
        return "I'm Manager : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : "  + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }
       public boolean login(String userName, String Pass) {
        if (userName.equals("a@.") && Pass.equals("a")) {
            return true;
        }
        return false;
    }
}
