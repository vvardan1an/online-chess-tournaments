package am.itspace.onlinechesstournamentmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"am.itspace.onlinechesstournamentcommon.*", "am.itspace.onlinechesstournamentmvc.*"})
@EnableJpaRepositories(basePackages = {"am.itspace.onlinechesstournamentcommon.repository"})
@EntityScan({"am.itspace.onlinechesstournamentcommon.entity"})
@SpringBootApplication
public class OnlineChessTournamentMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineChessTournamentMvcApplication.class, args);
    }
}
