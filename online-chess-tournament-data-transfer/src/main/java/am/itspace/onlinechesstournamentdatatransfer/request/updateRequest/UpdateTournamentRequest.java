package am.itspace.onlinechesstournamentdatatransfer.request.updateRequest;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * DTO used for tournament update request;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTournamentRequest {

    @Size(min = 2, message = "tournament name cannot be less than two symbols")
    private String name;

    private Boolean isRated;

    private Boolean isTitled;

    private TournamentSystem tournamentSystem;

    private Integer roundCount;

    private Integer minAgeRestriction;

    private Integer maxAgeRestriction;

    private Integer minRatingRestriction;

    private Integer maxRatingRestriction;

    @Size(min = 10, message = "description cannot be less than ten symbols")
    private String description;

    @Size(min = 1, message = "timeControl cannot be less than one symbol")
    private String timeControl;

    @Size(min = 4, message = "type cannot be less than four symbols")
    private String type;

    public Boolean getIsRated() {
        return isRated;
    }

    public Boolean getIsTitled() {
        return isTitled;
    }
}