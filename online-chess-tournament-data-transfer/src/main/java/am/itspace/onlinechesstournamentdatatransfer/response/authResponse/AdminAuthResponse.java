package am.itspace.onlinechesstournamentdatatransfer.response.authResponse;

import am.itspace.onlinechesstournamentdatatransfer.response.AdminResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * response DTO, used for returning successfully
 * logged in admin with generated token;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminAuthResponse {

    private String token;

    private AdminResponse admin;
}