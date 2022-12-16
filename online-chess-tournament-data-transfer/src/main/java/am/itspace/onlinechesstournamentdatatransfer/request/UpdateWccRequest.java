package am.itspace.onlinechesstournamentdatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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
    private String name;

    @Size(min = 2, max = 30)
    private String surname;

    private LocalDate birthDate;

    private LocalDate died;

    private String cityCountry;

    private String federation;

    private Integer rating;

    private Integer peakRating;

    @Min(value = 1)
    private Integer worldChampionNumber;

    private String quote;

    private String info;

    private Integer blitzRating;

    private Integer rapidRating;

    private String title;
}