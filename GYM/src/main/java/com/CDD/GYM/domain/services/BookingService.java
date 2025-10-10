package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.BookingDTO;
import com.CDD.GYM.domain.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService{

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    public BookingDTO creatBooking(BookingDTO bookingDTO){
        return bookingRepository.creatBooking(bookingDTO);
    }

    public List<BookingDTO> getAllBookings(){
        return bookingRepository.getAllBookings();
    }

    public BookingDTO getBookingById(Integer id){
        return bookingRepository.getBookingById(id);
    }

   public void deleteBooking(Integer id){
        bookingRepository.deleteBooking(id);
   }

   public BookingDTO updateBooking(Integer id,BookingDTO bookingDTO){
        return bookingRepository.updateBooking(id,bookingDTO);
   }
}
