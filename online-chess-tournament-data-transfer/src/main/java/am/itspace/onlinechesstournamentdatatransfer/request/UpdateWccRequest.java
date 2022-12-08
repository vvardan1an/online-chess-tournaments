package am.itspace.onlinechesstournamentdatatransfer.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWccRequest {

    @Size(min = 2, max = 30)
    @NotBlank
    private String name;

    @Size(min = 2, max = 30)
    @NotBlank
    private String surname;

    private LocalDate birth_date;
    private LocalDate died;

    @NotBlank
    private String cityCountry;

    @NotBlank
    private String federation;

    private int rating;
    private int peakRating;

    @Min(value = 1)
    private int worldChampionNumber;
    private String picture;

    @NotBlank
    private String quote;

    @NotBlank
    private String info;

    private int blitzRating;
    private int rapidRating;
    private String title;
}
