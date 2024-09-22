package com.example.vacation.pay.calculator.controller;

import com.example.vacation.pay.calculator.dto.CalculateRequestDto;
import com.example.vacation.pay.calculator.dto.CalculateResponseDto;
import com.example.vacation.pay.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/calculate")
    public CalculateResponseDto calculate(
            @RequestBody CalculateRequestDto calculateRequestDto
    ) {
        return calculatorService.calculate(calculateRequestDto);
    }
}
