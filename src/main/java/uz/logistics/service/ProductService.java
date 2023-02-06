package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.logistics.dto.ProductCreateDTO;
import uz.logistics.entity.Product;
import uz.logistics.repository.ProductRepository;

import java.util.Locale;

/**
 * @author: Saidjalol Qodirov 2/2/2023 7:56 AM
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ResponseEntity<?> create(ProductCreateDTO dto) {
        if (repository.existsByCode(dto.getCode().toUpperCase(Locale.ROOT)))
            return new ResponseEntity<>("this code already exist", HttpStatus.BAD_REQUEST);
        Product product = new Product();
        product.setCode(dto.getCode().toUpperCase());
        product.setPaid(dto.isPaid());
        product.setBoxPrice(dto.getBoxPrice());
        product.setCargoPrice(dto.getCargoPrice());
        product.setWeight(dto.getWeight());
        product.setWagonId(dto.getWagonId());
        return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
    }

    public ResponseEntity<?> getAll(Integer wagonId) {
        return new ResponseEntity<>(repository.findAllByWagonId(wagonId), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("ok");
    }
}
