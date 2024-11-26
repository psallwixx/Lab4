package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.util.ConveniencePricing;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class StatisticsService {
    private final BookingRepository bookingRepository;

    public StatisticsService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public int calculateTotalIncome() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().mapToInt(booking -> {
            int income = booking.getHouse().getConveniences().stream()
                    .mapToInt(ConveniencePricing::getPrice) // Отримуємо ціну з словника
                    .sum();
            if (booking.getStartDate().getMonth() == Month.NOVEMBER || booking.getStartDate().getMonth() == Month.MARCH) {
                income *= 0.8; // Apply 20% discount
            }
            return income;
        }).sum();
    }

    public int calculateTotalExpenses() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().mapToInt(booking ->
                booking.getHouse().getConveniences().stream()
                        .mapToInt(convenience -> ConveniencePricing.getPrice(convenience) / 2) // Витрати — половина ціни
                        .sum()).sum();
    }
}
