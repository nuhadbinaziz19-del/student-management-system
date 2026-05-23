/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import database.StudentDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Student;
/**
 *
 * @author Nuhad
 */
public class StudentForm extends Application {
    public void start(Stage stage) {
        Label title = new Label("ADD STUDENT");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label idLabel = new Label("Student ID:");
        Label nameLabel = new Label("Student Name:");
        Label deptLabel = new Label("Department:");
        Label phoneLabel = new Label("Phone:");
        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField deptField = new TextField();
        TextField phoneField = new TextField();
        idField.setPromptText("Enter ID");
        nameField.setPromptText("Enter Name");
        deptField.setPromptText("Enter Department");
        phoneField.setPromptText("Enter Phone");
        Button addBtn = new Button("Add Student");
        Button saveBtn = new Button("Save Student");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(deptLabel, 0, 2);
        grid.add(deptField, 1, 2);
        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);
        StudentDAO dao = new StudentDAO();
        saveBtn.setOnAction(e -> {
            if (idField.getText().isEmpty()
                    || nameField.getText().isEmpty()
                    || deptField.getText().isEmpty()
                    || phoneField.getText().isEmpty()) {
                Alert warn = new Alert(Alert.AlertType.WARNING);
                warn.setHeaderText(null);
                warn.setContentText("Please fill all fields!");
                warn.showAndWait();
                return;
            }
            Student student = new Student(
                    idField.getText(),
                    nameField.getText(),
                    deptField.getText(),
                    phoneField.getText()
            );
            dao.addStudent(student);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Student Saved Successfully!");
            alert.showAndWait();
            idField.clear();
            nameField.clear();
            deptField.clear();
            phoneField.clear();
        });
        addBtn.setOnAction(e -> {
            idField.clear();
            nameField.clear();
            deptField.clear();
            phoneField.clear();
        });
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(addBtn, saveBtn);
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title, grid, buttonBox);
        Scene scene = new Scene(root, 500, 350);
        stage.setTitle("Student Form");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}