/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package model;
/**
 *
 * @author Nuhad
 */
public class Student {
    private String id;
    private String name;
    private String department;
    private String phone;
    public Student(String id,String name, String department,String phone) {
       this.id = id;
       this.name = name;
       this.department = department;
       this.phone = phone;
    }
    public String getId() {
       return id;
    }
    public String getName() {
       return name;
    }
    public String getDepartment() {
       return department;
    }
    public String getPhone() {
      return phone;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
    this.department = department;
    }
    public void setPhone(String phone) {
    this.phone = phone;
    }
    public String toString() {
    return "Student{"+"ID='"+id+'\''+",Name='"+name+'\''+",Department='"+department+'\''+",Phone='"+phone+'\''+'}';
    }
}