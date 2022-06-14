/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.admin;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class student_update extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Update Student");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label O_Id = new Label("student old id:");
        grid.add(O_Id, 0, 0);
        final TextField o_Id = new TextField();
        grid.add(o_Id, 1, 0);

        Label N_Id = new Label("student id:");
        grid.add(N_Id, 0, 1);
        final TextField SId = new TextField();
        grid.add(SId, 1, 1);
        
        Label new_username = new Label("student user name:");
        grid.add(new_username, 0, 2);
        final TextField username = new TextField();
        grid.add(username, 1, 2);
        
        Label new_pass = new Label("password:");
        grid.add(new_pass, 0, 3);
        final PasswordField pass = new PasswordField();
        grid.add(pass, 1, 3);
        
        Label new_fname = new Label("student frist name:");
        grid.add(new_fname, 0, 4);
        final TextField fname = new TextField();
        grid.add(fname, 1, 4);
        
        Label new_lname = new Label("student last name:");
        grid.add(new_lname, 0, 5);
        final TextField lname = new TextField();
        grid.add(lname, 1, 5);
        
         Label newage = new Label("student age:");
        grid.add(newage, 0, 6);
        final TextField age = new TextField();
        grid.add(age, 1, 6);
        
        Label newlevel = new Label("student level:");
        grid.add(newlevel, 0, 7);
        final TextField level = new TextField();
        grid.add(level, 1, 7);
        
         Label newgpa = new Label("student gpa:");
        grid.add(newgpa, 0, 8);
        final TextField gpa = new TextField();
        grid.add(gpa, 1, 8);
        
        Button btn = new Button("update");
        grid.add(btn, 0, 9);

        Button back = new Button("Back");
        grid.add(back, 1, 9);
        
        Scene scene = new Scene(grid, 380,500);
        stage.setScene(scene);
        stage.show();   
       
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            
              public void handle(ActionEvent e) {
              admin ad=new admin();
               ad.updateStudent(Integer.valueOf(o_Id.getText()),Integer.valueOf(SId.getText()),
               username.getText(),pass.getText(),fname.getText(),lname.getText(),Integer.valueOf(age.getText()),
               Integer.valueOf(level.getText()),Double.valueOf(gpa.getText()));
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
               adminpanal admin = new adminpanal();
               Stage s = new Stage();
               admin.start(s);
               
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
