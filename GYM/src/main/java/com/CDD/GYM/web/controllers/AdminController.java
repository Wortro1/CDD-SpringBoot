package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.AdminDTO;
import com.CDD.GYM.domain.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/api/administrador")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    // http://localhost:8080/gym/api/administrador
    @PostMapping
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.createAdmin(adminDTO);
    }

    //http://localhost:8080/gym/api/administrador/alladmin
    @GetMapping("/alladmin")
    public List<AdminDTO> lookAllAdmin(){
        return this.adminService.lookAllAdmin();
    }

    // http://localhost:8080/gym/api/administrador/{id}
    @PutMapping("/{id}")
    public AdminDTO updateAdmin(
            @PathVariable int id,
            @RequestBody AdminDTO adminDTO
    ) {
        return adminService.updateAdmin(id, adminDTO);
    }


    //DELETE http://localhost:8080/gym/api/administrador/{id}
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }

}