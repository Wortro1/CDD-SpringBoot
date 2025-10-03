// Archivo: com.CDD.GYM.web.controllers.UsuarioExternoController.java

package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.services.UsuarioExternoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/api/usuarios-externos")
public class UsuarioExternoController {

    private final UsuarioExternoService usuarioService;

    public UsuarioExternoController(UsuarioExternoService usuarioService) {
        this.usuarioService = usuarioService;
    }


    // http://localhost:8080/gym/api/usuarios-externos
    @PostMapping
    public UsuarioExternoDTO createUsuarioExterno(@RequestBody UsuarioExternoDTO usuarioDTO) {
        return usuarioService.createUsuarioExterno(usuarioDTO);
    }

    // http://localhost:8080/api/usuarios-externos/{id}
    @PutMapping("/{id}")
    public UsuarioExternoDTO updateUsuarioExterno(
            @PathVariable int id,
            @RequestBody UsuarioExternoDTO usuarioDTO
    ) {
        return usuarioService.updateUsuarioExterno(id, usuarioDTO);
    }


    //DELETE http://localhost:8080/api/usuarios-externos/{id}
    @DeleteMapping("/{id}")
    public void deleteUsuarioExterno(@PathVariable int id) {
        usuarioService.deleteUsuarioExterno(id);
    }
}