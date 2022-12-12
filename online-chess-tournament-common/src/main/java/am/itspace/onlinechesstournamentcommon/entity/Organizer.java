package am.itspace.onlinechesstournamentcommon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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

    @OneToMany(mappedBy="organizer")
    private List<Tournament> tournamentList;
}