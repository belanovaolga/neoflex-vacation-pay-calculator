package com.example.vacation.pay.calculator.service;

import com.example.vacation.pay.calculator.dto.CalculateRequestDto;
import com.example.vacation.pay.calculator.dto.CalculateResponseDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public CalculateResponseDto calculate(CalculateRequestDto calculateRequestDto) {
        List<LocalDate> vacationDays = new ArrayList<>();

        LocalDate dayOfVacation = calculateRequestDto.getStartDateOfVacation();

        while(dayOfVacation.isBefore(calculateRequestDto.getEndDateOfVacation())) {

            if(!vacationDay(dayOfVacation)) {
                vacationDays.add(dayOfVacation);
            }

            dayOfVacation = dayOfVacation.plusDays(1);
        }

        return CalculateResponseDto.builder()
                .sumSalary(calculateRequestDto.getSalary() * vacationDays.size())
                .build();
    }

    private boolean vacationDay(LocalDate dayOfVacation) {

        return WeekendsAndHolidays.holidays.contains(MonthDay.of(dayOfVacation.getMonth(), dayOfVacation.getDayOfMonth()))
                || WeekendsAndHolidays.weekends.contains(dayOfVacation.getDayOfWeek());
    }

    private static class WeekendsAndHolidays {
        protected static final Set<MonthDay> holidays = new HashSet<>();

        static {
            holidays.add(MonthDay.of(Month.JANUARY, 1));
            holidays.add(MonthDay.of(Month.JANUARY, 2));
            holidays.add(MonthDay.of(Month.JANUARY, 3));
            holidays.add(MonthDay.of(Month.JANUARY, 4));
            holidays.add(MonthDay.of(Month.JANUARY, 5));
            holidays.add(MonthDay.of(Month.JANUARY, 6));
            holidays.add(MonthDay.of(Month.JANUARY, 7));
            holidays.add(MonthDay.of(Month.JANUARY, 8));
            holidays.add(MonthDay.of(Month.FEBRUARY, 23));
            holidays.add(MonthDay.of(Month.MARCH, 8));
            holidays.add(MonthDay.of(Month.MAY, 1));
            holidays.add(MonthDay.of(Month.MAY, 9));
            holidays.add(MonthDay.of(Month.JUNE, 12));
            holidays.add(MonthDay.of(Month.NOVEMBER, 4));
        }

        protected static final Set<DayOfWeek> weekends = new HashSet<>();

        static {
            weekends.add(DayOfWeek.SATURDAY);
            weekends.add(DayOfWeek.SUNDAY);
        }
    }
}
