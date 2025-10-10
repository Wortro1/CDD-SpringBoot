package com.CDD.GYM.persistence.mapper;


import com.CDD.GYM.domain.dto.BookingDTO;
import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.domain.repository.BookingRepository;
import com.CDD.GYM.persistence.crud.CrudAdmin;
import com.CDD.GYM.persistence.crud.CrudBooking;
import com.CDD.GYM.persistence.crud.CrudTipoEntrenamiento;
import com.CDD.GYM.persistence.crud.CrudUsuarioExterno;
import com.CDD.GYM.persistence.entity.AdminEntity;
import com.CDD.GYM.persistence.entity.BookEntity;
import com.CDD.GYM.persistence.entity.TipoEntrenamientoEntity;
import com.CDD.GYM.persistence.entity.UsuarioExternoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingEntityRepository implements BookingRepository {

   private final CrudTipoEntrenamiento crudTipoEntrenamiento;
   private final CrudUsuarioExterno crudUsuarioExterno;
   private final CrudAdmin crudAdmin;
   private final CrudBooking crudBooking;
   private final BookingMapper bookingMapper;

   public  BookingEntityRepository(CrudTipoEntrenamiento crudTipoEntrenamiento,CrudUsuarioExterno crudUsuarioExterno,
                                   CrudAdmin crudAdmin,CrudBooking crudBooking,BookingMapper bookingMapper ){
       this.crudTipoEntrenamiento=crudTipoEntrenamiento;
       this.crudUsuarioExterno=crudUsuarioExterno;
       this.crudAdmin=crudAdmin;
       this.crudBooking=crudBooking;
       this.bookingMapper=bookingMapper;
   }



    @Override
    public BookingDTO creatBooking(BookingDTO bookingDTO) {

        BookEntity entity = bookingMapper.toBookEntity(bookingDTO);


        TipoEntrenamientoEntity tipo = crudTipoEntrenamiento.findById(bookingDTO.training_type())
                .orElseThrow(() -> new RuntimeException("Tipo de entrenamiento no encontrado con id: " + bookingDTO.training_type()));

        UsuarioExternoEntity usuario = crudUsuarioExterno.findById(bookingDTO.user_id())
                .orElseThrow(() -> new RuntimeException("Usuario externo no encontrado con id: " + bookingDTO.user_id()));

        AdminEntity admin = crudAdmin.findById(bookingDTO.admin_id())
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado con id: " + bookingDTO.admin_id()));


        entity.setTipoEntrenamientoEntity(tipo);
        entity.setUsuarioExternoEntity(usuario);
        entity.setAdminEntity(admin);

        BookEntity saved = crudBooking.save(entity);
        return bookingMapper.toBookingDTO(saved);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookEntity> entities =(List<BookEntity>) crudBooking.findAll();

        return bookingMapper.toBookingDTOs(entities);
    }

    @Override
    public BookingDTO getBookingById(Integer id) {
       BookEntity entity = crudBooking.findById(id)
               .orElseThrow(()-> new RuntimeException("reserva no encontrada con id: "+id));
        return bookingMapper.toBookingDTO(entity);
    }

    @Override
    public void deleteBooking(Integer id) {
        if (crudBooking.existsById(id)){
            crudBooking.deleteById(id);
        }else {
            throw new RuntimeException("booking not found");
        }
    }



    @Override
    public BookingDTO updateBooking(Integer id, BookingDTO bookingDTO) {

        BookEntity reservaExistente = crudBooking.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con el ID: " + id));


        TipoEntrenamientoEntity tipo = crudTipoEntrenamiento.findById(bookingDTO.training_type())
                .orElseThrow(() -> new RuntimeException("Tipo de entrenamiento no encontrado"));

        UsuarioExternoEntity usuario = crudUsuarioExterno.findById(bookingDTO.user_id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        AdminEntity admin = crudAdmin.findById(bookingDTO.admin_id())
                .orElseThrow(() -> new RuntimeException("Admin no encontrado"));


        reservaExistente.setBookingDate(bookingDTO.booking_date());
        reservaExistente.setBookingHour(bookingDTO.booking_hour());
        reservaExistente.setTipoEntrenamientoEntity(tipo);
        reservaExistente.setUsuarioExternoEntity(usuario);
        reservaExistente.setAdminEntity(admin);


        BookEntity reservaActualizada = crudBooking.save(reservaExistente);


        return bookingMapper.toBookingDTO(reservaActualizada);
    }


}
