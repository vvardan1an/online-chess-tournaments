package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentcommon.repository.TournamentRepository;
import am.itspace.onlinechesstournamentcommon.service.impl.TournamentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TournamentServiceTest {

    @InjectMocks
    TournamentServiceImpl tournamentService;

    @Mock
    TournamentRepository tournamentRepository;

    @Test
    void isPresentSuccess() {

        when(tournamentRepository.existsById(anyInt())).thenReturn(true);
        boolean actual = tournamentService.isPresent(1);

        assertTrue(actual);

    }

    @Test
    void isPresentFailed() {

        when(tournamentRepository.existsById(anyInt())).thenReturn(false);
        boolean actual = tournamentService.isPresent(1);

        assertFalse(actual);

    }

    @Test
    void findAll() {
        when(tournamentRepository.findAll()).thenReturn(List.of(new Tournament()));

        tournamentRepository.findAll();
        verify(tournamentRepository, times(1)).findAll();
        verifyNoMoreInteractions(tournamentRepository);
    }

    @Test
    void findById() {
        when(tournamentRepository.findById(anyInt())).thenReturn(Optional.of(new Tournament()));
        tournamentService.findById(1);

        verify(tournamentRepository, times(1)).findById(anyInt());
        verifyNoMoreInteractions(tournamentRepository);
    }
}