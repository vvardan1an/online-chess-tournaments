package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerRequest {

    // TODO: 12/8/2022 validate all fields;

    @Size(min = 2)
    private String name;

    @Size(min = 2)
    private String surname;

    @NotBlank
    private String nationality;

    @Positive(message = "cannot input negative number into 'age' field")
    @Max(110)
    private int age;

    @Positive(message = "cannot input negative number into 'fideRating' field")
    private int fideRating;

    @Positive(message = "cannot input negative number into 'nationalRating' field")
    private int nationalRating;

    private Title title;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 4, max = 18)
    private String password;
}