package com.example.thirdpract.controller;

import com.example.thirdpract.model.Employee;
import com.example.thirdpract.repository.OrderRepository;
import jakarta.validation.Valid;
import com.example.thirdpract.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order/new")
    public String showSignUpForm(@ModelAttribute Order order, Model model) {
        model.addAttribute("orders", order);
        return "add-order";
    }

    @GetMapping("/order/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
        model.addAttribute("order", order);
        return "update-order";
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id, Model model) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
        orderRepository.delete(order);
        model.addAttribute("orders", orderRepository.findAll());
        return "index";
    }

    @PostMapping("/order/addorder")
    public String addOrder(@Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-order";
        }

        orderRepository.save(order);
        model.addAttribute("orders", orderRepository.findAll());

        return "index";
    }

    @PostMapping("/order/update/{id}")
    public String updateOrder(@PathVariable("id") long id, @Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            order.setId(id);
            return "update-order";
        }

        orderRepository.save(order);
        model.addAttribute("orders", orderRepository.findAll());
        return "index";
    }
}