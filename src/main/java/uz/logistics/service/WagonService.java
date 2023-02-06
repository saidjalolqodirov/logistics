package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.logistics.criteria.ResponsePage;
import uz.logistics.dto.WagonCreateDTO;
import uz.logistics.entity.Wagon;
import uz.logistics.repository.WagonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:32 AM
 */
@Service
@RequiredArgsConstructor
public class WagonService {

    private final WagonRepository repository;

    public ResponseEntity<?> create(WagonCreateDTO dto) {
        if (dto.getName().isBlank()) throw new NullPointerException();
        if (repository.existsByName(dto.getName().toUpperCase(Locale.ROOT)))
            throw new RuntimeException("this name already exist");
        Wagon wagon = new Wagon();
        wagon.setName(dto.getName().toUpperCase());
        return ResponseEntity.ok(repository.save(wagon));
    }

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        List<Wagon> wagons = (List<Wagon>) repository.findAll();
        int totalCount = wagons.size();
        List<Wagon> wagonList = wagons.stream().sorted(Comparator.comparing(Wagon::getId)).skip((long) page * size).limit((long) size).collect(Collectors.toList());
        ResponsePage<Wagon> wagonResponsePage = ResponsePage.<Wagon>builder().content(wagonList).totalElements(totalCount).size(size).number(page).build();
        return new ResponseEntity<>(wagonResponsePage, HttpStatus.OK);
    }
}
