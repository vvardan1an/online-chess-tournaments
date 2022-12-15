package am.itspace.onlinechesstournamentdatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * public class UpdateWccRequest;
 * Request DTO
 * used for updating worldChessChampion;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWccRequest {

    @Size(min = 2, max = 30)
    @NotBlank(message = "name cannot be null")
    private String name;

    @Size(min = 2, max = 30)
    @NotBlank(message = "surname cannot be null")
    private String surname;

    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;

    private LocalDate died;

    @NotBlank(message = "city/country cannot be null")
    private String cityCountry;

    @NotBlank(message = "federation cannot be null")
    private String federation;

    private int rating;

    @Positive
    private int peakRating;

    @Min(value = 1)
    private int worldChampionNumber;

    private String quote;

    private String info;

    private int blitzRating;

    private int rapidRating;

    private String title;
}