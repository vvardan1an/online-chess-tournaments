package am.itspace.onlinechesstournamentrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({"am.itspace.onlinechesstournamentcommon.*", "am.itspace.onlinechesstournamentrest.*"})
@EnableJpaRepositories(basePackages = {"am.itspace.onlinechesstournamentcommon.repository"})
@EntityScan({"am.itspace.onlinechesstournamentcommon.entity"})
@Configuration
@SpringBootApplication
@EnableSwagger2
public class OnlineChessTournamentRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineChessTournamentRestApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
