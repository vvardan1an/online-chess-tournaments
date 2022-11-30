package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentdatatransfer.request.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.WccResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldChessChampionMapper {

    WorldChessChampion toEntity(WccRequest wccRequest);

    WccResponse toResponse(WorldChessChampion worldChessChampion);
}
