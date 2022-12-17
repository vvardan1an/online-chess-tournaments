package am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * DTO used for Organizer registration request;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRequest {

    @NotBlank(message = "field 'name' cannot be null")
    private String name;


    @NotBlank(message = "field 'surname' cannot be null")
    private String surname;

    @NotBlank(message = "field 'nationality' cannot be null")
    private String nationality;

    @Positive
    private int age;

    @NotBlank(message = "field 'email' cannot be null")
    private String email;

    @NotBlank(message = "field 'password' cannot be null")
    private String password;
}