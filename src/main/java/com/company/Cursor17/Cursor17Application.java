package com.company.Cursor17;

import com.company.Cursor17.Model.Laptop;
import com.company.Cursor17.Repository.LaptopRepository;
import com.company.Cursor17.Util.LaptopFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Cursor17Application implements CommandLineRunner {
    private final LaptopRepository repository;

    @Autowired
    public Cursor17Application(LaptopRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Cursor17Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final int quantityOfLaptops = 20;
        System.out.println("\nCreating new " + quantityOfLaptops + " laptops...");
        for (int i = 0; i < quantityOfLaptops - 1; i++) {
            Laptop laptop = LaptopFactory.createLaptop();
            repository.save(laptop);
        }
        System.out.println("All created laptops sorted by brand in descending order: ");
        for (Laptop laptop : repository.findByOrderByBrandDesc()) {
            System.out.println(laptop);
        }

        final int ramSize = 16;
        System.out.println("\nLaptops with RAM greater than " + ramSize + "GB :");
        for (Laptop laptop : repository.findLaptopsByRamGreaterThan(ramSize)) {
            System.out.println(laptop);
        }

        System.out.println("\nAll used laptops:");
        for (Laptop secondHandLaptop : repository.findLaptopsBySecondHandEquals(true)) {
            System.out.println(secondHandLaptop);
        }
    }
}
