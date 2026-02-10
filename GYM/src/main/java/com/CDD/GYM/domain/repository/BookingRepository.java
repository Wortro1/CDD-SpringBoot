package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.BookingDTO;

import java.util.List;

public interface BookingRepository {

    //crear reserva
    BookingDTO creatBooking(BookingDTO bookingDTO);

    List<BookingDTO> getAllBookings();

    BookingDTO getBookingById(Integer id);

    void deleteBooking(Integer id);

    BookingDTO updateBooking(Integer id, BookingDTO bookingDTO);
}
