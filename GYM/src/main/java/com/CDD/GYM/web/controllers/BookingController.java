package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.BookingDTO;
import com.CDD.GYM.domain.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gym/api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    //http://localhost:8080/gym/api/booking/create_booking
    @PostMapping("/create_booking")
    public BookingDTO creatBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.creatBooking(bookingDTO);
    }

    //http://localhost:8080/gym/api/booking/all_bookings
    @GetMapping("/all_bookings")
    public List<BookingDTO> getAllBookings(){
        return this.bookingService.getAllBookings();
    }

    //http://localhost:8080/gym/api/booking/boking_by_id/{id}
    @GetMapping("/boking_by_id/{id}")
    public BookingDTO lookBookingByiId(@PathVariable Integer id){
        return bookingService.getBookingById(id);
    }

    //http://localhost:8080/gym/api/booking/delete_booking/{id}
   @DeleteMapping("/delete_booking/{id}")
    public void deleteBooking(@PathVariable Integer id){
        bookingService.deleteBooking(id);
   }

    //http://localhost:8080/gym/api/booking/update/{id}
   @PutMapping ("/update/{id}")
    public BookingDTO updateBooking(@PathVariable Integer id,@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(id,bookingDTO);
   }
}
