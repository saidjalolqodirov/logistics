package uz.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.logistics.dto.LoginDTO;
import uz.logistics.service.AdminService;
import uz.logistics.utils.JWTUtils;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:02 AM
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AdminController {
    private final AdminService adminService;

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
}
