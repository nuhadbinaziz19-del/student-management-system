/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 *
 * @author Nuhad
 */
public class Utils {
    public static void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{11}");
    }
    public static boolean isValidID(String id) {
        return id.matches("\\d+");
    }
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }
    public static void exportStudents(List<String> students) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Student File");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files","*.txt")
            );
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(file)
                )) 
                {
                writer.println("===== STUDENT LIST =====");
                writer.println();                
                for (String s : students) {writer.println(s);
                }
                }
                showInfo("File Export Successful!");
            }
        } catch (IOException e) {
            showError("Export Failed!");
        }
    }
    public static void main(String[] args) {
        System.out.println(isValidPhone("017********"));
        System.out.println(isValidID("1005"));
        System.out.println(isValidName("Nuhad Bin Aziz"));
    }
}
