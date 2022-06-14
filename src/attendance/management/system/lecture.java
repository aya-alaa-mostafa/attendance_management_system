/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.Serializable;

/**
 *
 * @author ok
 */
public class lecture implements Serializable {
    public int instructor_id;
    private int attend;  
    public String std_attend_state="pinned";
    public void setAttendanceState(String setState){
    std_attend_state=setState;
    }
    public String getAttendanceState(){
    return std_attend_state;
    }
    void lecture(){
       instructor_id=0;
       std_attend_state="pinned";
       attend=-1;
   //    Day=1;
   //    month=1;
   //    year=1;
       }
public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
       if(attend==1||attend==0||attend==-1)
        this.attend = attend;
    }


    public String getStd_attend_state() {
        return std_attend_state;
    }

    public void setStd_attend_state(String std_attend_state) {
        this.std_attend_state = std_attend_state;
    }

//    public int getDay() {
//       
//        return Day;
//    }
//
//    public void setDay(int Day) {
//       if(Day>0&&Day<31)
//        this.Day = Day;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public void setMonth(int month) {
//        if(month>0&&month<12)
//        this.month = month;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//    
    
}