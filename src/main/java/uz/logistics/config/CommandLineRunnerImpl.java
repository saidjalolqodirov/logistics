package uz.logistics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.logistics.entity.Admin;
import uz.logistics.repository.AdminRepository;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/7/2023 12:34 PM
 */
@Configuration
@RequiredArgsConstructor
public class CommandLineRunnerImpl {

    private final AdminRepository repository;

    @Bean
    public void createAdmin() {
        List<Admin> adminList = repository.findAll();
        if (adminList.isEmpty()) {
            Admin admin = new Admin();
            admin.setId(1);
            admin.setUsername("admin");
            admin.setPassword("admin");
            repository.save(admin);
        }
    }
}
