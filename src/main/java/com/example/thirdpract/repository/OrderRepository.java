package com.example.thirdpract.repository;

import com.example.thirdpract.model.Customer;
import com.example.thirdpract.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
