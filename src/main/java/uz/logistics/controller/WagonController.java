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

    @GetMapping("/getAll")
    private ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return service.getAll(page, size);
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody WagonUpdateDTO wagonUpdateDTO) {
        return service.update(wagonUpdateDTO);
    }
}
