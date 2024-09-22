package com.example.vacation.pay.calculator.service;

import com.example.vacation.pay.calculator.dto.CalculateRequestDto;
import com.example.vacation.pay.calculator.dto.CalculateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceImplTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void shouldSuccessCalculateWhenHoliday() {
        var calculatorDto = CalculateRequestDto
                .builder()
                .salary(750.0)
                .startDateOfVacation(LocalDate.of(2024, 1, 1))
                .endDateOfVacation(LocalDate.of(2024, 1, 2))
                .build();

        CalculateResponseDto result = calculatorService.calculate(calculatorDto);

        assertEquals(result.getSumSalary(), 0.0);
    }

    @Test
    void shouldSuccessCalculateWhenWeekend() {
        var calculatorDto = CalculateRequestDto
                .builder()
                .salary(750.0)
                .startDateOfVacation(LocalDate.of(2024, 9, 21))
                .endDateOfVacation(LocalDate.of(2024, 9, 22))
                .build();

        CalculateResponseDto result = calculatorService.calculate(calculatorDto);

        assertEquals(result.getSumSalary(), 0.0);
    }

    @Test
    void shouldSuccessCalculateWhenWorkingDay() {
        var calculatorDto = CalculateRequestDto
                .builder()
                .salary(750.0)
                .startDateOfVacation(LocalDate.of(2024, 9, 12))
                .endDateOfVacation(LocalDate.of(2024, 9, 13))
                .build();

        CalculateResponseDto result = calculatorService.calculate(calculatorDto);

        assertEquals(result.getSumSalary(), 750.0);
    }
}
