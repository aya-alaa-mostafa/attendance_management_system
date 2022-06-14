/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.admin;
import attendance.management.system.teacher;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class updateteacher extends Application {
    
    @Override
   public void start(final Stage stage) {
        stage.setTitle("Update Teacher");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label O_Id = new Label("Teacher old id:");
        grid.add(O_Id, 0, 0);
        final TextField o_Id = new TextField();
        grid.add(o_Id, 1, 0);

        Label N_Id = new Label("Teacher New Id:");
        grid.add(N_Id, 0, 1);
        final TextField SId = new TextField();
        grid.add(SId, 1, 1);
        
        Label new_username = new Label("Teacher Username:");
        grid.add(new_username, 0, 2);
        final TextField username = new TextField();
        grid.add(username, 1, 2);
        
        Label new_pass = new Label("Teacher Password:");
        grid.add(new_pass, 0, 3);
        final PasswordField pass = new PasswordField();
        grid.add(pass, 1, 3);
        
        Label new_fname = new Label("Teacher Frist Name:");
        grid.add(new_fname, 0, 4);
        final TextField fname = new TextField();
        grid.add(fname, 1, 4);
      
        Label new_lname = new Label("Teacher Last Name:");
        grid.add(new_lname, 0, 5);
        final TextField lname = new TextField();
        grid.add(lname, 1, 5);
        
         Label newage = new Label("Teacher age:");
        grid.add(newage, 0, 6);
        final TextField age = new TextField();
        grid.add(age, 1, 6);
        
        Button btn = new Button("update");
        grid.add(btn, 0, 7);

        Button back = new Button("Back");
        grid.add(back, 1, 7);
        
        Scene scene = new Scene(grid, 380,350);
        stage.setScene(scene);
        stage.show();   
       
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               //teacher te=new teacher();
               admin ad=new admin();
               ad.updateProf(Integer.valueOf(o_Id.getText()),Integer.valueOf(SId.getText()),
               username.getText(),pass.getText(),fname.getText(),lname.getText(),Integer.valueOf(age.getText()));
               stage.close();
               adminpanal admin = new adminpanal();
               Stage s = new Stage();
               admin.start(s);  
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
           public void handle(ActionEvent e) {
               stage.close();
               adminpanal admin = new adminpanal();
               Stage s = new Stage();
               admin.start(s);
                     
                
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
