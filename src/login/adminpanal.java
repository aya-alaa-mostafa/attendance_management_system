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
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class adminpanal extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Admin Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Choose your operation");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        final ComboBox SAOptions = new ComboBox();
        SAOptions.getItems().addAll(
            "Add Student",
            "Add teacher",
            "Update Teacher",
            "Update Student",
            "Delete Teacher",
            "Delete Student",
            "Seach About Teacher",
            "Search About Student",
            "Display Teachers",
            "Display Students"
           
        );
        SAOptions.getSelectionModel().selectFirst();
        grid.add(SAOptions, 0, 1);

       

        Button btn = new Button("Ok");
        grid.add(btn, 1, 2);

        Button SignOut = new Button("Sign Out");
        grid.add(SignOut, 2, 2);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        

        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.show();   
        btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent e) {
               String SelectedOption = (String) SAOptions.getValue();
               switch (SelectedOption) {
                   case "Add Student":
                       {
                           stage.close();
                           addstudentframe addS = new addstudentframe();
                           Stage s = new Stage();
                           addS.start(s);
                           break;
                       }
                   case "Add teacher":
                       {
                           stage.close();
                           add_teacher add = new add_teacher();
                           Stage s = new Stage();
                           add.start(s);
                           break;
                       }
                   case "Update Student":
                       {
                           stage.close();
                           student_update update = new student_update();
                           Stage s = new Stage();
                           update.start(s);
                           break;
                       }
                   case "Update Teacher":
                       {
                           stage.close();
                           updateteacher update = new updateteacher();
                           Stage s = new Stage();
                           update.start(s);
                           break;
                       }
                   case "Delete Teacher":
                       {
                           stage.close();
                           delete_teacher addS = new delete_teacher();
                           Stage s = new Stage();
                           addS.start(s);
                           break;
                       }
                   case "Delete Student":
                       {
                           stage.close();
                           delete_student delete = new delete_student();
                           Stage s = new Stage();
                           delete.start(s);
                           break;
                       }
                   case "Seach About Teacher":
                       {
                           stage.close();
                           search_about_teacher searsh = new search_about_teacher();
                           Stage s = new Stage();
                           searsh.start(s);
                           break;
                       }
                   case "Search About Student":
                       {
                           stage.close();
                           search_about_student searsh = new search_about_student();
                           Stage s = new Stage();
                           searsh.start(s);
                           break;
                       }
                   case "Display Teachers":
                       {
                           stage.close();
                           DisplayAllTeachers display = new DisplayAllTeachers();
                           Stage s = new Stage();
                           display.start(s);
                           break;
                       }
                   case "Display Students":
                       {
                           stage.close();
                           display_students display = new display_students();
                           Stage s = new Stage();
                           display.start(s);
                           break;
                       }
                    
                   default:
                       break;
               }
            }
        });
        
        SignOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               stage.close();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
