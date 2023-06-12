package com.example.EquipRental.Convertors;

import com.example.EquipRental.EntryDtos.bookingEntryDto;
import com.example.EquipRental.Models.Booking;
import com.example.EquipRental.ResponseDtos.bookingResponseDto;

import java.awt.print.Book;
import java.time.LocalDateTime;

public class bookingConvertor {

    public static Booking EntryDtoToEntity(bookingEntryDto entryDto){ // to convert EntryDto to Entity

        Booking booking =Booking.builder().date(entryDto.getDate())
                        .time(entryDto.getTime())
                        .duration(entryDto.getDuration())
                        .reqDateTime(LocalDateTime.now())
                        .build();
        return booking;
    }
    public static bookingResponseDto EntityToResponseDto(Booking booking){ // to convert Entity to ResponseDto

        bookingResponseDto responseDto =bookingResponseDto.builder().date(booking.getDate())
                .time(booking.getTime())
                .duration(booking.getDuration())
                .reqDateTime(booking.getReqDateTime())
                .build();
        return responseDto;
    }
}
