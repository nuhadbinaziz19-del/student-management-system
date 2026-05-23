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
import model.Student;
/**
 *
 * @author Nuhad
 */
public class SearchStudent extends Application {
    public void start(Stage stage) {
        Label title = new Label("SEARCH STUDENT");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e -> {
        StudentDAO dao = new StudentDAO();
        Student s = dao.searchStudent(idField.getText().trim());
        if (s != null) {resultArea.setText("===== STUDENT INFO=====\n"+"ID:"+s.getId()+"\n"+"Name:"+s.getName()+"\n"+"Department:"+s.getDepartment()+ "\n"+"Phone: " + s.getPhone());
        }
        else {
        resultArea.setText("❌ Student Not Found!");
        }
        });
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title, idField, searchBtn, resultArea);
        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Search Student");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}