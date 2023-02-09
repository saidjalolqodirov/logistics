package uz.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.logistics.dto.auth.AdminUpdateDTO;
import uz.logistics.dto.auth.LoginDTO;
import uz.logistics.entity.Admin;
import uz.logistics.repository.AdminRepository;
import uz.logistics.service.AdminService;
import uz.logistics.utils.JWTUtils;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/7/2023 7:30 PM
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AdminService adminService;

    private final AdminRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JWTUtils jwtUtils;

    private final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }

        final UserDetails userDetails = adminService.loadUserByUsername(dto.getUsername());

        final String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/change")
    public ResponseEntity<?> change(@RequestBody AdminUpdateDTO dto) {
        if (dto.getUsername().isBlank() || dto.getPassword().isBlank() || dto.getUsername().length() < 5 || dto.getPassword().length() < 3)
            return ResponseEntity.badRequest().body("invalid username or password");
        Optional<Admin> optionalAdmin = repository.findById(dto.getId());
        if (!dto.getPassword().equals(dto.getConfirmationPassword()))
            return ResponseEntity.badRequest().body("password not equals");
        Admin admin = optionalAdmin.get();
        admin.setUsername(dto.getUsername());
        admin.setPassword(passwordEncoder.encode(dto.getPassword()));
        return ResponseEntity.ok(repository.save(admin));
    }
}
