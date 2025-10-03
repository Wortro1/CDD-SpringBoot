package com.CDD.GYM.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonaEntity {

    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoDeDoc;

    public PersonaEntity() {
    }

    // Constructor con parámetros
    public PersonaEntity(int id, String nombre, String apellido, String telefono, String tipoDeDoc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoDeDoc = tipoDeDoc;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoDeDoc() { return tipoDeDoc; }
    public void setTipoDeDoc(String tipoDeDoc) { this.tipoDeDoc = tipoDeDoc; }

}
