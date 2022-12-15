package am.itspace.onlinechesstournamentdatatransfer.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * public class WccRequest;
 * request DTO
 * used for WorldChessChampion creation;
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WccRequest {

    @Size(min = 2, max = 30, message = "Name must be min - 2 , max - 30")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @Size(min = 2, max = 30, message = "Surname must be min - 2 , max - 30")
    @NotBlank(message = "Surname cannot be null")
    private String surname;

    @NotNull(message = "Birth date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate died;

    @NotBlank(message = "city/country cannot be null")
    private String cityCountry;

    @NotBlank(message = "federation cannot be null")
    private String federation;

    private int rating;

    @Positive
    private int peakRating;

    @Positive
    private int worldChampionNumber;

    private String quote;

    private String info;

    private int blitzRating;

    private int rapidRating;

    private String title;
}
