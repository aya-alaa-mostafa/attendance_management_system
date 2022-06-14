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
public class student extends person implements Serializable {
    private int level;
    private double GPA;
    private boolean fees;
    private final String studentFileName = "Students.bin";
    public static ArrayList<student> Students = new ArrayList<student>();
    public ArrayList<course> courses = new ArrayList<course>();

    public student() {

    }

    public student(String user, String pass, int id, String fname, String lname, int age, int level, double GPA,boolean fe,ArrayList<course> courses) {
        super(user, pass, id, fname, lname, age);

        this.level = level;
        this.GPA = GPA;
        this.fees=fe;
        System.out.println(courses.size());
         this.courses=courses; 
      for(int i=0;i<courses.size();i++){  
           
            for(int j=0;j<10;j++){
                this.courses.get(i).lec[j]=new lecture();
//                this.courses.get(i).lec[j].std_attend_state = "pinned";
                
            }          
         }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getLevel() {
        return this.level;
    }
    
    

    public double getGPA() {
        return this.GPA;
    }
    
    public void setFees(boolean fees) {
        this.fees = fees;
    }
    public boolean getFees() {
           return fees;
       }

    public boolean addStudent() {
        loadFromFile();
        Students.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(studentFileName, Students);
    }

    public void loadFromFile() {
         if (FManger.read(studentFileName) != null) {
             Students = (ArrayList<student>) FManger.read(studentFileName);}
    }

    private int getStudentIndex(int id) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllStudents() {
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (student x : Students)
        {
            S = S + x.toString();
        }
        return S;
    }

    public String searchStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Students.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }

   public boolean updateStudent(int oldID,int n_id,String n_username,String n_pass,String n_fname,String n_lname,int n_age,int n_level,double gpa) {
        int index = getStudentIndex(oldID);
        if (index != -1) {
            Students.get(index).setID(n_id);
            Students.get(index).setUserName(n_username);
            Students.get(index).setUserName(n_pass);
            Students.get(index).setFName(n_fname);
            Students.get(index).setLName(n_lname);
            Students.get(index).setAge(n_age);
            Students.get(index).setLevel(n_level);
            Students.get(index).setGPA(gpa);
            return commitToFile();
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + GPA + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void study() {
        System.out.println("I'm Studying Undergraduate Courses @ FCIH :) ");
    }
  public ArrayList<student> pay_fees(){
        loadFromFile();
        ArrayList<student> notpayed=new ArrayList<student>();
        for(int i=0;i<Students.size();i++)
            if(Students.get(i).fees==false){
                notpayed.add(Students.get(i));
        }
        return notpayed;//بترجع اللي مدفعوش 
    }
  public void requset(String student_id,String course_code,String lec_num)throws exceptions
  {
      String s= student_id+"~"+course_code+"~"+lec_num+"~";
      try {
          FManger.write("requset.txt",s, true);
          System.out.println("your requset send succesfully thank you:)");
      } catch (Exception e) {
          System.out.println("we can't send your requset");
      }
  }
  public ArrayList<Integer> collect_attend_s(){
        ArrayList<Integer>  att=new ArrayList<Integer>();
        for(int i=0;i<courses.size();i++)
            att.add(i, this.courses.get(i).collect_attend());
        return att;
      }
  
  public ArrayList<student> student_in_course(String code){
      ArrayList<student> student_have_course =new ArrayList<student>();
      for(int i=0;i<Students.size();i++)
          for(int j=0;j<Students.get(i).courses.size();j++)
            if(Students.get(i).courses.get(j).getCode().equals(code))
              student_have_course.add(Students.get(i));
      return student_have_course;
  }
          
  int get_indexcourse(String code){
    for(int i=0;i<courses.size();i++){
    if(code.equals(courses.get(i).getCode()))
    return i;
    }
    return -1;
    }
   public void markAttendance(int indexCourse,int indexLecture,int state){
    this.courses.get(indexCourse).lec[indexLecture].setAttend(state);
    }
    public void update_s_profile (String username,String fn,String ln,String pass,int id){
                Students.get(getStudentIndex(id)).setUserName(username);
                Students.get(getStudentIndex(id)).setFName(fn);
                Students.get(getStudentIndex(id)).setLName(ln);
                Students.get(getStudentIndex(id)).setPass(pass);
    }
    public boolean login(String userName, String Pass) {
        loadFromFile();
        
        for (int i=0;i<Students.size();i++) {
            if (userName.equals(Students.get(i).userName) && Pass.equals(Students.get(i).pass)) {
                return true;
            }
        }
        return false;
    }
}
