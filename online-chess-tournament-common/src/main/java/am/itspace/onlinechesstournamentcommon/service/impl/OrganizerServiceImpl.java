package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.repository.OrganizerRepository;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean existsById(int id) {
        return organizerRepository.existsById(id);
    }

    @Override
    public List<OrganizerResponse> findAll() {
        return organizerMapper.toResponseList(organizerRepository.findAll());
    }

    @Override
    public void deleteById(int id) {
        organizerRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return organizerRepository.existsByEmail(email);
    }
}
