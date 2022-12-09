package am.itspace.onlinechesstournamentcommon.mapper;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentdatatransfer.response.AdminResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminResponse toResponse(Admin admin);
}
