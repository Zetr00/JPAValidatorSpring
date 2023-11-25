package com.example.thirdpract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 1, max = 50, message = "Имя должно содержать от 1 до 50 символов")
    private String _name;
    @NotBlank(message = "Должность не может быть пустой")
    @Size(min = 1, max = 50, message = "Должность должна содержать от 1 до 50 символов")
    private String _position;

    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "1000000.0", inclusive = true)
    private double _salary;

    public Employee() {}

    public Employee(long id, String name, String position, double salary) {
        _id = id;
        _name = name;
        _position = position;
        _salary = salary;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPosition() {
        return _position;
    }

    public void setPosition(String position) {
        this._position = position;
    }

    public double getSalary() {
        return _salary;
    }

    public void setSalary(double salary) {
        this._salary = salary;
    }
}
