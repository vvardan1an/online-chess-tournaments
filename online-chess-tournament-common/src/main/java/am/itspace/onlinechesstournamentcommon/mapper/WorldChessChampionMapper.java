package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateWccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.WccResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorldChessChampionMapper {

    WorldChessChampion toEntity(WccRequest wccRequest);

    WorldChessChampion toEntity(UpdateWccRequest updateWccRequest);

    WccResponse toResponse(WorldChessChampion worldChessChampion);

    List<WccResponse> toResponseList(List<WorldChessChampion> worldChessChampionList);
}
