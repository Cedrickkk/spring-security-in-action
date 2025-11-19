package org.spring.security.ssiach2ex5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsManager _userDetailsService = new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("hula@nm0")
                .password("12345")
                .build();

        _userDetailsService.createUser(user);

        return _userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
