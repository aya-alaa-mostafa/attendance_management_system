/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.admin;
import attendance.management.system.course;
import java.util.ArrayList;
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
public class add_teacher extends Application {
    
    @Override
      public void start(final Stage stage) {
        stage.setTitle("Add Teacher Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label Id = new Label("Teacher ID:");
        grid.add(Id, 0, 1);
        final TextField TId = new TextField();
        grid.add(TId, 1, 1);
        
        Label username = new Label("Teacher Username:");
        grid.add(username, 0, 2);
        final TextField user = new TextField();
        grid.add(user, 1, 2);
        
        Label pass = new Label("Teacher password:");
        grid.add(pass, 0, 3);
        final PasswordField password = new PasswordField();
        grid.add(password, 1, 3);

        Label TFname = new Label("Teacher Fname:");
        grid.add(TFname, 0, 4);
        final TextField TF = new TextField();
        grid.add(TF, 1, 4);
        
        Label TLname = new Label("Teacher Lname:");
        grid.add(TLname, 0, 5);
        final TextField TL = new TextField();
        grid.add(TL, 1, 5);
        
        Label TAge = new Label("teacher Age:");
        grid.add(TAge, 0, 6);
        final TextField TA = new TextField();
        grid.add(TA, 1, 6);
      
        Label course = new Label("course name:");
        grid.add(course, 0, 7);
        final TextField namecourse = new TextField();
        grid.add(namecourse, 1, 7);
        
        Label coursecode = new Label("course code:");
        grid.add(coursecode, 0, 8);
        final TextField code = new TextField();
        grid.add(code, 1, 8);
       
        Button btn = new Button("Add");
        grid.add(btn, 1, 9);

        Button back = new Button("Back");
        grid.add(back, 0, 9);
        
        Scene scene = new Scene(grid, 380, 500);
        stage.setScene(scene);
        stage.show();   
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               admin ad = new admin();
               course cou=new course();
               ArrayList<course> courses=new ArrayList<course>();
               cou.setName(namecourse.getText());
               cou.setCode(coursecode.getText());
               courses.add(cou);
               ad.addNewProf(user.getText(), password.getText(),Integer.valueOf(TId.getText()), TF.getText(),TL.getText(),Integer.valueOf(TA.getText()), courses);
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
