package am.itspace.onlinechesstournamentdatatransfer.response;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
    private String picture;
    private String email;
    private String password;
    private List<TournamentDto> playerList;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TournamentDto {
        private int id;
        private String name;
    }
}