package com.CDD.GYM.domain.dto;

import java.time.LocalDate;

public record UsuarioExternoDTO(
        Integer id,
        String nombre,
        String apellido,
        String telefono,
        String tipoDeDoc,
        String numberCc,
        LocalDate fechaDeNacimiento,
        boolean haciendoMusculacion,
        boolean esDeportistaActivo
) {
}
