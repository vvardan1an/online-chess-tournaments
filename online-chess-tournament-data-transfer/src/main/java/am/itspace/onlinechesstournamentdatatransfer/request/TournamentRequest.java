package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import com.fasterxml.jackson.annotation.JsonFormat;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {

    @NotBlank(message = "cannot input blank value into 'name' field")
    @Size(min = 2, message = "tournament name cannot be less than two symbols")
    private String name;

    @NotNull(message = "field 'isRated' cannot be null")
    private boolean isRated;

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

    @NotNull(message = "field 'timeControl' cannot be null")
    @NotBlank(message = "cannot input blank value into 'timeControl' field")
    private String timeControl;

    @NotNull(message = "field 'type' cannot be null")
    @NotBlank(message = "cannot input blank value into 'type' field")
    private String type;
}