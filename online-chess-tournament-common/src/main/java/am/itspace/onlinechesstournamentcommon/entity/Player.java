package am.itspace.onlinechesstournamentcommon.entity;

import am.itspace.onlinechesstournamentdatatransfer.model.Title;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    @ToString.Exclude
    private List<Tournament> tournamentList;
}
