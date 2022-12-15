package am.itspace.onlinechesstournamentcommon.entity;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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

    private int roundCount;

    private LocalDateTime participationEntryDeadline;

    private LocalDateTime endDate;

    private String timeControl;

    private int participantCount;

    private String type;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToMany
    @JoinTable(
            name = "player_tournament",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> playerList;

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isRated=" + isRated +
                ", isTitled=" + isTitled +
                ", tournamentSystem=" + tournamentSystem +
                ", minAgeRestriction=" + minAgeRestriction +
                ", maxAgeRestriction=" + maxAgeRestriction +
                ", minRatingRestriction=" + minRatingRestriction +
                ", maxRatingRestriction=" + maxRatingRestriction +
                ", startDate=" + startDate +
                ", description='" + description + '\'' +
                ", roundCount=" + roundCount +
                ", participationEntryDeadline=" + participationEntryDeadline +
                ", endDate=" + endDate +
                ", timeControl='" + timeControl + '\'' +
                ", participantCount=" + participantCount +
                ", type='" + type + '\'' +
                ", organizer=" + organizer +
                ", playerList=" + playerList +
                '}';
    }
}
