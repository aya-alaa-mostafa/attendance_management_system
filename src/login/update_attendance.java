/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
public class update_attendance extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       GridPane gridpane=new GridPane();
               gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
         Label Id=new Label("Student Id:");
                gridpane.add(Id, 0, 0);
       TextField id=new TextField();
              gridpane.add(id, 1, 0);
              Label Cc=new Label("Course Code:");
              gridpane.add(Cc,0,1);
              TextField cc=new TextField();
              gridpane.add(cc,1,1);
               Label lectureno=new Label("Lecture Number:");
              gridpane.add(lectureno,0,2);
              TextField lectureNo=new TextField();
              gridpane.add(lectureNo,1,2);
              Button bt=new Button("Edit");
              gridpane.add(bt, 1, 3);
              Button Bt=new Button("Back");
              gridpane.add(Bt, 0, 3);
             Scene scene=new Scene(gridpane,350,250);
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