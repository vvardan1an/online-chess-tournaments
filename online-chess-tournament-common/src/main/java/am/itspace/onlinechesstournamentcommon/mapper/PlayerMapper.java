package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player toEntity(PlayerRequest playerRequest);

    PlayerResponse toResponse(Player player);

    List<PlayerResponse> toResponseList(List<Player> playerList);
}
