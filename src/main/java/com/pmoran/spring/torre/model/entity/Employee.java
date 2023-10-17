package com.pmoran.spring.torre.model.entity;

import com.pmoran.spring.torre.model.BaseDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    //TODO Need relation after Making another class
    @Column(name = "department_name")
    private String departmentName;
    @Column(nullable = false)
    private double salary;

    public Employee(Long id, String name, String email, String departmentName, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
