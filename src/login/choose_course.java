/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose T ools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import attendance.management.system.course;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
/**
 *
 * @author Aya Hassan
 */
public class choose_course extends Application {
    @Override
    public void start(Stage window){
        window.setTitle("Choose The Course");
       /* Menu m_c = new Menu("Choose The Course:");
        ToggleGroup tg =new ToggleGroup();
        RadioMenuItem cs = new RadioMenuItem("Computer Sciencs");
        RadioMenuItem ds = new RadioMenuItem("Data Structure");
        RadioMenuItem pl = new RadioMenuItem("Programming Language");
        cs.setToggleGroup(tg);
        ds.setToggleGroup(tg);
        pl.setToggleGroup(tg);
        m_c.getItems().addAll(cs,ds,pl);
        MenuBar menu = new MenuBar();
        menu.getMenus().addAll(m_c);*/
        Label choose = new Label("Which Course:");
        String x = "aya";
        Label cou;
        RadioButton rad;
        ToggleGroup tg =new ToggleGroup();
        GridPane grid = new GridPane();
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setPadding(new Insets(20,20,20,20));
        grid.add(choose, 0, 1);
        int i;
        for(i=0 ; i<5 ;i++){
            cou = new Label(x);
            grid.add(cou,1,i+1);   
        }
        for(i=0 ; i<5 ; i++){
                rad = new RadioButton();
                rad.setToggleGroup(tg);
                grid.add(rad,3,i+1);
            }
        Button ok = new Button("OK");
        grid.add(ok,3,7);
        Button back = new Button("Back");
        grid.add(back, 5, 7);
        //BorderPane layout = new BorderPane();
        //layout.setTop(menu);
        Scene scene = new Scene(grid,300,300);
        window.setScene(scene);
        window.show();
         back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               window.close();
               TeacherPanal teacher = new TeacherPanal();
               Stage s = new Stage();
               teacher.start(s);
            }
        });
          ok.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               window.close();
                select_lec sl = new select_lec();
               Stage s = new Stage();
               sl.start(s);
            }
        });
    }
  /*  
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
