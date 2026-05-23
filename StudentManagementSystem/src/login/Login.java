/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import dashboard.Dashboard;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Nuhad
 */
public class Login extends Application {
    public void start(Stage stage) {
        Label title = new Label("ADMIN LOGIN");
        title.setStyle("-fx-font-size: 24px;"+"-fx-font-weight: bold;");
        TextField username = new TextField();
        username.setPromptText("Enter Username");
        username.setMaxWidth(250);
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        password.setMaxWidth(250);
        Button loginBtn = new Button("LOGIN");
        loginBtn.setPrefWidth(120);
        loginBtn.setStyle("-fx-font-size: 14px;"+"-fx-font-weight: bold;");
        loginBtn.setOnAction(e -> {
            String user = username.getText();
            String pass = password.getText();
            if (user.equals("Nuhad")&& pass.equals("1234")) {
            try {Dashboard dashboard =new Dashboard();
            dashboard.start(new Stage());
            stage.close();
            } 
            catch (Exception ex){ex.printStackTrace();
            }
            }
            else {
                Alert alert =new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong Username or Password");
                alert.showAndWait();
            }
        });
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.getChildren().addAll(title,username,password,loginBtn);
        Scene scene =new Scene(root, 500,400);
        stage.setTitle("Login System");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}