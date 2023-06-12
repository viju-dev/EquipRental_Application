package com.example.EquipRental.Convertors;

import com.example.EquipRental.EntryDtos.productEntryDto;
import com.example.EquipRental.Models.Product;
import com.example.EquipRental.ResponseDtos.productResponseDto;

public class productConvertor {

    public static productResponseDto EntityToResponseDto(Product product){

        productResponseDto responseDto = productResponseDto.builder()
                .name(product.getName())
                .image(product.getImage())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();

        return responseDto;
    }

    public static Product EntryDtoToEntity(productEntryDto entryDto){

        Product product = Product.builder()
                .name(entryDto.getName())
                .image(entryDto.getImage())
                .category(entryDto.getCategory())
                .price(entryDto.getPrice())
                .build();

        return product;
    }

}
