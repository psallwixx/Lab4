package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByHouseIdAndStartDateBeforeAndEndDateAfter(Long houseId, LocalDate endDate, LocalDate startDate);
}
