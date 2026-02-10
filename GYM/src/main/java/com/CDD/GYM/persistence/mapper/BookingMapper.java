
package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.BookingDTO;
import com.CDD.GYM.persistence.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {


    @Mapping(source = "idBooking", target = "id_booking")
    @Mapping(source = "bookingDate", target = "booking_date")
    @Mapping(source = "bookingHour", target = "booking_hour")
    @Mapping(source = "tipoEntrenamientoEntity.idTipoEntrenamiento", target = "training_type")
    @Mapping(source = "usuarioExternoEntity.id", target = "user_id")
    @Mapping(source = "adminEntity.id", target = "admin_id")
    BookingDTO toBookingDTO(BookEntity entity);

    List<BookingDTO> toBookingDTOs(Iterable<BookEntity> entities);


    @InheritInverseConfiguration
    @Mapping(target = "tipoEntrenamientoEntity", ignore = true)
    @Mapping(target = "usuarioExternoEntity", ignore = true)
    @Mapping(target = "adminEntity", ignore = true)
    BookEntity toBookEntity(BookingDTO dto);
}



