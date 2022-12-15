package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.*;

/**
 * public class AdminAuthResponse;
 * response DTO;
 * used for returning successfully logged in admin with generated token;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminAuthResponse {

    private String token;

    private AdminResponse admin;
}