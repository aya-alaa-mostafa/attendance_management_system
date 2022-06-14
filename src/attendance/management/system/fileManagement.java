/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ok
 */
public class fileManagement implements Serializable {
 Scanner scan=null;
     public boolean write(String FilePath, Object data) {

        try (ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath))) {
            writter.writeObject(data);
            writter.close();
            
        } catch (IOException e) {
           
        }
        return true;
    }
     public boolean write(String quiry,String filepath,boolean appendtype)
    {
      PrintWriter writer=null;
        
        try
        {
           writer=new PrintWriter(new FileWriter(new File(filepath),appendtype));
            writer.println(quiry);
            return true;
        }
        catch(IOException e)
                {
                    System.out.println("your file has" + e);
                    return false;
                }
        finally
            {
                writer.close();
            }
    }
    public Object read(String FilePath) {

        Object Result = null;

        try {
            System.out.println("Reading ! From " + FilePath);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return Result;

    }
    public String[] reads(String filepath) throws FileNotFoundException
    { int i=0;String[] lines=null;String[][] fn=null;
        try
        {
            scan=new Scanner(new File(filepath));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("you have " + e);
        }
             while (scan.hasNext()) 
             {
                       lines[i]=scan.nextLine(); 
                       i++;
             }
     
             return lines;
             //20170059~cs_214~5~
             
        } 
       
       
    }
    

