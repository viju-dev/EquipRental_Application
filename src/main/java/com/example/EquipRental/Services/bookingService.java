package com.example.EquipRental.Services;

import com.example.EquipRental.Convertors.bookingConvertor;
import com.example.EquipRental.EntryDtos.bookingEntryDto;
import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.Models.Product;
import com.example.EquipRental.Repositories.bookingRepo;
import com.example.EquipRental.Repositories.productRepo;
import com.example.EquipRental.ResponseDtos.bookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
            LocalDate startDate1 = booking1.getDate(); // start date of booking
            LocalTime startTime1 = booking1.getTime(); // start time of booking
            LocalDateTime startDateTime1 = LocalDateTime.of(startDate1, startTime1); // combined both date and time
            LocalDateTime endDateTime1 = startDateTime1.plus(duration1); // end-datetime of booking
            //

            //requested booking
            Duration duration2 = Duration.ofHours((long) booking.getDuration());
            LocalDate startDate2 = booking.getDate(); // start date of booking
            LocalTime startTime2 = booking.getTime(); // start time of booking
            LocalDateTime startDateTime2 = LocalDateTime.of(startDate2, startTime2);// combined both date and time
            LocalDateTime endDateTime2 = startDateTime2.plus(duration2); // end-datetime of booking

//            System.out.println(startDateTime1 + "  " + endDateTime1);
//            System.out.println(startDateTime2 + "  " + endDateTime2);

            //comparing startDateTime and endDateTime of bookings to avoid date overlapping
            if (startDateTime1.isBefore(endDateTime2) && startDateTime2.isBefore(endDateTime1)) {
                return "Product already booked for specific date and time";
            }
        }

        //if date is not overlapping then we are accepting new booking
        booking.setReqDateTime(LocalDateTime.now());
        product.getBookingList().add(booking);
        productrepo.save(product); // saved product as they mapped with booking...booking will automatically get saved

        return "Product Booked SuccessFully";

    }

    public List<bookingResponseDto> get_all() {
        List<bookingResponseDto> list = new ArrayList<>();
        for (Booking b: bookingrepo.findAll()){
            list.add(bookingConvertor.EntityToResponseDto(b));
        }
        return list;
    }

}
