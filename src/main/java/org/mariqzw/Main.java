package org.mariqzw;

import org.mariqzw.application.RestaurantService;
import org.mariqzw.domain.IProductRepository;
import org.mariqzw.infrastructure.InMemoryProductRepository;
import org.mariqzw.presentation.ConsoleApp;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        IProductRepository productRepository = new InMemoryProductRepository();

        RestaurantService restaurantService = new RestaurantService(productRepository);

        restaurantService.addProduct("Хлеб", LocalDate.now().plusDays(5), "шт", 10);
        restaurantService.addProduct("Молоко", LocalDate.now().plusDays(7), "л", 20);
        restaurantService.addProduct("Сыр", LocalDate.now().plusDays(9), "кг", 30);
        restaurantService.addProduct("Бананы", LocalDate.now().plusDays(10), "кг", 20);
        restaurantService.addProduct("Мука", LocalDate.now().plusDays(30), "кг", 50);
        restaurantService.addProduct("Яйца", LocalDate.now().plusDays(21), "шт", 50);

        ConsoleApp ui = new ConsoleApp(restaurantService);

        ui.start();
    }
}