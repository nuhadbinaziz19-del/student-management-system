/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Nuhad
 */
public class StudentDAO {
    public void addStudent(Student s) {
        String sql = "INSERT INTO students(id,name,department,phone) VALUES(?,?,?,?)";
        try {Connection con =DBConnection.getConnection();
        PreparedStatement pst =con.prepareStatement(sql);
            pst.setString(1, s.getId());
            pst.setString(2, s.getName());
            pst.setString(3, s.getDepartment());
            pst.setString(4, s.getPhone());
            pst.executeUpdate();
            System.out.println("Student Added");
        } catch (Exception e){e.printStackTrace();
        }
    }
    public Student searchStudent(String id) {
        String sql ="SELECT * FROM students WHERE id=?";
        try { Connection con =DBConnection.getConnection();
        PreparedStatement pst =con.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs =pst.executeQuery();
        if (rs.next()){
        return new Student(rs.getString("id"),rs.getString("name"),rs.getString("department"),rs.getString("phone"));
        }
        } catch (Exception e){e.printStackTrace();
        }
        return null;
        }
        public void updateStudent(Student s) {
        String sql ="UPDATE students SET name=?, department=?, phone=? WHERE id=?";
        try {Connection con =DBConnection.getConnection();
        PreparedStatement pst =con.prepareStatement(sql);
            pst.setString(1, s.getName());
            pst.setString(2, s.getDepartment());
            pst.setString(3, s.getPhone());
            pst.setString(4, s.getId());
            pst.executeUpdate();
            System.out.println("Student Updated");
        } catch (Exception e) {e.printStackTrace();
        }
    }
    public void deleteStudent(String id) {
        String sql ="DELETE FROM students WHERE id=?";
        try {Connection con =DBConnection.getConnection();
        PreparedStatement pst =con.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
            System.out.println("Student Deleted");
        } catch (Exception e) {e.printStackTrace();
        }
    }
}