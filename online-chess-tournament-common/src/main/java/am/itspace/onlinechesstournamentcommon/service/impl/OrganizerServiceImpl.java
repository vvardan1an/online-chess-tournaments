package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.repository.OrganizerRepository;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public boolean deleteById(int id) {
        try {
            organizerRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("cannot delete organizer by id {}", id);
            return false;
        }
    }

    @Override
    public List<OrganizerResponse> findAll() {
        return organizerMapper.toResponseList(organizerRepository.findAll());

    }
}