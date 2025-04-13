package org.mariqzw.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private LocalDate expirationDate;
    private String unitMeasure;
    private int quantity;

    public Product(UUID id, String name, LocalDate expirationDate, String unitMeasure, int quantity) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.unitMeasure = unitMeasure;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    public void decrementQuantity(int amount) {
        if (this.quantity > amount) this.quantity -= amount;
        else throw new IllegalArgumentException("Not enough quantity of product");
    }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", unitMeasure=" + unitMeasure +
                ", quantity=" + quantity +
                '}';
    }
}
