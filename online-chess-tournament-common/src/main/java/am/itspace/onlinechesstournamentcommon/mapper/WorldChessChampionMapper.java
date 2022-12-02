package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentdatatransfer.request.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.WccResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorldChessChampionMapper {

    WorldChessChampion toEntity(WccRequest wccRequest);

    WccResponse toResponse(WorldChessChampion worldChessChampion);

    List<WorldChessChampion> toEntityList(List<WccRequest> wccRequestList);

    List<WccRequest> toResponseList(List<WorldChessChampion> worldChessChampionList);
}
