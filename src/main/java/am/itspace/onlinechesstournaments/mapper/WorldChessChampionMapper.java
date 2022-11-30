package am.itspace.onlinechesstournaments.mapper;

import am.itspace.onlinechesstournaments.dto.request.WccRequest;
import am.itspace.onlinechesstournaments.dto.response.WccResponse;
import am.itspace.onlinechesstournaments.entity.WorldChessChampion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldChessChampionMapper {

    WorldChessChampion toEntity(WccRequest wccRequest);

    WccResponse toResponse(WorldChessChampion worldChessChampion);
}
