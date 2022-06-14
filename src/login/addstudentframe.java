/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.admin;
import attendance.management.system.course;
import attendance.management.system.lecture;
import attendance.management.system.student;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class addstudentframe extends Application {

    @Override
    public void start(final Stage stage) {
        stage.setTitle("Add Student Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label Id = new Label("Student ID:");
        grid.add(Id, 0, 1);
        final TextField SId = new TextField();
        grid.add(SId, 1, 1);

        Label username = new Label("Student username:");
        grid.add(username, 0, 2);
        final TextField user = new TextField();
        grid.add(user, 1, 2);

        Label pass = new Label("Student password:");
        grid.add(pass, 0, 3);
        final PasswordField password = new PasswordField();
        grid.add(password, 1, 3);

        Label SFname = new Label("Student Fname:");
        grid.add(SFname, 0, 4);
        final TextField SF = new TextField();
        grid.add(SF, 1, 4);

        Label SLname = new Label("Student Lname:");
        grid.add(SLname, 0, 5);
        final TextField SL = new TextField();
        grid.add(SL, 1, 5);

        Label SAge = new Label("Student Age:");
        grid.add(SAge, 0, 6);
        final TextField SA = new TextField();
        grid.add(SA, 1, 6);

        Label SLevel = new Label("Student Level:");
        grid.add(SLevel, 0, 7);
        final TextField Slevel = new TextField();
        grid.add(Slevel, 1, 7);

        Label course1 = new Label("frist course name:");
        grid.add(course1, 0, 8);
        final TextField namecourse = new TextField();
        grid.add(namecourse, 1, 8);

        Label coursecode1 = new Label("course code:");
        grid.add(coursecode1, 0, 9);
        final TextField coursecode = new TextField();
        grid.add(coursecode, 1, 9);

        Label course2 = new Label("second course name:");
        grid.add(course2, 0, 10);
        final TextField namecourse2 = new TextField();
        grid.add(namecourse2, 1, 10);

        Label coursecode2 = new Label("course code:");
        grid.add(coursecode2, 0, 11);
        final TextField coursecode_2 = new TextField();
        grid.add(coursecode_2, 1, 11);

        Label SGPA = new Label("Student GPA:");
        grid.add(SGPA, 0, 12);
        final TextField Sgba = new TextField();
        grid.add(Sgba, 1, 12);
        
        Label sfees=new Label("Fees:");
        grid.add(sfees, 0, 13);
        CheckBox fee = new CheckBox();
        grid.add(fee, 1, 13);


        Button btn = new Button("Add");
        grid.add(btn, 1, 14);

        Button back = new Button("Back");
        grid.add(back, 0, 14);

        Scene scene = new Scene(grid, 400, 600);
        stage.setScene(scene);
        stage.show();
        fee.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
              
            }
    
    
  
    
    });
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                admin ad = new admin();
                course cou = new course();
                boolean x = false;
                lecture lec[] = new lecture[10];
                lec[0] = new lecture();
                for (int i = 0; i < 10; i++) {
                    lec[i] = new lecture();
                    lec[i].instructor_id = 0;
                    lec[i].std_attend_state = "pinned";
                }
                ArrayList<course> courses = new ArrayList<course>();
                cou.setName(namecourse.getText());
                cou.setCode(coursecode.getText());
                cou.setLec(lec);
                courses.add(cou);
                cou.setName(namecourse2.getText());
                cou.setCode(coursecode_2.getText());
                cou.setLec(lec);
//               cou.setLec(lecw);
                courses.add(cou);
                if(fee.isSelected()){
              x=true;
              }
                ad.addNewStudent(user.getText(), password.getText(), Integer.valueOf(SId.getText()), SF.getText(), SL.getText(),
                        Integer.valueOf(SA.getText()), Integer.valueOf(Slevel.getText()), Double.valueOf(Sgba.getText()), x,courses);
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
