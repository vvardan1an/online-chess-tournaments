package am.itspace.onlinechesstournamentdatatransfer.response;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import am.itspace.onlinechesstournamentdatatransfer.model.TournamentSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentResponse {

    private int id;
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
    private int participantCount;
    private String type;
    private List<PlayerDto> playerList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlayerDto {

        private int id;
        private String name;
        private String surname;
        private String nationality;
        private int age;
        private int fideRating;
        private int nationalRating;
        private Title title;
        private String picture;
    }
}