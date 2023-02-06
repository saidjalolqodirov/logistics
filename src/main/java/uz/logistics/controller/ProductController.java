package uz.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.logistics.dto.ProductCreateDTO;
import uz.logistics.service.ProductService;

/**
 * @author: Saidjalol Qodirov 2/2/2023 7:55 AM
 */
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam Integer wagonId) {
        return service.getAll(wagonId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id ) {
        return service.deleteById(id);
    }
}
