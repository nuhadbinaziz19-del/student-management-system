/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import database.StudentDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Nuhad
 */
public class DeleteStudent extends Application {
    public void start(Stage stage) {
        Label title = new Label("DELETE STUDENT");
        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            StudentDAO dao = new StudentDAO();
            dao.deleteStudent(idField.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Student Deleted Successfully!");
            alert.showAndWait();
            idField.clear();
        });
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title,idField,deleteBtn);
        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("Delete Student");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}