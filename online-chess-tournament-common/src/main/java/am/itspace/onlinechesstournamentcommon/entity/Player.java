package am.itspace.onlinechesstournamentcommon.entity;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String nationality;

    private int age;

    private int fideRating;

    private int nationalRating;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "player_tournament",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    @ToString.Exclude
    List<Tournament> tournamentList;
}
