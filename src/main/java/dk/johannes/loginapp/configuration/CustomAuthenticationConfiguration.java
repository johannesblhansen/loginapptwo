package dk.johannes.loginapp.configuration;

import dk.johannes.loginapp.security.custom.JohannesDefaultFilter;
import dk.johannes.loginapp.security.TestAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
@Order(3)
public class CustomAuthenticationConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TestAuthProvider testAuthProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(testAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/nosec").permitAll()
                .antMatchers("/sec").authenticated();

        httpSecurity.addFilterBefore(new JohannesDefaultFilter(), BasicAuthenticationFilter.class);
    }
}
