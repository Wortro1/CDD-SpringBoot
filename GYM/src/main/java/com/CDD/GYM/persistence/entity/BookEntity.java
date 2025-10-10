package com.CDD.GYM.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @Column (name = "booking_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooking;

    @Column (name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column (name = "booking_hour", nullable = false)
    private LocalTime bookingHour;

    @ManyToOne
    @JoinColumn(name ="id_tipo_entrenamiento",nullable = false)
    private TipoEntrenamientoEntity tipoEntrenamientoEntity;

    @ManyToOne
    @JoinColumn(name= "id_usuario_externo", nullable = false)
    private UsuarioExternoEntity usuarioExternoEntity;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id",nullable = false)
    private AdminEntity adminEntity;

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingHour() {
        return bookingHour;
    }

    public void setBookingHour(LocalTime bookingHour) {
        this.bookingHour = bookingHour;
    }

    public TipoEntrenamientoEntity getTipoEntrenamientoEntity() {
        return tipoEntrenamientoEntity;
    }

    public void setTipoEntrenamientoEntity(TipoEntrenamientoEntity tipoEntrenamientoEntity) {
        this.tipoEntrenamientoEntity = tipoEntrenamientoEntity;
    }

    public UsuarioExternoEntity getUsuarioExternoEntity() {
        return usuarioExternoEntity;
    }

    public void setUsuarioExternoEntity(UsuarioExternoEntity usuarioExternoEntity) {
        this.usuarioExternoEntity = usuarioExternoEntity;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }
}
