package com.CDD.GYM.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tipo_entrenamiento")
public class TipoEntrenamientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_entrenamiento")
    private Integer idTipoEntrenamiento;

    @Column(name = "nombre_tipo_entrenamiento", nullable = false)
    private String nombreTipoEntrenamiento;

    @Column(name = "descripcion_tipo_entrenamiento")
    private String descripcionTipoEntrenamiento;

    public TipoEntrenamientoEntity() {}


    public TipoEntrenamientoEntity(String nombreTipoEntrenamiento, String descripcionTipoEntrenamiento) {
        this.nombreTipoEntrenamiento = nombreTipoEntrenamiento;
        this.descripcionTipoEntrenamiento = descripcionTipoEntrenamiento;
    }

    public Integer getIdTipoEntrenamiento() {
        return idTipoEntrenamiento;
    }

    public void setIdTipoEntrenamiento(Integer idTipoEntrenamiento) {
        this.idTipoEntrenamiento = idTipoEntrenamiento;
    }

    public String getNombreTipoEntrenamiento() {
        return nombreTipoEntrenamiento;
    }

    public void setNombreTipoEntrenamiento(String nombreTipoEntrenamiento) {
        this.nombreTipoEntrenamiento = nombreTipoEntrenamiento;
    }

    public String getDescripcionTipoEntrenamiento() {
        return descripcionTipoEntrenamiento;
    }

    public void setDescripcionTipoEntrenamiento(String descripcionTipoEntrenamiento) {
        this.descripcionTipoEntrenamiento = descripcionTipoEntrenamiento;
    }
}
