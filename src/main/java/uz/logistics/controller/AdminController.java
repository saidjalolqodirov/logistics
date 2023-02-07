package uz.logistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.logistics.entity.Admin;
import uz.logistics.repository.AdminRepository;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/7/2023 12:47 PM
 */
@RestController
@RequestMapping("/api/login")
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin")
    public ResponseEntity<?> createAdmin() {
        Admin admin = new Admin();
        List<Admin> adminList = repository.findAll();
        if (adminList.isEmpty()) {
            admin.setId(1);
            admin.setUsername("admin");
            admin.setPassword("admin");
            Admin save = repository.save(admin);
            return ResponseEntity.ok(save);
        }
        return null;
    }
}
