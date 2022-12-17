package am.itspace.onlinechesstournamentdatatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WccResponse {

    private int id;
    private String name;
    private String surname;
    private LocalDate birtDate;
    private LocalDate died;
    private String cityCountry;
    private String federation;
    private int rating;
    private int peakRating;
    private int worldChampionNumber;
    private String quote;
    private String info;
    private int blitzRating;
    private int rapidRating;
    private String title;
}
