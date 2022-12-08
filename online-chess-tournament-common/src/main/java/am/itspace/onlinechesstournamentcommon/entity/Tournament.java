package am.itspace.onlinechesstournamentcommon.entity;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime startDate;
    private String description;
    private LocalDateTime participationEntryDeadline;
    private LocalDateTime endDate;
    private String timeControl;
    private int participantCount;
    private String type;
    @ManyToMany
    @JoinTable(
            name = "player_tournament",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    List<Player> playerList;
}
