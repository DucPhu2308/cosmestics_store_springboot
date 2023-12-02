package hcmute.springbootdemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hcmute.springbootdemo.Repository.UserRepository;
import hcmute.springbootdemo.Service.impl.UserDetailsServiceImpl;

@Configuration
public class SecurityInitialization {
    private final UserRepository userRepository;

    public SecurityInitialization(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userRepository);
    }
    
}
