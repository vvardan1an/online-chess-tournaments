package am.itspace.onlinechesstournamentcommon.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String nationality;

    private int age;

    private String email;

    private String password;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Tournament> tournamentList;
}
