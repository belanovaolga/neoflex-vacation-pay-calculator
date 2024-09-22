package com.example.vacation.pay.calculator.dto;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateRequestDto {
    private Double salary;
    private LocalDate startDateOfVacation;
    private LocalDate endDateOfVacation;
}
