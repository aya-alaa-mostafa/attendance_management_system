/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.File; 

/**
 *
 * @author ok
 */
public class AttendanceManagementSystem {

    /**
     * @param args the command line arguments
     * 
     */
    public static course cs = new course( "cs", "cs");
    public static course is = new course("is", "is");
    public static course it = new course("IT", "Information Technology");
  

    
    
    
    public static void main(String[] args) throws exceptions {
        // TODO code application logic here
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
        checkDirectoryContents(currentDir);
    }
    public static void checkDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        boolean studentFile = true;
        boolean profFile = true;
        boolean TAFile = true;
        boolean EmpFile = true;
        

        for (File file : files) {

            if (file.getName().contains("Students.bin")) {
                studentFile = false;
            } else if (file.getName().contains("Professor.bin")) {
                profFile = false;
            } 
        }
        if (studentFile) {
            student x = new student();
            x.commitToFile();
        }

        if (profFile) {
            teacher x = new teacher();
            x.commitToFile();
        }
    }
}
