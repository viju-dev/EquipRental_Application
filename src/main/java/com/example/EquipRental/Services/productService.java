package com.example.EquipRental.Services;

import com.example.EquipRental.Convertors.productConvertor;
import com.example.EquipRental.EntryDtos.productEntryDto;
import com.example.EquipRental.Enums.categories;
import com.example.EquipRental.Models.Product;
import com.example.EquipRental.Repositories.productRepo;
import com.example.EquipRental.ResponseDtos.productResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {
    @Autowired
    productRepo productrepo;

    public void addProduct(productEntryDto entryDto) {
       Product product = productConvertor.EntryDtoToEntity(entryDto);
        productrepo.save(product);
    }

    public List<productResponseDto> getByCateAndDura(categories category, Double duration) {
        Product p1 = productrepo.findById(1).get();
        System.out.println(p1.getCategory().getClass());
//        categories ca = Enum.valueOf(category.toString());
        List<productResponseDto> list = new ArrayList<>();
        for (Product p : productrepo.findAllBycategory(category)){
            p.setPrice(duration*p.getPrice());
            list.add(productConvertor.EntityToResponseDto(p));
        }
        return list;
    }
}
