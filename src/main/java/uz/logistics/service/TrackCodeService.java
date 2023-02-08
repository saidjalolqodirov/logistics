package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.logistics.dto.wagon.TrackCodeDTO;
import uz.logistics.entity.TrackCode;
import uz.logistics.entity.Wagon;
import uz.logistics.repository.TrackCodeRepository;
import uz.logistics.repository.WagonRepository;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/8/2023 5:43 PM
 */
@Service
@RequiredArgsConstructor
public class TrackCodeService {
    private final TrackCodeRepository repository;
    private final WagonRepository wagonRepository;


    public ResponseEntity<?> createTrackCode(TrackCodeDTO dto) {
        Optional<Wagon> optionalWagon = wagonRepository.findById(dto.getWagonId());
        if (optionalWagon.isEmpty()) return ResponseEntity.badRequest().body("wagon not found");

        if (repository.existsByCode(dto.getCode().toUpperCase()))
            return ResponseEntity.badRequest().body("code already exist");

        TrackCode trackCode = new TrackCode();
        trackCode.setCode(dto.getCode().toUpperCase());
        trackCode.setWagonId(dto.getWagonId());

        return ResponseEntity.ok(repository.save(trackCode));
    }

    public ResponseEntity<?> getAllByWagonId(Long id) {
        return ResponseEntity.ok(repository.findAllByWagonId(id));
    }
}
