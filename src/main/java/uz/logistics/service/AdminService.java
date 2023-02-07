package uz.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.logistics.repository.AdminRepository;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:00 AM
 */
@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow();
    }
}
