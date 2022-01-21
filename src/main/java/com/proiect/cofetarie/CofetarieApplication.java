package com.proiect.cofetarie;

import com.proiect.cofetarie.model.Cake;
import com.proiect.cofetarie.model.CakeCategory;
import com.proiect.cofetarie.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CofetarieApplication implements CommandLineRunner {
    private final CakeCategoryRepository cakeCategoryRepository;
    private final CakeRepository cakeRepository;
    private final ClientRepository clientRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final OrderRepository orderRepository;

    public CofetarieApplication(CakeCategoryRepository cakeCategoryRepository, CakeRepository cakeRepository, ClientRepository clientRepository, DeliveryAddressRepository deliveryAddressRepository, OrderRepository orderRepository) {
        this.cakeCategoryRepository = cakeCategoryRepository;
        this.cakeRepository = cakeRepository;
        this.clientRepository = clientRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CofetarieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> allergens = new ArrayList<>();
        allergens.add("eggs");
        allergens.add("milk");
        allergens.add("nuts");

//        CakeCategory cheeseCakesCategory = new CakeCategory("cheese cakes", "cakes with cheese :)");
//        CakeCategory fruitCakesCategory = new CakeCategory("fruit cakes", "cakes with fruits :)");
//        CakeCategory italianCakesCategory = new CakeCategory("italian cakes", " :)");
//        CakeCategory whippedCreamCakesCategory = new CakeCategory("whipped cream cakes", " :)");
//        CakeCategory chocolateCakesCategory = new CakeCategory("chocolate cakes", " :)");
//
//        Cake cheesecake = new Cake("cheesecake", "-", allergens, 50, 1.8, cheeseCakesCategory);
//        Cake tiramisu = new Cake("tiramisu", "-", allergens, 50, 0.8, italianCakesCategory);
//        Cake diplomatCake = new Cake("diplomat cake", "", allergens, 70, 2.2, whippedCreamCakesCategory);
//
//
//        cakeRepository.save(cheesecake);
//        cakeRepository.save(tiramisu);
//        cakeRepository.save(diplomatCake);
    }
}
