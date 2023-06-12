package com.example.EquipRental.Models;

import com.example.EquipRental.Enums.categories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;
    private String image;
    @Enumerated(EnumType.STRING)
    private categories category;
    private double price;
//    private LocalDate date;
//    private LocalTime time;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Booking> bookingList = new ArrayList<>();
}
