package am.itspace.onlinechesstournamentcommon.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate birthDate;

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
