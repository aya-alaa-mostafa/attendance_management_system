/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.student;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class student_update_profile extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Update Student");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label username = new Label("username:");
        grid.add(username, 0, 0);
        final TextField nusername = new TextField();
        grid.add(nusername, 1, 0);

        Label new_pass= new Label("pasword:");
        grid.add(new_pass, 0, 1);
        final PasswordField pass = new PasswordField();
        grid.add(pass, 1, 1);
        
        Label new_fname = new Label("student first name:");
        grid.add(new_fname, 0, 2);
        final TextField fname = new TextField();
        grid.add(fname, 1, 2);
      
        Label new_lname = new Label("student last name:");
        grid.add(new_lname, 0, 3);
        final TextField lname = new TextField();
        grid.add(lname, 1, 3);
        
         Label newage = new Label("student age:");
        grid.add(newage, 0, 4);
        final TextField age = new TextField();
        grid.add(age, 1, 4);
       
        
        Button btn = new Button("update");
        grid.add(btn, 0,6);

        Button back = new Button("Back");
        grid.add(back, 1, 6);
        
        Scene scene = new Scene(grid, 380,300);
        stage.setScene(scene);
        stage.show();   
       
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
               student st=new student();
               //هنا محتاجين الid
               st.setUserName(username.getText());
               st.setPass(pass.getText());
               st.setLName(lname.getText());
               st.setFName(fname.getText());
               st.setAge(Integer.valueOf(age.getText()));
               stage.close();
               adminpanal admin = new adminpanal();
               Stage s = new Stage();
               admin.start(s);
                     
                
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
               studentepanal st = new studentepanal();
               Stage s = new Stage();
               st.start(s);
               
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
