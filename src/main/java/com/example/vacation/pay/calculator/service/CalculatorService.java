package com.example.vacation.pay.calculator.service;

import com.example.vacation.pay.calculator.dto.CalculateRequestDto;
import com.example.vacation.pay.calculator.dto.CalculateResponseDto;

public interface CalculatorService {
    CalculateResponseDto calculate(CalculateRequestDto calculateRequestDto);
}
