/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ok
 */
public class DisplayRequests extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        int size=10;
        GridPane grid = new GridPane();
       grid.setAlignment(Pos.TOP_CENTER);
       grid.setHgap(40);
       grid.setVgap(40);
       grid.setPadding(new Insets(25, 25, 25, 25));
       
         Label course = new Label();
       course.setText("No:");
       String courses = "1";
       
       Label names = new Label();
       names.setText("Code");
       String Name = "pl2";
       
        Label coursecode = new Label();
        coursecode.setText("Lec No");
        String coursescode = "1";
        
        
        grid.add(course,0,0);
       grid.add(names,2,0);
       grid.add(coursecode,4,0);
       
        for(int i=1;i<size;i++){
               course=new Label(String.valueOf(i));
               grid.add(course,0,i);
               names = new Label(Name);
               grid.add(names,2,i);
               coursecode = new Label(coursescode);
               grid.add(coursecode,4,i);
        }
       
       ScrollPane sp = new ScrollPane();
       sp.setContent(grid);
       sp.setPrefSize(600, 400);
       sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
       
       Button back = new Button ("Back");
        grid.add(back, 4, size+1);
       
        Scene scene = new Scene(sp, 380, 500);
        primaryStage.setTitle("Display Requests");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               TeacherPanal C = new TeacherPanal();
               Stage s = new Stage();
               C.start(s);
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
