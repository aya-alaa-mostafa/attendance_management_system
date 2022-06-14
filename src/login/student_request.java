/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.exceptions;
import attendance.management.system.student;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class student_request extends Application {
    
    @Override
      public void start(final Stage stage) {
        stage.setTitle("student request");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label SId = new Label("student id:");
        grid.add(SId, 0, 0);
        final TextField Id = new TextField();
        grid.add(Id, 1, 0);

        Label course_code = new Label("course code :");
        grid.add(course_code, 0, 1);
        final TextField code = new TextField();
        grid.add(code, 1, 1);
        
        Label numbr_lec = new Label("number of lecture:");
        grid.add(numbr_lec, 0, 2);
        final TextField lec = new TextField();
        grid.add(lec, 1, 2);
      
        Button btn = new Button("send");
        grid.add(btn, 0, 3);

        Button back = new Button("Back");
        grid.add(back, 1, 3);
        
        Scene scene = new Scene(grid, 390,300);
        stage.setScene(scene);
        stage.show();   
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               student st=new student();
                try {
                    st.requset(Id.getText(),code.getText(),lec.getText());
                } catch (exceptions ex) {
                    Logger.getLogger(student_request.class.getName()).log(Level.SEVERE, null, ex);
                }
               stage.close();
               studentepanal student = new studentepanal();
               Stage s = new Stage();
               student.start(s);
                     
                
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
               studentepanal student = new studentepanal();
               Stage s = new Stage();
               student.start(s);
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
