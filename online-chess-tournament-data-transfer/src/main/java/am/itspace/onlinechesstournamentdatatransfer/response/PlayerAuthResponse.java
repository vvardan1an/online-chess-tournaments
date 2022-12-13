package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerAuthResponse {

    private String token;

    private PlayerResponse player;
}
