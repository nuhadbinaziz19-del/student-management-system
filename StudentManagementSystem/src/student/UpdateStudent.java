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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;
/**
 *
 * @author Nuhad
 */
public class UpdateStudent extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {
        Label title = new Label("UPDATE STUDENT");
        title.setStyle("-fx-font-size: 24px;"+"-fx-font-weight: bold;");
        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField deptField = new TextField();
        TextField phoneField = new TextField();
        Button updateBtn = new Button("Update");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("ID"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Name"), 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(new Label("Department"), 0, 2);
        grid.add(deptField, 1, 2);
        grid.add(new Label("Phone"), 0, 3);
        grid.add(phoneField, 1, 3);
        updateBtn.setOnAction(e -> {
            Student student = new Student(idField.getText(),nameField.getText(),deptField.getText(),phoneField.getText());
            StudentDAO dao = new StudentDAO();
            dao.updateStudent(student);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Student Updated Successfully!");
            alert.showAndWait();
            idField.clear();
            nameField.clear();
            deptField.clear();
            phoneField.clear();
        });
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title,grid,updateBtn);
        Scene scene = new Scene(root, 550, 450);
        stage.setTitle("Update Student");
        stage.setScene(scene);
        stage.show();
    }
}