package am.itspace.onlinechesstournamentrest.security.config;


import am.itspace.onlinechesstournamentcommon.auth.CurrentUserDetailServiceImpl;
import am.itspace.onlinechesstournamentcommon.entity.UserType;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JWTAuthenticationTokenFilter;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CurrentUserDetailServiceImpl userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/worldChessChampion").authenticated()
//                .antMatchers(HttpMethod.POST, "/products").hasAuthority(Role.USER.name())
//                .antMatchers(HttpMethod.PUT, "/products/{id}").hasAuthority(Role.USER.name())
//                .antMatchers(HttpMethod.DELETE, "/products/{id}").hasAuthority(Role.USER.name())
                .anyRequest().permitAll();
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public JWTAuthenticationTokenFilter authenticationTokenFilterBean() {
        return new JWTAuthenticationTokenFilter();
    }
}

