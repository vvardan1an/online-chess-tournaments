package am.itspace.onlinechesstournaments.entity;

import am.itspace.onlinechesstournaments.model.TournamentSystem;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
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
    private int minAgeRestriction;
    private int maxAgeRestriction;
    private int minRatingRestriction;
    private int maxRatingRestriction;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startDate;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date participationEntryDeadline;
    private Date endDate;
    private String timeControl;
    private int participantCount;
    private String type;
    @ManyToMany
    @JoinTable(
            name = "player_tournament",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    @ToString.Exclude
    List<Player> playerList;
}
