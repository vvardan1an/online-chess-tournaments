package am.itspace.onlinechesstournaments.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "world_chess_champions")
public class WorldChessChampions {
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
    private String heldTitleFromTo;
    private String picture;
}
