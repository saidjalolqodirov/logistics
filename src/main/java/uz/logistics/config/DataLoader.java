package uz.logistics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import uz.logistics.entity.Admin;
import uz.logistics.repository.AdminRepository;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/4/2023 8:31 PM
 */
@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;

    private final PasswordEncoderI passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Admin> adminList = adminRepository.findAll();
        if (adminList.isEmpty()) {
            Admin admin = new Admin();
            admin.setId(1);
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.passwordEncoder().encode("admin"));
            adminRepository.save(admin);
        }
    }
}
