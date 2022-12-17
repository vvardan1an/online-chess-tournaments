package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentcommon.repository.AdminRepository;
import am.itspace.onlinechesstournamentcommon.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @InjectMocks
    private AdminServiceImpl adminService;
    @InjectMocks
    Admin admin;
    @Mock
    private AdminRepository adminRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldAddAdmin() {
        //given
        List<Admin> admins = List.of(Admin.builder()
                .email("admin@mail.ru")
                .password(passwordEncoder.encode("ggs"))
                .build());

        //when
        when(adminRepository.findAll()).thenReturn(admins);
        adminService.saveAdmin();

        //then
        verify(adminRepository, times(0)).save(any(Admin.class));
    }

    @Test
    void shouldDoNothing() {
        //given
        String password = "some encoded password";

        //when
        when(adminRepository.findAll()).thenReturn(emptyList());
        when(passwordEncoder.encode(anyString())).thenReturn(password);
        adminService.saveAdmin();

        //then
        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void findByEmailAdmin() {
        Admin expected = Admin.builder()
                .id(0)
                .email("admin@mail.ru")
                .password("ggs")
                .build();

        when(adminRepository.findByEmail(expected.getEmail())).thenReturn(new Admin());
        adminService.findByEmail(expected.getEmail());
        verify(adminRepository, times(1)).findByEmail(expected.getEmail());
    }
}