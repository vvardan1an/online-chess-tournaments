package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerResponse {

    private int id;
    private String name;
    private String surname;
    private String nationality;
    private int age;
    private String email;
}