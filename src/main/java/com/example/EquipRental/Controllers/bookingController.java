package com.example.EquipRental.Controllers;

import com.example.EquipRental.EntryDtos.bookingEntryDto;
import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.ResponseDtos.bookingResponseDto;
import com.example.EquipRental.Services.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class bookingController {
    @Autowired
    bookingService bookingservice;

    @PostMapping("/CreateBooking")//to create booking
    public ResponseEntity CreateBooking(@RequestBody bookingEntryDto bookReq){
        String str = bookingservice.CreateBooking(bookReq);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    @GetMapping("/get_all") //to get list of all booking
    public ResponseEntity get_all(){
        List<bookingResponseDto> list = bookingservice.get_all();
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

}
