package cmepps.planificacion.de.entregas.burnup.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    
    
}
