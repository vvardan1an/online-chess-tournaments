package am.itspace.onlinechesstournaments.dto;

import am.itspace.onlinechesstournaments.validator.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterOrgDto {

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, message = "organizer name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "")
    @Size(min = 2, message = "organizer surname should have at least 2 characters")
    private String surname;

    @NotEmpty
    private String nationality;
    @NotNull
    private int age;

    @NotEmpty
    @Email
    private String email;

    private String password;
}
