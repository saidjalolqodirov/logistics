package uz.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.logistics.entity.TrackCode;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/8/2023 5:41 PM
 */
public interface TrackCodeRepository extends JpaRepository<TrackCode, Long> {
    boolean existsByCode(String code);

    List<TrackCode> findAllByWagonId(Long id);
}
