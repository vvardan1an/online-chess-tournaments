package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * public class PlayerRequest;
 * Request DTO
 * used for Player registration;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    @Size(min = 2)
    @NotBlank(message = "field 'name' cannot be null")
    private String name;

    @Size(min = 2)
    @NotBlank(message = "field 'surname' cannot be null")
    private String surname;

    @NotBlank(message = "field 'nationality' cannot be null")
    private String nationality;

    @Positive(message = "cannot input negative number into 'age' field")
    @Max(100)
    private int age;

    @Positive(message = "cannot input negative number into 'fideRating' field")
    @NotNull
    private int fideRating;

    private int nationalRating;

    @NotNull(message = "field 'title' cannot be null")
    private Title title;

    @NotBlank(message = "field 'email' cannot be null")
    private String email;

    @NotBlank(message = "field 'password' cannot be null")
    @Size(min = 4, max = 18)
    private String password;
}