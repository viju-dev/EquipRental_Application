package com.example.EquipRental.Services;

import com.example.EquipRental.Convertors.bookingConvertor;
import com.example.EquipRental.EntryDtos.bookingEntryDto;
import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.Models.Product;
import com.example.EquipRental.Repositories.bookingRepo;
import com.example.EquipRental.Repositories.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class bookingService {
    @Autowired
    bookingRepo bookingrepo;
    @Autowired
    productRepo productrepo;

    public String CreateBooking(bookingEntryDto bookReq) {
        Booking booking = bookingConvertor.EntryDtoToEntity(bookReq);
        Product product = productrepo.findByName(bookReq.getProductName());
        if (product.equals(null)){
            return "Product is not exist";
        }
        booking.setProduct(product);


        List<Booking> list = bookingrepo.findByproduct(product);

        for (Booking booking1 : list) {
            //booking from already booked
            Duration duration1 = Duration.ofHours((long) booking1.getDuration());
            LocalDate startDate1 = booking1.getDate();
            LocalTime startTime1 = booking1.getTime();
            LocalDateTime startDateTime1 = LocalDateTime.of(startDate1, startTime1);
            LocalDateTime endDateTime1 = startDateTime1.plus(duration1);

            //requested booking
            Duration duration2 = Duration.ofHours((long) booking.getDuration());
            LocalDate startDate2 = booking.getDate();
            LocalTime startTime2 = booking.getTime();
            LocalDateTime startDateTime2 = LocalDateTime.of(startDate2, startTime2);
            LocalDateTime endDateTime2 = startDateTime2.plus(duration2);

            System.out.println(startDateTime1 + "  " + endDateTime1);
            System.out.println(startDateTime2 + "  " + endDateTime2);

            if (startDateTime1.isBefore(endDateTime2) && startDateTime2.isBefore(endDateTime1)) {
                return "already booked for specific date and time";
            }
        }

        booking.setReqDateTime(LocalDateTime.now());
        product.getBookingList().add(booking);
        productrepo.save(product);
//        bookingrepo.save(booking);

        return "Product Booked SuccessFully";

    }

//    public boolean  isDateOverLapping(LocalDate startDate1,LocalDate endDate1, LocalDate startDate2, LocalDate endDate2){
//
//        return startDate1.isBefore(endDate2) || startDate2.isBefore(endDate1);
//    }
}
