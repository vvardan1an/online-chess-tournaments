package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.repository.PlayerRepository;
import am.itspace.onlinechesstournamentcommon.service.impl.PlayerServiceImpl;
import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.PlayerRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerServiceImpl service;
    @Mock
    private PlayerRepository repository;
    @Mock
    private PlayerMapper mapper;

    @Test
    void findByEmailSuccess() {

        Player expected = Player.builder()
                .id(0)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(20)
                .fideRating(50)
                .nationalRating(80)
                .title(Title.CM)
                .email("smith@mail.ru")
                .password("chess")
                .build();

        when(repository.findByEmail(expected.getEmail())).thenReturn(new Player());
        service.findByEmail(expected.getEmail());
        verify(repository, times(1)).findByEmail(expected.getEmail());
    }

    @Test
    void save() {
        Player expected = Player.builder()
                .id(0)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(20)
                .fideRating(50)
                .nationalRating(80)
                .title(Title.CM)
                .email("smith@mail.ru")
                .password("chess")
                .build();

        when(repository.save(any(Player.class))).thenReturn(expected);
        when(mapper.toEntity(any(PlayerRequest.class))).thenReturn(expected);

        Player actual = service.save(new PlayerRequest());

        assertEquals(expected, actual);
        verify(repository, times(1)).save(any(Player.class));
    }

    @Test
    void findAll() {

        when(repository.findAll()).thenReturn(List.of(new Player()));

        service.findAll();
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);

    }
}