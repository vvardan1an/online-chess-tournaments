package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentdatatransfer.request.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.TournamentResponse;import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    Tournament toEntity(TournamentRequest tournamentRequest);

    TournamentResponse toResponse(Tournament tournament);

    List<Tournament> toEntityList(List<TournamentRequest> tournamentRequestList);

    List<TournamentResponse> toResponseList(List<Tournament> tournamentList);
}
