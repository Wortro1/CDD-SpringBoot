// Archivo: com.CDD.GYM.web.controllers.UsuarioExternoController.java

package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.services.UsuarioExternoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

    // http://localhost:8080/gym/api/usuarios-externos/{id}
    @PutMapping("/{id}")
    public UsuarioExternoDTO updateUsuarioExterno(
            @PathVariable int id,
            @RequestBody UsuarioExternoDTO usuarioDTO
    ) {
        return usuarioService.updateUsuarioExterno(id, usuarioDTO);
    }

    // GET http://localhost:8080/gym/api/usuarios-externos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioExternoDTO> getUsuarioExternoById(@PathVariable Integer id) {

        UsuarioExternoDTO usuario = usuarioService.findUserById(id);

        // Retorna 200 OK con el DTO (el manejo del error 404 está en el servicio)
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    //DELETE http://localhost:8080/gym/api/usuarios-externos/{id}
    @DeleteMapping("/{id}")
    public void deleteUsuarioExterno(@PathVariable int id) {
        usuarioService.deleteUsuarioExterno(id);
    }
}