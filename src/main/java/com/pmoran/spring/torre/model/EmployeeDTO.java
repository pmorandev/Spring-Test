package com.pmoran.spring.torre.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EmployeeDTO implements BaseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @JsonProperty("email")
    @NotEmpty
    @Email
    private String email;

    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("salary")
    @NotEmpty
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, String departmentName, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
        this.salary = salary;
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
