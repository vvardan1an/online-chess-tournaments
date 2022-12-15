package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.repository.OrganizerRepository;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizerServiceTest {

    @InjectMocks
    private OrganizerServiceImpl organizerService;

    @MockBean
    private OrganizerRepository organizerRepository;

    @Test
    void findByEmail() {
    }

    @Test
    void save() {
        Organizer organizer = Organizer.builder()
                .id(0)
                .name("John")
                .surname("Smith")
                .nationality("USA")
                .age(18)
                .email("smith778@gmail.com")
                .password("13456")
                .build();

        when(organizerRepository.save(any())).thenReturn(organizer);

        organizerService.save(OrganizerRequest.builder()
                .name("John")
                .surname("Smith")
                .nationality("USA")
                .age(18)
                .email("smith778@gmail.com")
                .password("13456")
                .build());
        verify(organizerRepository,times(1)).save(any());

    }

    @Test
    void deleteById() {
    }

//    @Test
//    void findAll() {
//        List<Organizer> organizer = List.of(Organizer.builder()
//                .id(0)
//                .name("John")
//                .surname("Smith")
//                .nationality("USA")
//                .age(18)
//                .email("smith778@gmail.com")
//                .password("13456")
//                .build());
//        when(organizerService.findAll()).thenReturn(organizer);
//    }
}