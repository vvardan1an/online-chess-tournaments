package am.itspace.onlinechesstournamentdatatransfer.response.authResponse;

import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * response DTO used for returning
 * successfully logged in Player with generated token;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerAuthResponse {

    private String token;

    private PlayerResponse player;
}
