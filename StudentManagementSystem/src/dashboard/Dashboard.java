/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import student.StudentForm;
import student.SearchStudent;
import student.UpdateStudent;
import student.DeleteStudent;
import student.ViewStudents;
/**
 *
 * @author Nuhad
 */
public class Dashboard {
    public void start(Stage stage) {
        Button addBtn = new Button("Add Student");
        Button searchBtn = new Button("Search Student");
        Button updateBtn = new Button("Update Student");
        Button deleteBtn = new Button("Delete Student");
        Button viewBtn = new Button("View All Students");
        addBtn.setPrefWidth(150);
        searchBtn.setPrefWidth(150);
        updateBtn.setPrefWidth(150);
        deleteBtn.setPrefWidth(150);
        viewBtn.setPrefWidth(150);
        addBtn.setOnAction(e -> {
            StudentForm form = new StudentForm();
            form.start(new Stage());
        });
        searchBtn.setOnAction(e -> {
            SearchStudent search = new SearchStudent();
            search.start(new Stage());
        });
        updateBtn.setOnAction(e -> {
            UpdateStudent update = new UpdateStudent();
            update.start(new Stage());
        });
        deleteBtn.setOnAction(e -> {
            DeleteStudent delete = new DeleteStudent();
            delete.start(new Stage());
        });
        viewBtn.setOnAction(e -> {
            ViewStudents view = new ViewStudents();
            view.start(new Stage());
        });
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(addBtn,searchBtn,updateBtn,deleteBtn,viewBtn);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Student Management Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}