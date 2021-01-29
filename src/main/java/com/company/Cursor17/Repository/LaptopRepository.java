package com.company.Cursor17.Repository;

import com.company.Cursor17.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    List<Laptop> findByOrderByBrandDesc();

    List<Laptop> findLaptopsByRamGreaterThan(Integer ramSize);

    List<Laptop> findLaptopsBySecondHandEquals(Boolean secondHand);
}
