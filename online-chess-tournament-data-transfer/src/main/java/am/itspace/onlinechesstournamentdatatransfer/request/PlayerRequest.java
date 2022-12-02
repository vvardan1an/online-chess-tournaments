package am.itspace.onlinechesstournamentdatatransfer.request;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

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
}