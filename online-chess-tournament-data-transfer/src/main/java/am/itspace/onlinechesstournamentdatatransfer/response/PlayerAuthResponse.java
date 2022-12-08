package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

// TODO: 12/7/2022 normalize annotations

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerAuthResponse {

    private String token;

    private PlayerResponse user;
}
