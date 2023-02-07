package uz.logistics.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import uz.logistics.repository.AdminRepository;

/**
 * @author: Saidjalol Qodirov 2/4/2023 8:31 PM
 */
//@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
//        List<Admin> adminList = adminRepository.findAll();
//        if (adminList.isEmpty()) {
//            Admin admin = new Admin();
//            admin.setId(1);
//            admin.setUsername("admin");
//            admin.setPassword("admin");
//            adminRepository.save(admin);
//        }
    }
}
