package am.itspace.onlinechesstournamentdatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRequest {

    @NotNull(message = "field 'name' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String name;

    @NotNull(message = "field 'surname' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String surname;

    @NotNull(message = "field 'nationality' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String nationality;

    @NotNull(message = "field 'age' cannot be null")
    private int age;

    @NotBlank(message = "parsing failed...cannot be blank")
    @NotNull(message = "field 'email' cannot be null")
    private String email;

    @NotNull(message = "field 'password' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String password;
}