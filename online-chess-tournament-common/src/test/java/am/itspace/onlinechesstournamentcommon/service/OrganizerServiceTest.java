package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.repository.OrganizerRepository;
import am.itspace.onlinechesstournamentcommon.service.impl.OrganizerServiceImpl;
import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.OrganizerRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizerServiceTest {

    @InjectMocks
    private OrganizerServiceImpl organizerService;
    @Mock
    private OrganizerRepository organizerRepository;
    @Mock
    private OrganizerMapper mapper;


    @Test
    void findByEmailSuccess() {

        Organizer expected = Organizer.builder()
                .id(0)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(20)
                .email("smith@mail.ru")
                .password("chess")
                .build();

        when(organizerRepository.findByEmail(expected.getEmail())).thenReturn(new Organizer());
        organizerService.findByEmail(expected.getEmail());
        verify(organizerRepository, times(1)).findByEmail(expected.getEmail());
    }

    @Test
    void save() {
        Organizer expected = Organizer.builder()
                .id(0)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(20)
                .email("smith@mail.ru")
                .password("chess")
                .build();

        when(organizerRepository.save(any(Organizer.class))).thenReturn(expected);
        when(mapper.toEntity(any(OrganizerRequest.class))).thenReturn(expected);

        Organizer actual = organizerService.save(new OrganizerRequest());

        assertEquals(expected, actual);
        verify(organizerRepository, times(1)).save(any(Organizer.class));
    }

    @Test
    void findAll() {

        when(organizerRepository.findAll()).thenReturn(List.of(new Organizer()));

        organizerService.findAll();
        verify(organizerRepository, times(1)).findAll();
        verifyNoMoreInteractions(organizerRepository);
    }
}
