package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.exception.UserNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.repository.OrganizerRepository;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final OrganizerRepository organizerRepository;

    private final OrganizerMapper organizerMapper;

    public Organizer findByEmail(String email) {
        log.info("attempt to get an 'Organizer' with email {}", email);
        return organizerRepository.findByEmail(email);
    }

    @Override
    public Organizer save(OrganizerRequest organizerRequest) {
        return organizerRepository.save(organizerMapper.toEntity(organizerRequest));
    }
}