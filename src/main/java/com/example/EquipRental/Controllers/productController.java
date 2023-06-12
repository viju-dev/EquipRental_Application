package com.example.EquipRental.Controllers;

import com.example.EquipRental.EntryDtos.productEntryDto;
import com.example.EquipRental.Enums.categories;
import com.example.EquipRental.Models.Product;
import com.example.EquipRental.ResponseDtos.productResponseDto;
import com.example.EquipRental.Services.productService;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController

@RequestMapping("/products")
public class productController {
    @Autowired
    productService productservice;

    @PostMapping("/addProduct") // to create new product
    public ResponseEntity addProduct(@RequestBody productEntryDto product) {

        productservice.addProduct(product);
        return new ResponseEntity<>("Produc added successfully...!", HttpStatus.CREATED);
    }
    @PostMapping("/addImage") // to store image
    public ResponseEntity addImage( @RequestParam("image")MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return new ResponseEntity<>("Image file is empty...!", HttpStatus.NO_CONTENT);
        }
        else{
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(path);
        }
        return new ResponseEntity<>("Image saved successfully...!", HttpStatus.ACCEPTED);
    }


    @GetMapping("/getByCateAndDura") // to get all product by specific  category with pricing of provided duration
    public ResponseEntity getByCateAndDura(@RequestParam("category") String category, @RequestParam("duration") Double duration){
        categories cat = categories.valueOf(category);
        List<productResponseDto> list = productservice.getByCateAndDura(cat,duration);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

}
