/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import attendance.management.system.student;
import attendance.management.system.teacher;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ok
 */
public class Fees extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<student> arr = new ArrayList();
        student st = new student();
        arr = st.pay_fees();
        int size = arr.size();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(40);
        grid.setVgap(40);
        grid.setPadding(new Insets(25, 25, 25, 25));

        ScrollPane sp = new ScrollPane();
        sp.setContent(grid);
        sp.setPrefSize(600, 400);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Label ids = new Label();
        ids.setText("ID");

        Label names = new Label();
        names.setText("Name");

        Label usernames = new Label();
        usernames.setText("UserName");

        Label ages = new Label();
        ages.setText("Age");
        String Ages = "13";

        Label levels = new Label();
        levels.setText("level");

        grid.add(ids, 0, 0);
        grid.add(names, 2, 0);
        grid.add(usernames, 4, 0);
        grid.add(ages, 6, 0);
        grid.add(levels, 8, 0);
        int j = 0, i = 1;
        for (i = 1, j = 0; i < size; i++, j++) {
            ids = new Label(String.valueOf(arr.get(j).getID()));
            grid.add(ids, 0, i);
            names = new Label((arr.get(i).getFName() + " " + arr.get(i).getLName()));
            grid.add(names, 2, i);
            usernames = new Label(arr.get(i).getuserName());
            grid.add(usernames, 4, i);
            ages = new Label(String.valueOf(arr.get(i).getAge()));
            grid.add(ages, 6, i);
            levels = new Label(String.valueOf(arr.get(i).getLevel()));
            grid.add(levels, 8, i);
        }

        Button back = new Button("Back");
        grid.add(back, 7, size + 1);

        Button delete = new Button("Delete");
        grid.add(delete, 0, size + 1);

        Scene scene = new Scene(sp, 650, 500);
        primaryStage.setTitle("Fees OF Students");
        primaryStage.setScene(scene);
        primaryStage.show();
        delete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                teacher x = new teacher();
                x.delete_nPayed_fees();
                primaryStage.close();
                TeacherPanal teacher = new TeacherPanal();
                Stage s = new Stage();
                teacher.start(s);
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                primaryStage.close();
                TeacherPanal teacher = new TeacherPanal();
                Stage s = new Stage();
                teacher.start(s);
            }
        });

    }

}
