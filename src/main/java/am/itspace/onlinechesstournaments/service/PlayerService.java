package am.itspace.onlinechesstournaments.service;

import am.itspace.onlinechesstournaments.dto.RegisterPlayerDto;
import am.itspace.onlinechesstournaments.entity.Organizer;
import am.itspace.onlinechesstournaments.entity.Player;
import am.itspace.onlinechesstournaments.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    public final PlayerRepository playerRepository;

    public Player registerPlayer(RegisterPlayerDto registerPlayerDto) {
        return playerRepository.save(Player.builder()
                .name(registerPlayerDto.getName())
                .surname(registerPlayerDto.getSurname())
                .nationality(registerPlayerDto.getNationality())
                .age(registerPlayerDto.getAge())
                .fideRating(registerPlayerDto.getFideRating())
                .nationalRating(registerPlayerDto.getNationalRating())
                .title(registerPlayerDto.getTitle())
                .pictureUrl(registerPlayerDto.getPictureUrl())
                .email(registerPlayerDto.getEmail())
                .password(registerPlayerDto.getPassword())
                .build());

    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

}
