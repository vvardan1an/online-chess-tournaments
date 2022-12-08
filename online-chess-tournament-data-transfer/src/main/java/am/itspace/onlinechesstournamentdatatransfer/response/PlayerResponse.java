package am.itspace.onlinechesstournamentdatatransfer.response;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {

    private int id;
    private String name;
    private String surname;
    private String nationality;
    private int age;
    private int fideRating;
    private int nationalRating;
    private Title title;
    private String email;
    private List<TournamentDto> playerList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TournamentDto {
        private int id;
        private String name;
    }
}