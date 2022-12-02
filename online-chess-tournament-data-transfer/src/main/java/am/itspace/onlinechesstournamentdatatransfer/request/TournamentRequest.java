package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {

    private String name;
    private boolean isRated;
    private boolean isTitled;
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
    private String type;
}