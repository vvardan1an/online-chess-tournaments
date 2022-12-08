package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

// TODO: 12/7/2022 normalize annotations

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizerAuthResponse {

    private String token;

    private OrganizerResponse organizer;
}
