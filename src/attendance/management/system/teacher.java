/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ok
 */
public class teacher extends person implements Serializable {
    Scanner scan=null;
    private final String professorFileName = "Professor.bin";

    public static ArrayList<teacher> teachers = new ArrayList<teacher>();
    course[] mycourses;
    public  ArrayList<course> courses = new ArrayList<course>();
    
    public teacher() {
    }
    
    public teacher(String user, String pass, int id, String fname, String lname, int age,ArrayList<course> courses) {
        super(user, pass, id, fname, lname, age);
          this.courses=courses; 
          for(int i=0;i<courses.size();i++){
            for(int j=0;j<10;j++){
                this.courses.get(i).lec[j]=new lecture();
//                this.courses.get(i).lec[j].std_attend_state = "pinned";
//                this.courses.get(i).lec[j].instructor_id = this.id;
            }          
         }
    }
    public boolean addProf() {
        loadFromFile();
        teachers.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(professorFileName, teachers);
    }

    public void loadFromFile() {
        if (FManger.read(professorFileName) != null) {
        teachers = (ArrayList<teacher>) FManger.read(professorFileName);
    }}

    private int getProfIndex(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllProfs() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (teacher x : teachers) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchProf(int id) {
        loadFromFile();
        int index = getProfIndex(id);
        if (index != -1) {
            return "\nFound ...!" + teachers.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }

     public boolean updateProf(int oldID,int n_id,String n_username,String n_pass,String n_fname,String n_lname,int n_age) {
        loadFromFile();
        int index = getProfIndex(oldID);

        if (index != -1) {
            teachers.get(index).setID(n_id);
            teachers.get(index).setUserName(n_username);
            teachers.get(index).setUserName(n_pass);
            teachers.get(index).setFName(n_fname);
            teachers.get(index).setLName(n_lname);
            teachers.get(index).setAge(n_age);
            return commitToFile();
        }

        return false;
    }
    public boolean deleteProf(int id) {
        loadFromFile();
        int index = getProfIndex(id);

        if (index != -1) {
            teachers.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Prof : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }
    
    private void rec_requsets(int teacher_id) throws FileNotFoundException
    {String[] courses_techear_have = null;int i,j;
        loadFromFile();
        int index=getProfIndex(teacher_id);
        for(i=0;i<courses.size();i++)
            {
                courses_techear_have[i]=teachers.get(index).courses.get(i).getCode();
            }j=i;
        try {
            String[] lines=FManger.reads("requset.txt");
             for(i=0;i<lines.length;i++)
           { 
               String[] seprated=lines[i].split("~");
               for(int count=0;count<courses_techear_have.length;count++)
               if(courses_techear_have[count].equals(seprated[1]))
               {
                    System.out.println("student id:"+seprated[0]+"have a problem in attendance in coursce:"+seprated[1]+"in lec number:"+seprated[2]);
                    
               }}}
        catch (FileNotFoundException e) {
            System.out.println("sorry but we can't read your reqastes now");
            System.out.println(e);
        }
        }
     public void delete_nPayed_fees(){
        student x= new student();
        ArrayList<student> not_payed=new ArrayList<student>();
        not_payed=x.pay_fees();
        for(int i=0;i<not_payed.size();i++)
        {
            not_payed.get(i).deleteStudent(not_payed.get(i).getID());
        }
    }
     public void HandoverLec(int TecID, int numOfLec , String CourseCode){
        loadFromFile();
        int index = getProfIndex(this.id),flag = 0;
        for (int i = 0; i < teachers.get(index).courses.size(); i++) {
            if (teachers.get(index).courses.get(i).code.equals(CourseCode))//اولا مينفعش مع السترنج== ثانيا مينفعش ننادي علي الكورس كود علطل ممكن ننادي عليه من الجيتير
            {
                flag = i;
            }
        if (index != -1) {
        
              teachers.get(index).courses.get(flag).lec[0].instructor_id= TecID;
          }
        commitToFile();
        }

    }
     public int get_indexcourse(String code)
     {
         for(int i=0;i<courses.size();i++)
             if (code.equals(courses.get(i).getCode()))
                 return i;
        return -1;
     }
     public ArrayList<student> less_attend(ArrayList<student> s,String code){
         ArrayList<Integer> atte=new ArrayList<Integer>();
         ArrayList<student> ss=new ArrayList<student>();
         for(int i=0;i<s.size();i++)
         {
            atte=s.get(i).collect_attend_s();
            if(atte.get(get_indexcourse(code))<3)
                ss.add(s.get(i));
         }
            return ss;      
     }
         ArrayList<course> showCourses (int teacher_id){

       return  teachers.get(getProfIndex(teacher_id)).courses;
}
        public boolean login(String userName, String Pass) {
        loadFromFile();
        for (int i=0;i<teachers.size();i++) {
            if (userName.equals(teachers.get(i).userName) && Pass.equals(teachers.get(i).pass)) {
                return true;
            }
        }
        return false;
    }
    
}
