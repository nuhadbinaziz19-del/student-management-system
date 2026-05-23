/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author Nuhad
 */
public class StudentFileHandler {
    public static void saveStudent(String data) {
        try {FileWriter writer = new FileWriter("students.txt", true);
            writer.write(data + "\n");
            writer.close();
            System.out.println("Student Saved");
        } catch (Exception e){e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Department: ");
        String dept = input.nextLine();
        System.out.print("Enter Phone: ");
        String phone = input.nextLine();
        String studentData = id + "," + name + "," + dept + "," + phone;
        saveStudent(studentData);
        System.out.println("Data Stored Successfully");
        input.close();
    }
}