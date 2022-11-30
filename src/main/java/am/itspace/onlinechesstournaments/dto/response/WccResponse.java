package am.itspace.onlinechesstournaments.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WccResponse {

    private int id;
    private String name;
    private String surname;
    private Date birth_date;
    private Date died;
    private String cityCountry;
    private String federation;
    private int rating;
    private String peakRating;
    private int worldChampionNumber;
    private String picture;
    private String quote;
    private String info;
    private int blitzRating;
    private int rapidRating;
    private String title;
}
