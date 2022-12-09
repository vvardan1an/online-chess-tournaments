package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentcommon.repository.AdminRepository;
import am.itspace.onlinechesstournamentcommon.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void saveAdmin() {
        if (adminRepository.findAll().isEmpty()) {
            adminRepository.save(Admin.builder()
                    .email("admin@mail.ru")
                    .password(passwordEncoder.encode("ggs"))
                    .build());
        }
    }

    @Override
    public Admin findByEmail(String email) {
        log.info("attempt to get an 'Admin' with email '{}'", email);
        return adminRepository.findByEmail(email);
    }
}