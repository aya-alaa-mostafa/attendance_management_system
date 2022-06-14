/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import attendance.management.system.admin;
import attendance.management.system.student;
import attendance.management.system.teacher;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Salah
 */
public class delete_student extends Application {
    
    @Override
     public void start(final Stage stage) {
        stage.setTitle("Delete student");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label Id = new Label("student id:");
        grid.add(Id, 0, 0);
        final TextField SId = new TextField();
        grid.add(SId, 1, 0);

       
        Button btn = new Button("Delete");
        grid.add(btn, 0, 2);

        Button back = new Button("Back");
        grid.add(back, 1, 2);
        
        Scene scene = new Scene(grid, 380, 300);
        stage.setScene(scene);
        stage.show();  
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                admin st=new admin();
               st.deleteStudent(Integer.valueOf(SId.getText()));
               
               adminpanal admin = new adminpanal();
               stage.close();
               Stage s = new Stage();
               admin.start(s);
            }
//                   final Text actiontarget=new Text();
//                   grid.add(actiontarget, 1, 3);
//                   actiontarget.setFill(Color.RED);
//                   actiontarget.setText("we can't delete this student!");
//               }
            //}
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
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
