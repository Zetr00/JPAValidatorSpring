package com.example.databasetable.repo;

import com.example.databasetable.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Long>  {
    UserModel findByName(String name);
}
