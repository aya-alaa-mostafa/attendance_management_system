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
 * @author Ahmed Salah
 */
public class ViewTeacher extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         primaryStage.setTitle("View Teacher");
        
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
       
       
       grid.add(ids,0,2);
       grid.add(names,0,4);
       grid.add(usernames,0,6);
       
       
               ids=new Label(Ids);
               grid.add(ids,2,2);
               names = new Label(Name);
               grid.add(names,2,4);
               usernames = new Label(Usernames);
               grid.add(usernames,2,6);
               
               
                    
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
              search_about_teacher search = new search_about_teacher();
               Stage s = new Stage();
               search.start(s);
            }
        });
        
        
        primaryStage.setTitle("view Teacher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
