package com.example.thirdpract.controller;

import com.example.thirdpract.model.Employee;
import com.example.thirdpract.repository.ProductRepository;
import jakarta.validation.Valid;
import com.example.thirdpract.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/product/new")
    public String showSignUpForm(@ModelAttribute Product product, Model model) {
        model.addAttribute("products", product);
        return "add-product";
    }

    @GetMapping("/product/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/product/addproduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());

        return "index";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "update-product";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }
}