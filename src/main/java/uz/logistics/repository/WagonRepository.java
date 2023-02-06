package uz.logistics.repository;

import org.springframework.data.repository.CrudRepository;
import uz.logistics.entity.Wagon;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:29 AM
 */
public interface WagonRepository extends CrudRepository<Wagon, Integer> {
    boolean existsByName(String name);

}
