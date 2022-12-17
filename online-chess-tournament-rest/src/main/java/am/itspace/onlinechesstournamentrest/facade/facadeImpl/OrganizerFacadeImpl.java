package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.util.AuthUtil;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.OrganizerRequest;
import am.itspace.onlinechesstournamentrest.facade.OrganizerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@RequiredArgsConstructor
public class OrganizerFacadeImpl implements OrganizerFacade {

    private final OrganizerService organizerService;

    private final OrganizerMapper organizerMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthUtil authUtil;

    @Override
    public ResponseEntity<?> register(OrganizerRequest organizerRequest, BindingResult br) {
        if (br.hasErrors()) {
            return ResponseEntity.badRequest().body(BindingResultUtil.extract(br));
        }
        if (authUtil.hasEmailConflict(organizerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email conflict has occurred");
        }
        organizerRequest.setPassword(passwordEncoder.encode(organizerRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizerMapper.toResponse(organizerService.save(organizerRequest)));
    }
}
