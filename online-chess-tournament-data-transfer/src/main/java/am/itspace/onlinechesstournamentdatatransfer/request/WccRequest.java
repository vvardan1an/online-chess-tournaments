package am.itspace.onlinechesstournamentdatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WccRequest {

    @Size(min = 2, max = 30, message = "Name must be min - 2 , max - 30")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @Size(min = 2, max = 30, message = "Surname must be min - 2 , max - 30")
    @NotBlank(message = "Surname cannot be null")
    private String surname;
    @NotNull(message = "Birth date cannot be null")
    private LocalDate birth_date;

    private LocalDate died;

    @NotBlank(message = "Country/City cannot be null")
    private String cityCountry;

    @NotBlank(message = "Federation cannot be null")
    private String federation;
    @NotNull(message = "Rating cannot be null")
    private int rating;
    @NotNull(message = "Peak rating cannot be null")
    private int peakRating;

    @NotNull(message = "Number cannot be null")
    private int worldChampionNumber;

    private String picture;

    @NotBlank(message = "Qoute cannot be null")
    private String quote;

    @NotBlank(message = "Info cannot be null")
    private String info;

    private int blitzRating;
    private int rapidRating;
    @NotBlank(message = "Title cannot be null")
    private String title;
}
