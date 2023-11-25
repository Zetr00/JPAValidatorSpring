package com.example.thirdpract.controller;

import com.example.thirdpract.model.Customer;
import com.example.thirdpract.repository.EmployeeRepository;
import com.example.thirdpract.repository.CustomerRepository;
import com.example.thirdpract.repository.OrderRepository;
import com.example.thirdpract.repository.ProductRepository;
import com.example.thirdpract.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public MainController(EmployeeRepository employeeRepository,
                          CustomerRepository customerRepository,
                          OrderRepository orderRepository,
                          ProductRepository productRepository,
                          UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    String getHome(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
