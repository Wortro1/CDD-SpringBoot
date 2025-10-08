package com.CDD.GYM.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoDeDoc;
    private Integer taskTypeId;
}

