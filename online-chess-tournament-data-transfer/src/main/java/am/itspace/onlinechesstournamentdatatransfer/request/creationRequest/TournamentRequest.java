package am.itspace.onlinechesstournamentdatatransfer.request.creationRequest;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * DTO used for tournament creation request;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {

    @NotBlank(message = "cannot input blank value into 'name' field")
    @Size(min = 2, message = "tournament name cannot be less than two symbols")
    private String name;

    @JsonProperty
    @NotNull(message = "field 'isRated' cannot be null")
    private boolean isRated;

    @JsonProperty
    @NotNull(message = "field 'isTitled' cannot be null")
    private boolean isTitled;

    @NotNull(message = "field 'tournamentSystem' cannot be null")
    private TournamentSystem tournamentSystem;

    @NotNull(message = "field 'roundCount' cannot be null")
    private int roundCount;

    private int minAgeRestriction;

    private int maxAgeRestriction;

    private int minRatingRestriction;

    private int maxRatingRestriction;

    @NotNull(message = "field 'startDate' cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    private String description;

    @NotNull(message = "field 'participationEntryDeadline' cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime participationEntryDeadline;

    @NotNull(message = "field 'endDate' cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    @NotBlank(message = "field 'timeControl' cannot be null")
    private String timeControl;

    @NotNull
    @NotBlank(message = "field 'type' cannot be null")
    private String type;

    /**
     * generated getters for (isRated, isTitled) fields,
     * renamed -> getIsRated, getIsTitled
     * reason behind: ->
     * while mapping from TournamentRequest to Tournament entity,
     * automated map generator impl always gets values of field with 'get + (field name)',
     * as @Getter provides boolean isRated, boolean isTitled, occurred a need for certain getter methods renaming
     */

    public boolean getIsRated() {
        return isRated;
    }

    public boolean getIsTitled() {
        return isTitled;
    }
}