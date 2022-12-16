package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * public class OrganizerAuthResponse;
 * response DTO
 * used for returning successfully logged in Organizer with generated token;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizerAuthResponse {

    private String token;

    private OrganizerResponse organizer;
}
