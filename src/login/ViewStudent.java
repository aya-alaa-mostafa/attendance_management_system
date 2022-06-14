/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ok
 */
public class ViewStudent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("View Student");
        
        int size =1;
         GridPane grid = new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25, 25, 25, 25));
       
         Label ids = new Label();
       ids.setText("ID:");
       String Ids = "2017";
       
       Label names = new Label();
       names.setText("Name:");
       String Name = "ahmed";
       
        Label usernames = new Label();
        usernames.setText("UserName:");
        String Usernames = "ahmedAlaa";
       
        Label ages = new Label();
       ages.setText("Age:");
       String Ages = "13";
       
        Label levels = new Label();
       levels.setText("level:");
       String Levels = "4";
       
       grid.add(ids,0,2);
       grid.add(names,0,4);
       grid.add(usernames,0,6);
       grid.add(ages,0,8);
       grid.add(levels,0,10);
       
               ids=new Label(Ids);
               grid.add(ids,2,2);
               names = new Label(Name);
               grid.add(names,2,4);
               usernames = new Label(Usernames);
               grid.add(usernames,2,6);
               ages = new Label(Ages);
               grid.add(ages, 2, 8);
               levels = new Label(Levels);
               grid.add(levels,2,10);
               
                    
            Button back = new Button ("Back");
            grid.add(back, 4, 11);
        
        Scene scene = new Scene(grid, 380, 300);
        
        primaryStage.setTitle("View Student");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               search_about_student search = new search_about_student();
               Stage s = new Stage();
               search.start(s);
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
