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
public class course implements Serializable{
   protected String name;
   protected String code;
   public int attend;
   protected lecture []lec = new lecture[10];

    course(String name, String code) {
        this.name = name;
        this.code = code;
        }
    
    public course(){
            this.attend=0;
        for(int i=0;i<10;i++){
            lec[i] = new lecture();
            this.lec[i].instructor_id=0;
            this.lec[i].std_attend_state="pinned";}    
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public lecture[] getLec() {
        return lec;
    }

    public void setLec(lecture[] lec) {
        this.lec = lec;
    } 
    public int collect_attend(){
    for(int i=0;i<10;i++)
        if(this.lec[i].getAttend()==0)
            this.attend++;
    return attend;
    }
}
