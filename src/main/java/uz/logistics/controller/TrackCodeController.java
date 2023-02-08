package uz.logistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.logistics.dto.wagon.TrackCodeDTO;
import uz.logistics.service.TrackCodeService;

/**
 * @author: Saidjalol Qodirov 2/8/2023 5:42 PM
 */
@RestController
@RequestMapping("/trackCode")
public class TrackCodeController {

    private final TrackCodeService service;

    public TrackCodeController(TrackCodeService service) {
        this.service = service;
    }

    @PostMapping("/create/trackCode")
    private ResponseEntity<?> createTrackCode(@RequestBody TrackCodeDTO dto) {
        return service.createTrackCode(dto);
    }

    @GetMapping("/getAllByWagonId/{id}")
    public ResponseEntity<?> getAllByWagonId(@PathVariable Long id) {
        return service.getAllByWagonId(id);
    }

}
