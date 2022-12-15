package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.service.impl.OrganizerServiceImpl;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizerServiceTest {

    @Mock
    OrganizerServiceImpl organizerService;


    @Test
    void findByEmail() {

        Organizer organizer = Organizer.builder()
                .id(1)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(18)
                .email("smith@mail.ru")
                .password("123")
                .tournamentList(new ArrayList<>())
                .build();

        when(organizerService.findByEmail(anyString()).equals(organizer.getEmail())).thenReturn(true);
        verify(organizerService, times(1)).findByEmail(anyString());
        verifyNoMoreInteractions(organizerService);

    }

    @Test
    void save() {
        Organizer organizer = Organizer.builder()
                .id(1)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(18)
                .email("smith@mail.ru")
                .password("123")
                .tournamentList(new ArrayList<>())
                .build();

        when(organizerService.save(any())).thenReturn(organizer);
        Organizer saveOrganizer = organizerService.save(new OrganizerRequest());
        assertThat(saveOrganizer).isEqualTo(organizer);
        verify(organizerService, times(1)).save(any());


    }

    @Test
    void deleteById() {

        when(organizerService.deleteById(anyInt())).thenReturn(true);

        organizerService.deleteById(anyInt());
        verify(organizerService, times(1)).deleteById(anyInt());
        verifyNoMoreInteractions(organizerService);

    }

    @Test
    void findAll() {

        when(organizerService.findAll()).thenReturn(List.of(new OrganizerResponse(), new OrganizerResponse()));

        organizerService.findAll();
        verify(organizerService, times(1)).findAll();
        verifyNoMoreInteractions(organizerService);
    }
}