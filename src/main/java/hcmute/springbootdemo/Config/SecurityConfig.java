package hcmute.springbootdemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                // Require "ADMIN" role for any request under "/admin"
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                // Require "USER" role for any request containing "cart" or "review" in the path
                .antMatchers("/**cart**").hasAuthority("ROLE_USER")
                .antMatchers("/**review**").hasAuthority("ROLE_USER")
                // Allow access to the root path "/" without any authentication
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
                .and()
            .formLogin()
                .loginPage("/login") // adjust login page URL
                .usernameParameter("Email")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/checkout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
            .rememberMe()
                .rememberMeParameter("remember-me")
                .userDetailsService(userDetailsService)
                // 1 day in seconds
                .tokenValiditySeconds(86400)
                .key("uniqueAndSecret");


        return http.build();
            
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
