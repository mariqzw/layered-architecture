package org.mariqzw.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepository {
    void addProduct(Product product);
    Optional<Product> getProduct(UUID id);
    List<Product> findAllProducts();
    void removeExpiredProducts();
}
