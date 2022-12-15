package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

/**
 * public class PlayerAuthResponse;
 * response DTO
 * used for returning successfully logged in Player with generated token;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerAuthResponse {

    private String token;

    private PlayerResponse player;
}
