package com.example.EquipRental.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class bookingResponseDto {
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime reqDateTime;
    private double duration;
}
