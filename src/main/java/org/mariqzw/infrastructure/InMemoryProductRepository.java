package org.mariqzw.infrastructure;

import org.mariqzw.domain.IProductRepository;
import org.mariqzw.domain.Product;

import java.util.*;

public class InMemoryProductRepository implements IProductRepository {
    private final Map<UUID, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Optional<Product> getProduct(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void removeExpiredProducts() {
        products.values().removeIf(Product::isExpired);
    }
}
