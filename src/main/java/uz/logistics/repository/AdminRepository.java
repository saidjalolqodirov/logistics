package uz.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.logistics.entity.Admin;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/4/2023 10:52 AM
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);
}
