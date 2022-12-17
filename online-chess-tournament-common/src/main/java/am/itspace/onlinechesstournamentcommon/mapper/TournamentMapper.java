package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateTournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.TournamentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    Tournament toEntity(TournamentRequest tournamentRequest);

    Tournament toEntity(UpdateTournamentRequest updateTournamentRequest);

    TournamentResponse toResponse(Tournament tournament);

    List<TournamentResponse> toResponseList(List<Tournament> tournamentList);
}
