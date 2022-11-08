package am.itspace.onlinechesstournaments.service;

import am.itspace.onlinechesstournaments.dto.RegisterOrgDto;
import am.itspace.onlinechesstournaments.entity.Organizer;
import am.itspace.onlinechesstournaments.exception.handler.OrganizerException;
import am.itspace.onlinechesstournaments.repository.OrganizerRepository;
import am.itspace.onlinechesstournaments.util.HashUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static am.itspace.onlinechesstournaments.exception.handler.ErrorCode.EMAIL_EXIST_ERROR;
import static am.itspace.onlinechesstournaments.exception.handler.ErrorCode.NAME_OR_SURNAME_ERROR;

@Service
@RequiredArgsConstructor
public class OrganizerService {
    public final OrganizerRepository organizerRepository;

    public Organizer registerOrg(RegisterOrgDto registerOrgDto) throws OrganizerException {
        if(organizerRepository.findByEmail(registerOrgDto.getEmail()).isPresent()){
            throw new OrganizerException(EMAIL_EXIST_ERROR);
        }
        if(organizerRepository.findByNameOrSurname(registerOrgDto.getName().isEmpty() || registerOrgDto.getSurname().isEmpty())){
            throw new  OrganizerException(NAME_OR_SURNAME_ERROR);
        }
        return organizerRepository.save(Organizer.builder()
                .name(registerOrgDto.getName())
                .surname(registerOrgDto.getSurname())
                .nationality(registerOrgDto.getNationality())
                .age(registerOrgDto.getAge())
                .email(registerOrgDto.getEmail())
                .password(HashUtils.hash(registerOrgDto.getPassword()))
                .build());

    }

    public List<Organizer> findAll() {
        return organizerRepository.findAll();
    }
}
