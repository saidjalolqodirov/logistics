package uz.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.logistics.entity.Product;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/2/2023 7:56 AM
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCode(String code);

    List<Product> findByWagonId(Long id);
}
