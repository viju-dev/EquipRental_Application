package com.example.EquipRental.ResponseDtos;

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
public class productResponseDto {

    private String name;
    private String image;
    private categories category;
    private double price;
}
