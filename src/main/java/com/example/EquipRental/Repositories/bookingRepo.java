package com.example.EquipRental.Repositories;

import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookingRepo extends JpaRepository<Booking,Integer> {
//    List<Booking> findBydateAndproduct(LocalDate date, Product product);

    List<Booking> findByproduct(Product product);
}
