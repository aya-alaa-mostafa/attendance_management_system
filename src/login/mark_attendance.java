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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Aya Hassan
 */
public class mark_attendance extends Application {
    @Override
    public void start(Stage window){
        window.setTitle("Mark Attendance");
        int size = 40;
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(10,50,20,90));
        ScrollPane sp = new ScrollPane();
        //grid.add(sp, 9, 9);
        sp.setContent(grid);
        sp.setPrefSize(600, 400);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Label name = new Label("NAME");
        String name_s = "Aya";
        grid.add(name, 1, 1);
        Label id = new Label("IDs");
        int ID = 2017652;
        int i;
        grid.add( id, 3, 1);
        Label attnd = new Label("Attendace");
        grid.add( attnd, 6, 1);
        Label not = new Label("Absent");
        grid.add(not , 7, 2);
        Label yes = new Label("Attend");
        grid.add(yes , 5, 2);
        Label num = new Label("Number");
        grid.add(num, 0, 1);
        for(i=0 ; i<size ;i++){
            name = new Label(name_s);
            grid.add(name,1,i+3);
            id = new Label(String.valueOf(ID));
            grid.add(id, 3, i+3);
            num = new Label(String.valueOf((i+1)));
            grid.add(num , 0, i+3);
        }
        RadioButton rad1 ;
        RadioButton rad2 ;
        ToggleGroup tg =new ToggleGroup();
        for(i=0 ; i<size; i++){
            for(int j=0; j<size ;j++){
            rad1 = new RadioButton();
            grid.add( rad1,5,i+3);
            rad2 = new RadioButton();
            grid.add(rad2,7,i+3);
            rad1.setToggleGroup(tg);
            rad2.setToggleGroup(tg);
            }
            tg = new ToggleGroup();
        }
        Button mark = new Button("Mark");
        grid.add(mark,5,size+4);
        Button back = new Button("Back");
        grid.add(back, 7, size+4);
        Scene scene = new Scene(sp,600,600);
        window.setScene(scene);
        window.show();
        
         back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               window.close();
               select_lec x = new select_lec();
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
