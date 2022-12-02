package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizerMapper {

    Organizer toEntity(OrganizerRequest organizerRequest);

    OrganizerResponse toResponse(Organizer organizer);

    List<Organizer> toEntityList(List<OrganizerRequest> organizerRequestList);

    List<OrganizerResponse> toResponseList(List<Organizer> organizerList);
}
