package com.example.EquipRental.EntryDtos;

import com.example.EquipRental.Enums.categories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class productEntryDto {

    private String name;
    private String image;
    @Enumerated(EnumType.STRING)
    private categories category;
    private double price;
}
