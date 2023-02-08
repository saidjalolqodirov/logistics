package uz.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.logistics.dto.product.ProductCreateDTO;
import uz.logistics.dto.product.ProductUpdateDTO;
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
    public ResponseEntity<?> getAll(@RequestParam Long wagonId) {
        return service.getAll(wagonId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }
}
