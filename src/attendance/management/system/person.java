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
public abstract class person implements Serializable {
    
    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;

    fileManagement FManger = new fileManagement();

    static exceptions MyEX = new exceptions("Tamer Exception");

    public person() {
    }

    public person(String user, String pass, int id, String fname, String lname, int age) {
             
        if (id < 0) {
            this.id = MyEX.checkPositive("ID");
        } else {
            this.id = id;
        }
        this.fname = fname;
        this.lname = lname;

        if (age < 0) {
            this.age = MyEX.checkPositive("Age");
        } else {
            this.age = age;
        }

        if (!user.contains("@") || !user.contains(".")) {
            this.userName = MyEX.checkEmail("User name");
        } else {
            this.userName = user;
        }

        if (pass.length() < 8) {
            this.pass = MyEX.checkPassLength("Password");
        }else{
            this.pass=pass;
        }
    }

    @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }

    
    
}
