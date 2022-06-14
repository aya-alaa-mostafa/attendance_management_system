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
public class LessAttendence extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         int size=2;
       GridPane grid = new GridPane();
       grid.setAlignment(Pos.TOP_CENTER);
       grid.setHgap(40);
       grid.setVgap(40);
       grid.setPadding(new Insets(25, 25, 25, 25));
       
       ScrollPane sp = new ScrollPane();
       sp.setContent(grid);
       sp.setPrefSize(600, 400);
       sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
       
       Label ids = new Label();
       ids.setText("ID");
       String Ids = "2017";
       
       Label names = new Label();
       names.setText("Name");
       String Name = "ahmed";
       
        Label usernames = new Label();
        usernames.setText("UserName");
        String Usernames = "ahmedAlaa";
       
        Label levels = new Label();
       levels.setText("level");
       String Levels = "4";
    
       Label absent = new Label();
       absent.setText("Absent");
       int Absent=0 ;
       
       
       grid.add(ids,0,0);
       grid.add(names,2,0);
       grid.add(usernames,4,0);
       grid.add(levels,6,0);
       grid.add(absent,8,0);
             
       for(int i=1;i<size;i++)
          {
               ids=new Label(Ids);
               grid.add(ids,0,i);
               names = new Label(Name);
               grid.add(names,2,i);
               usernames = new Label(Usernames);
               grid.add(usernames,4,i);
               levels = new Label(Levels);
               grid.add(levels, 6, i);
               absent = new Label(String.valueOf(Absent));
               grid.add(absent,8,i);

           }
           
    
       
    Button back = new Button ("Back");
    grid.add(back, 4, size+1);
   
        Scene scene = new Scene(sp, 650, 500);
        
        primaryStage.setTitle("Less Attendence");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               TeacherPanal x = new TeacherPanal();
               Stage s = new Stage();
               x.start(s);
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
