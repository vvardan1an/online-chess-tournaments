package am.itspace.onlinechesstournamentdatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRequest {

    // TODO: 12/8/2022 validate fields;

    private String name;

    private String surname;

    private String nationality;

    private int age;

    private String email;

    private String password;
}