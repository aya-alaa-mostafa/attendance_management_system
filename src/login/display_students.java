/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import attendance.management.system.student;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class display_students extends Application {
 
    student std=new student();
//    ObservableList li=FXCollections.observableList(std.Students);
//    TableView<> table = new TableView<>();
//    
    TableView<student> table = new TableView<>();
//    for (int i = 0; i < intList.size() && i < stringList.size(); i++) {
//    table.getItems().add(new MyDataType(intList.get(i), stringList.get(i)));
//}
////    ObservableList li=FXCollections.observableList(std.Students);

   
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("View student");
        stage.setWidth(450);
        stage.setHeight(500);
 
        final Label label = new Label("Students");
        label.setFont(new Font("Arial", 20));
 
//        table.setEditable(false);
 
        TableColumn firstNameCol = new TableColumn("ID");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<student, String>("std.id"));
 
        TableColumn lastNameCol = new TableColumn("First Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<student, String>("stdf.name"));
 
        TableColumn emailCol = new TableColumn("Last name");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<student, String>("std.lname"));
 
//            table.setItems(data);

       std.displayAllStudents();
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
           ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
} 