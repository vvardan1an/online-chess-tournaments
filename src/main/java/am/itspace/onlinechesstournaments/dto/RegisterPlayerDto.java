package am.itspace.onlinechesstournaments.dto;

import am.itspace.onlinechesstournaments.entity.Title;
import am.itspace.onlinechesstournaments.validator.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPlayerDto {

    @NotEmpty
    @Size(min = 2, message = "player name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Size(min = 2, message = "player surname should have at least 2 characters")
    private String surname;
    @NotEmpty
    private String nationality;
    @NotEmpty
    private int age;
    @NotEmpty
    private int fideRating;
    @NotEmpty
    private int nationalRating;
    @Enumerated(EnumType.STRING)
    private Title title;
    private String pictureUrl;
    @Email
    private String email;
    @Password
    private String password;
}
