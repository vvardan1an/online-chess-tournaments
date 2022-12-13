package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizerAuthResponse {

    private String token;

    private OrganizerResponse organizer;
}
