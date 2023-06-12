package com.example.EquipRental.Repositories;


import com.example.EquipRental.Enums.categories;
import com.example.EquipRental.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepo extends JpaRepository<Product,Integer> {
    List<Product> findAllBycategory(categories category);

    Product findByName(String productName);
}
