package com.example.EquipRental.Controllers;

import com.example.EquipRental.EntryDtos.bookingEntryDto;
import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.Services.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class bookingController {
    @Autowired
    bookingService bookingservice;

    @PostMapping("/CreateBooking")
    public ResponseEntity CreateBooking(@RequestBody bookingEntryDto bookReq){
        String str = bookingservice.CreateBooking(bookReq);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

}
