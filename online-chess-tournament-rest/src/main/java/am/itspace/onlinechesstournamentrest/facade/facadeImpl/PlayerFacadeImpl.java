package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentcommon.util.AuthUtil;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentrest.facade.PlayerFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@AllArgsConstructor
public class PlayerFacadeImpl implements PlayerFacade {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;

    @Override
    public ResponseEntity<?> register(PlayerRequest playerRequest, BindingResult br) {
        if (br.hasErrors()) return ResponseEntity.badRequest().body(BindingResultUtil.check(br));
        if (authUtil.hasEmailConflict(playerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email conflict has occurred");
        }
        playerRequest.setPassword(passwordEncoder.encode(playerRequest.getPassword()));
        Player savedPlayer = playerService.save(playerRequest);
        return ResponseEntity.ok(playerMapper.toResponse(savedPlayer));
    }
}
