package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerRequest {

    @Size(min = 2)
    @NotNull(message = "field 'name' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String name;

    @Size(min = 2)
    @NotNull(message = "field 'surname' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String surname;

    @NotBlank
    @NotNull(message = "field 'nationality' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String nationality;

    @Positive(message = "cannot input negative number into 'age' field")
    @NotNull
    @Max(100)
    private int age;

    @Positive(message = "cannot input negative number into 'fideRating' field")
    @NotNull
    private int fideRating;

    @Positive
    private int nationalRating;

    @NotNull(message = "field 'title' cannot be null")
    private Title title;

    @NotNull(message = "field 'email' cannot be null")
    @NotBlank(message = "parsing failed...cannot be blank")
    private String email;

    @NotBlank(message = "parsing failed...cannot be blank")
    @Size(min = 4, max = 18)
    @NotNull(message = "field 'password' cannot be null")
    private String password;
}