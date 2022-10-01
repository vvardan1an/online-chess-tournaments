package am.itspace.onlinechesstournaments.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean isRated;
    private boolean isTitled;
    @Enumerated(EnumType.STRING)
    private TournamentSystem tournamentSystem;
    private boolean isAgeRestricted;
    private int minAgeRestriction;
    private int maxAgeRestriction;
    private int minRatingRestriction;
    private int maxRatingRestriction;
    private int participantMinCount;
    private int participantMaxCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadLine;

    @ManyToMany
    @JoinTable(
            name = "play_tour",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    List<Player> playerList;

}