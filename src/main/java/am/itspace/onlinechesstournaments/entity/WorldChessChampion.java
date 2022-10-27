package am.itspace.onlinechesstournaments.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "world_chess_champion")
public class WorldChessChampion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private Date birth_date;
    private Date died;
    private String cityCountry;
    private String federation;
    private String rating;
    private String peakRating;
    private int worldChampionNumber;
    @Column(name = "picture_url")
    private String picture;
    private String quote;
    private String info;
    private String blitzRating;
    private String rapidRating;
    private String title;
}
