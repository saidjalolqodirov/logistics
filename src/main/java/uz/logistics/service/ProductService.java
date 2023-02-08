package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.logistics.dto.product.ProductCreateDTO;
import uz.logistics.dto.product.ProductUpdateDTO;
import uz.logistics.entity.Product;
import uz.logistics.repository.ProductRepository;

import java.util.Locale;
import java.util.Optional;

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

    public ResponseEntity<?> getAll(Long wagonId) {
        return new ResponseEntity<>(repository.findByWagonId(wagonId), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<?> update(ProductUpdateDTO updateDTO) {
        Optional<Product> optionalProduct = repository.findById(updateDTO.getId());
        if (optionalProduct.isEmpty())
            return ResponseEntity.badRequest().body("not found");
        if (updateDTO.getCode().isBlank())
            return ResponseEntity.badRequest().body("name is empty");
        Product product = optionalProduct.get();
        if (!product.getCode().equalsIgnoreCase(updateDTO.getCode())) {
            if (repository.existsByCode(updateDTO.getCode().toUpperCase())) {
                return ResponseEntity.badRequest().body("this code already exist");
            }
            product.setCode(updateDTO.getCode());
        }
        return ResponseEntity.ok(repository.save(product));
    }
}
