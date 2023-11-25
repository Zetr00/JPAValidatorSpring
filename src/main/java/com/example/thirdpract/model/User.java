package com.example.thirdpract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;
    @NotBlank(message = "Никнейм не может быть пустым")
    @Size(min = 1, max = 50, message = "Никнейм должен содержать от 1 до 50 символов")
    private String _username;
    @NotBlank(message = "Почта не может быть пустой")
    @Size(min = 1, max = 50, message = "Почта должна содержать от 1 до 50 символов")
    private String _email;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 1, max = 50, message = "Пароль должен содержать от 1 до 50 символов")
    private String _password;

    public User(){}

    public User(long id, String username, String email, String password){
        _id = id;
        _username = username;
        _email = email;
        _password = password;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }
}
