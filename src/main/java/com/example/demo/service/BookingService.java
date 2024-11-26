package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking createBooking(Booking booking) {
        // Add additional validation for date ranges, availability, etc.
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking booking = getBookingById(id);
        booking.setHouse(updatedBooking.getHouse());
        booking.setClient(updatedBooking.getClient());
        booking.setStartDate(updatedBooking.getStartDate());
        booking.setEndDate(updatedBooking.getEndDate());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> findConflictingBookings(Long houseId, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByHouseIdAndStartDateBeforeAndEndDateAfter(houseId, endDate, startDate);
    }
}
