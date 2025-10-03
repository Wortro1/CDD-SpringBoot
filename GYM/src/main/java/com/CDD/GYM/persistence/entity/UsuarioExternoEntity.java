package com.CDD.GYM.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "usuario_externo")
public class UsuarioExternoEntity extends PersonaEntity {

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "haciendo_musculacion", nullable = false)
    private boolean haciendoMusculacion;

    @Column(name = "es_deportista_activo", nullable = false)
    private boolean esDeportistaActivo;

    public UsuarioExternoEntity() {}

    public UsuarioExternoEntity(
            int id,
            String nombre,
            String apellido,
            String telefono,
            String tipoDeDoc,
            LocalDate fechaNacimiento,
            boolean haciendoMusculacion,
            boolean esDeportistaActivo
    ) {
        super(id, nombre, apellido, telefono, tipoDeDoc);
        this.fechaNacimiento = fechaNacimiento;
        this.haciendoMusculacion = haciendoMusculacion;
        this.esDeportistaActivo = esDeportistaActivo;
    }

    // Getters y setters
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isHaciendoMusculacion() {
        return haciendoMusculacion;
    }

    public void setHaciendoMusculacion(boolean haciendoMusculacion) {
        this.haciendoMusculacion = haciendoMusculacion;
    }

    public boolean isEsDeportistaActivo() {
        return esDeportistaActivo;
    }

    public void setEsDeportistaActivo(boolean esDeportistaActivo) {
        this.esDeportistaActivo = esDeportistaActivo;
    }
}
