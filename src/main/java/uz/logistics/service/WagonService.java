package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.logistics.dto.wagon.WagonCreateDTO;
import uz.logistics.dto.wagon.WagonUpdateDTO;
import uz.logistics.entity.Wagon;
import uz.logistics.repository.ProductRepository;
import uz.logistics.repository.WagonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:32 AM
 */
@Service
@RequiredArgsConstructor
public class WagonService {

    private final WagonRepository repository;

    private final ProductRepository productRepository;

    public ResponseEntity<?> create(WagonCreateDTO dto) {
        if (dto.getName().isBlank()) throw new NullPointerException();
        if (repository.existsByName(dto.getName().toUpperCase(Locale.ROOT)))
            return ResponseEntity.badRequest().body("this name already exist");
        Wagon mainWagon = repository.findByMainTrue();
        if (mainWagon != null) {
            mainWagon.setMain(false);
            repository.save(mainWagon);
        }
        Wagon wagon = new Wagon();
        wagon.setName(dto.getName().toUpperCase());
        wagon.setMain(true);
        return ResponseEntity.ok(repository.save(wagon));
    }

    public ResponseEntity<?> getAll() {
        List<Wagon> wagons = (List<Wagon>) repository.findAll();
        List<Wagon> wagonList = wagons.stream().filter(o -> (!o.isDeleted() && !o.isArchive())).sorted(Comparator.comparing(Wagon::getId)).collect(Collectors.toList());
        return new ResponseEntity<>(wagonList, HttpStatus.OK);
    }

    public ResponseEntity<?> update(WagonUpdateDTO dto) {
        Optional<Wagon> optionalWagon = repository.findById(dto.getId());
        if (optionalWagon.isEmpty()) return ResponseEntity.badRequest().body("wagon not found");
        Wagon wagon = optionalWagon.get();
        if (dto.isArchived()) {
            wagon.setArchive(true);
            return ResponseEntity.ok(repository.save(wagon));
        }
        if (repository.existsByName(dto.getName().toUpperCase()))
            return ResponseEntity.badRequest().body("this name already exist");
        wagon.setName(dto.getName().toUpperCase());
        return ResponseEntity.ok(repository.save(wagon));
    }

    public ResponseEntity<?> delete(Long id) {
        if (!productRepository.findByWagonId(id).isEmpty()) {
            return ResponseEntity.badRequest().body("wagon no empty");
        }
        Optional<Wagon> optionalWagon = repository.findById(id);
        if (optionalWagon.isEmpty()) return ResponseEntity.badRequest().body("wagon not found");
        Wagon wagon = optionalWagon.get();
        wagon.setDeleted(true);
        repository.save(wagon);
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<?> archived(Long id) {
        Optional<Wagon> optionalWagon = repository.findById(id);
        if (optionalWagon.isEmpty()) return ResponseEntity.badRequest().body("wagon not found");
        Wagon wagon = optionalWagon.get();
        wagon.setArchive(true);
        return ResponseEntity.ok(repository.save(wagon));
    }

    public ResponseEntity<?> archivedForChine(Long id) {
        Optional<Wagon> optionalWagon = repository.findById(id);
        if (optionalWagon.isEmpty()) return ResponseEntity.badRequest().body("wagon not found");
        Wagon wagon = optionalWagon.get();
        wagon.setArchivedForChine(true);
        return ResponseEntity.ok(repository.save(wagon));
    }
}
