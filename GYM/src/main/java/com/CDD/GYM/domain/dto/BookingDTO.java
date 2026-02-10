package com.CDD.GYM.domain.dto;


import java.time.LocalDate;
import java.time.LocalTime;

public record BookingDTO(
  Integer id_booking,
  LocalDate booking_date,
  LocalTime booking_hour,
  Integer training_type,
  Integer user_id,
  Integer admin_id

) {
}
