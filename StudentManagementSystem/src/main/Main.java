/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import login.Login;
/**
 *
 * @author Nuhad
 */
public class Main extends Application {
    public void start(Stage primaryStage) {
        try {
            Login login = new Login();
            login.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}