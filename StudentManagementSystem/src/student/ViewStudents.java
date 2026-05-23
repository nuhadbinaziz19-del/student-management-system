/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;
import database.DBConnection;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Nuhad
 */
public class ViewStudents {
    public void start(Stage stage) {
        TextArea area = new TextArea();
        try {Connection con =DBConnection.getConnection();
        Statement st =con.createStatement();
        ResultSet rs =st.executeQuery("SELECT * FROM students");
        while (rs.next()) {
        area.appendText("ID: " + rs.getString("id")+"\nName: " + rs.getString("name")+"\nDepartment: " + rs.getString("department")+"\nPhone: " + rs.getString("phone")+"\n----------------------\n");
        }
        }
        catch (Exception e) {e.printStackTrace();
        }
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().add(area);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("All Students");
        stage.setScene(scene);
        stage.show();
    }
}