package am.itspace.onlinechesstournaments.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String playerPic;
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "play_tour",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    List<Tournament> playerList;


}
