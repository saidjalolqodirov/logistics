package uz.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.logistics.dto.wagon.WagonCreateDTO;
import uz.logistics.dto.wagon.WagonUpdateDTO;
import uz.logistics.service.WagonService;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:31 AM
 */
@RestController
@RequestMapping("wagon/")
@RequiredArgsConstructor
public class WagonController {

    private final WagonService service;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody WagonCreateDTO dto) {
        return service.create(dto);
    }

    @PostMapping("/acceptance/{id}")
    private ResponseEntity<?> acceptance(@PathVariable Long id) {
        return service.acceptance(id);
    }

    @GetMapping("/getAll")
    private ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/getAllNewShipment")
    private ResponseEntity<?> getAllNewShipment() {
        return service.getAllNewShipment();
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody WagonUpdateDTO wagonUpdateDTO) {
        return service.update(wagonUpdateDTO);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/archived/{id}")
    private ResponseEntity<?> archived(@PathVariable Long id) {
        return service.archived(id);
    }

    @PutMapping("/archivedForChine/{id}")
    private ResponseEntity<?> archivedForChine(@PathVariable Long id) {
        return service.archivedForChine(id);
    }
}
