package com.example.thirdpract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;

    @Min(value = 1, message = "Value must be greater than or equal to 1")
    @Max(value = 100, message = "Value must be less than or equal to 100")
    private int _productId;

    @Min(value = 1, message = "Value must be greater than or equal to 1")
    @Max(value = 100, message = "Value must be less than or equal to 100")
    private int _quantity;

    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "1000000.0", inclusive = true)
    private double _totalPrice;

    public Order() {}

    public Order(long id, int productId, int quantity, double totalPrice) {
        _id = id;
        _productId = productId;
        _quantity = quantity;
        _totalPrice = totalPrice;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public int getProductId() {
        return _productId;
    }

    public void setProductId(int productId) {
        this._productId = productId;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public double getTotalPrice() {
        return _totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this._totalPrice = totalPrice;
    }
}
