package com.example.thirdpract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 1, max = 50, message = "Имя должно содержать от 1 до 50 символов")
    private String _firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 1, max = 50, message = "Фамилия должна содержать от 1 до 50 символов")
    private String _lastName;
    @NotBlank(message = "Адрес не может быть пустой")
    @Size(min = 1, max = 50, message = "Адрес должен содержать от 1 до 50 символов")
    private String _address;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, String address) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
    }

    public long getId() {
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getAddress() {
        return _address;
    }

    public void setId(long id) {
        this._id = id;
    }

    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public void setAddress(String address) {
        this._address = address;
    }
}
