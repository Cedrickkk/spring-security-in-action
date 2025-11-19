package org.spring.security.ssiach3ex1.config;

import org.spring.security.ssiach3ex1.security.User;
import org.spring.security.ssiach3ex1.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = new User("hula@nm0", "admin12345", "READ");
        List<UserDetails> users = List.of(userDetails);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
