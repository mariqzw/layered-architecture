package org.mariqzw.application;

import org.mariqzw.domain.IProductRepository;
import org.mariqzw.domain.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantService {
    private final IProductRepository productRepository;

    public RestaurantService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name, LocalDate expirationDate, String unitMeasure, int quantity) {
        Product product = new Product(UUID.randomUUID(), name, expirationDate, unitMeasure, quantity);
        productRepository.addProduct(product);
    }

    public void useProduct(UUID id, int quantity) {
        Optional<Product> product = productRepository.getProduct(id);
        if (product.isEmpty()) throw new IllegalArgumentException("Product not found");
        product.get().decrementQuantity(quantity);
    }

    public void removeExpiredProducts() {
        productRepository.removeExpiredProducts();
    }

    public void performInventoryCorrection(UUID id, int newQuantity) {
        Optional<Product> productOpt = productRepository.getProduct(id);
        if (productOpt.isEmpty()) throw new IllegalArgumentException("Продукт не найден");

        Product product = productOpt.get();
        int delta = newQuantity - product.getQuantity();
        if (delta > 0) product.incrementQuantity(delta);
        else product.decrementQuantity(-delta);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public List<Product> getCriticalStockProducts(int threshold) {
        return productRepository.findAllProducts().stream()
                .filter(p -> p.getQuantity() <= threshold)
                .toList();
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.getProduct(id);
    }
}
