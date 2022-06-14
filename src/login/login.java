/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.admin;
import attendance.management.system.student;
import attendance.management.system.teacher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class login extends Application {
    
    @Override
      public void start(final Stage primaryStage) {
        primaryStage.setTitle("Login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        ToggleGroup TG=new ToggleGroup();
        
        
        RadioButton R1=new RadioButton("Admin");
        R1.setPrefWidth(200);
        
        RadioButton R2=new RadioButton("Teacher");
        R2.setPrefWidth(200);

        RadioButton R3=new RadioButton("Student");
        R3.setPrefWidth(200);
        TG.getToggles().addAll(R1,R2,R3);
        grid.add(R3,2,1);
        grid.add(R2,1,1);
        grid.add(R1,0,1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 2);
        final TextField userTextField = new TextField();
        grid.add(userTextField, 1, 2);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 3);
        final PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BASELINE_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 380, 300);
        primaryStage.setScene(scene);
        primaryStage.show();   
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
                

                
                
                if(R1.isSelected()/*&&userTextField.getText().equals("admin")&&pwBox.getText().equals("admin")*/){
                    admin d=new admin();
                   if(d.login(userTextField.getText(),pwBox.getText())) 
                   {
                       primaryStage.close();
                       adminpanal p = new adminpanal();
                       Stage s = new Stage();
                       p.start(s);
                   }
                   else{
                       final Text actiontarget = new Text();
                        grid.add(actiontarget, 1, 6);
                        actiontarget.setFill(Color.RED);
                        actiontarget.setText("Invalid Username and Password!");}
                }
                else if(R2.isSelected()){
                    teacher d=new teacher();
                   if(d.login(userTextField.getText(),pwBox.getText())) 
                   {
                       primaryStage.close();
                       TeacherPanal p = new TeacherPanal();
                       Stage s = new Stage();
                       p.start(s);
                   }
                   else{
                       final Text actiontarget = new Text();
                        grid.add(actiontarget, 1, 6);
                        actiontarget.setFill(Color.RED);
                        actiontarget.setText("Invalid Username and Password!");}
                
                }
                else if(R3.isSelected()){
                   student d=new student();
                   if(d.login(userTextField.getText(),pwBox.getText())) 
                   {
                       primaryStage.close();
                       studentepanal p = new studentepanal();
                       Stage s = new Stage();
                       p.start(s);
                   }
                   else{
                       final Text actiontarget = new Text();
                        grid.add(actiontarget, 1, 6);
                        actiontarget.setFill(Color.RED);
                        actiontarget.setText("Invalid Username and Password!");}
                }
                else{  
                    final Text actiontarget = new Text();
                    grid.add(actiontarget, 1, 6);
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Invalid Username and Password!");
                }
                
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
