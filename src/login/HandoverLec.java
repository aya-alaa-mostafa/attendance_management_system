/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import attendance.management.system.teacher;
import attendance.management.system.course;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Aya Hassan
 */
public class HandoverLec extends Application {
   
    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets (10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        Label to_prof = new Label("Techer ID:");
        grid.add(to_prof,0,1);
        Label num_lec  = new Label("Lecture Number:");
        grid.add(num_lec,0,2);
        Label code = new Label("Course Code");
        grid.add(code,0,3);
        final TextField tech_id = new TextField(); 
        grid.add(tech_id,1,1);
        final TextField lec_num = new TextField();
        grid.add(lec_num,1,2);
        final TextField c_code = new TextField();
        grid.add(c_code,1,3);
        Button btn = new Button("Submit");
        grid.add(btn,0,6);
        Button back = new Button("Back");
        grid.add(back,2,6);
        Scene scene = new Scene(grid,350,200);
        back.setOnAction(e->primaryStage.close());
        //back.setOnAction(e->primaryStage.setScene(scene));
        primaryStage.setTitle("Handover a Lecture");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                
                Label S=new Label("Done!");
                 S.setTextFill(Color.web("#0076a3"));
                 grid.add(S,1,6);
                teacher t = new teacher();
                t.HandoverLec(Integer.valueOf(tech_id.getText()), Integer.valueOf(lec_num.getText()),c_code.getText() );
            }
            
            });
        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
            primaryStage.close();
               TeacherPanal teacher = new TeacherPanal();
               Stage s = new Stage();
               teacher.start(s);
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
