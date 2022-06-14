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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class studentepanal extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Student Affairs Panel");
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
            "veiw monthly attendance",
            "update profile",
            "send attendance request"
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
                    case "veiw weakly attendance":
                        {
                            stage.close();
                            addstudentframe addS = new addstudentframe();
                            Stage s = new Stage();
                            addS.start(s);
                            break;
                        }
                    case "veiw attendace today":
                        {
                            stage.close();
                            delete_student addS = new delete_student();
                            Stage s = new Stage();
                            addS.start(s);
                            break;
                        }
                    case "update profile":
                        {
                            stage.close();
                            student_update_profile update = new student_update_profile();
                            Stage s = new Stage();
                            update.start(s);
                            break;
                        }
                    case "send attendance request":
                        {
                            
                            student_request request=new student_request();
                            stage.close();
                            Stage s = new Stage();
                            request.start(s);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
