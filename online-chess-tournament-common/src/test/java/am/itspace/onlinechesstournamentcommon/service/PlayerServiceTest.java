package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.service.impl.PlayerServiceImpl;
import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    PlayerServiceImpl playerService;


    @Test
    void findByEmail() {

        Player player = Player.builder()
                .id(1)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(18)
                .fideRating(15)
                .nationalRating(20)
                .title(Title.NM)
                .email("smith@mail.ru")
                .password("123")
                .tournamentList(new ArrayList<>())
                .build();

        when(playerService.findByEmail(anyString()).equals(player.getEmail())).thenReturn(true);
        verify(playerService, times(1)).findByEmail(anyString());
        verifyNoMoreInteractions(playerService);

    }

    @Test
    void save() {
        Player player = Player.builder()
                .id(1)
                .name("John")
                .surname("Smith")
                .nationality("US")
                .age(18)
                .fideRating(15)
                .nationalRating(20)
                .title(Title.NM)
                .email("smith@mail.ru")
                .password("123")
                .build();

        when(playerService.save(any())).thenReturn(player);
        Player savePlayer = playerService.save(new PlayerRequest());
        assertThat(savePlayer).isEqualTo(player);
        verify(playerService, times(1)).save(any());


    }

    @Test
    void deleteById() {

        when(playerService.deleteById(anyInt())).thenReturn(true);

        playerService.deleteById(anyInt());
        verify(playerService, times(1)).deleteById(anyInt());
        verifyNoMoreInteractions(playerService);

    }

    @Test
    void findAll() {

        when(playerService.findAll()).thenReturn(List.of(new PlayerResponse(), new PlayerResponse()));

        playerService.findAll();
        verify(playerService, times(1)).findAll();
        verifyNoMoreInteractions(playerService);
    }
}