package am.itspace.onlinechesstournaments.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
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
    private int rating;
    private int peakRating;
    private int worldChampionNumber;
    @Column(name = "picture_url")
    private String picture;
    private String quote;
    private String info;
    private int blitzRating;
    private int rapidRating;
    private String title;
}
