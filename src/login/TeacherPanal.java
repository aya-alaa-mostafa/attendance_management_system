package login;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class TeacherPanal extends Application {
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Teachers Affairs Panel");
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
            "Mark attendance of student",
            "Get students with less attendance",
            "See Courses",
            "Handover lecture",
            "Get Students that have not paid the fees",
            "Display Requests"
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
                    case "Mark attendance of student":
                        {
                            stage.close();
                            choose_course addS = new choose_course();
                            Stage s = new Stage();
                            addS.start(s);
                            break;
                        }
                    case "Get students with less attendance":
                        {
                            stage.close();
                            LessAttendence x = new LessAttendence();
                            Stage s = new Stage();
                            x.start(s);
                            break;
                        }
                    case "See Courses":
                        {
                            stage.close();
                            DisplayCourses x = new DisplayCourses();
                            Stage s = new Stage();
                            x.start(s);
                            break;
                        }
                    case "Handover lecture":
                        {
                            
                            HandoverLec x=new HandoverLec();
                            stage.close();
                            Stage s = new Stage();
                            x.start(s);
                            break;
                        }
                    case "Get Students that have not paid the fees":
                        {
                            
                            Fees x=new Fees();
                            stage.close();
                            Stage s = new Stage();
                   try {
                       x.start(s);
                   } catch (Exception ex) {
                       Logger.getLogger(TeacherPanal.class.getName()).log(Level.SEVERE, null, ex);
                   }
                            break;
                        }
                    case "Display Requests":
                        {
                            
                            DisplayRequests x=new DisplayRequests();
                            stage.close();
                            Stage s = new Stage();
                   try {
                       x.start(s);
                   } catch (Exception ex) {
                       Logger.getLogger(TeacherPanal.class.getName()).log(Level.SEVERE, null, ex);
                   }
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