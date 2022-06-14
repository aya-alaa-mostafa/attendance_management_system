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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Aya Hassan
 */
public class select_lec extends Application {
    
   @Override
   public void start(Stage window){
       window.setTitle("Choose a Lecture");
       GridPane grid = new GridPane();
       grid.setVgap(15);
        grid.setHgap(15);
        grid.setPadding(new Insets(20,20,20,30));
        Label choose = new Label("Which Lecture:");
        grid.add(choose,0,0);
        ToggleGroup tg = new ToggleGroup() ;
        int i;
        Label lec;
        for(i=0 ; i<10 ; i++){
            lec = new Label("Lecture"+" "+(i+1));
            grid.add(lec, 2, i);
        }
        RadioButton rad1 = new RadioButton();
        grid.add(rad1,4,0);
        rad1.setToggleGroup(tg);
        /*rad1.setOnAction(
                if( !rad1.isSelected()){
        } else {
                    window.close();
       }
);*/
        
        RadioButton rad2 = new RadioButton();
        grid.add(rad2,4,1);
        rad2.setToggleGroup(tg);
        
        RadioButton rad3 = new RadioButton();
        grid.add(rad3,4,2);
        rad3.setToggleGroup(tg);
        if(rad3.isSelected()){
            window.close();
        }
        
        RadioButton rad4 = new RadioButton();
        grid.add(rad4,4,3);
        rad4.setToggleGroup(tg);
        
        RadioButton rad5 = new RadioButton();
        grid.add(rad5,4,4);
        rad5.setToggleGroup(tg);
        
        RadioButton rad6 = new RadioButton();
        grid.add(rad6,4,5);
        rad6.setToggleGroup(tg);
        
        RadioButton rad7 = new RadioButton();
        grid.add(rad7,4,6);
        rad7.setToggleGroup(tg);
        
        RadioButton rad8 = new RadioButton();
        grid.add(rad8,4,7);
        rad8.setToggleGroup(tg);
        
        RadioButton rad9 = new RadioButton();
        grid.add(rad9,4,8);
        rad9.setToggleGroup(tg);
        
        RadioButton rad10 = new RadioButton();
        grid.add(rad10,4,9);
        rad10.setToggleGroup(tg);
        Button ok = new Button("OK");
        grid.add(ok,5,10);
        Button back = new Button("Back");
        grid.add(back,7,10);
            
        Scene scene = new Scene(grid,400,400);
        window.setScene(scene);
        window.show();
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               window.close();
               choose_course x = new choose_course();
               Stage s = new Stage();
               x.start(s);
            }
        });
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               window.close();
               mark_attendance x = new mark_attendance();
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
