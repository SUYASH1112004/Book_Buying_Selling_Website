package BookStore.Backend.Server.SecurityConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
    {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                                .requestMatchers("/","/Login","/Signup","/Home").permitAll()
                                .anyRequest().authenticated()
                        );
        return http.build();
    }
}
