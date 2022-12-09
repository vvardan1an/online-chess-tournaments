package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminAuthResponse {

    private String token;

    private AdminResponse admin;
}
