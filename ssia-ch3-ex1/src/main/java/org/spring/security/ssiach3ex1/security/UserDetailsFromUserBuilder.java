package org.spring.security.ssiach3ex1.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsFromUserBuilder {

    public void createUserDetailsFromUserBuilder() {
        User.UserBuilder userBuilder = User.withUsername("hula@nm0");

        UserDetails userDetails = userBuilder.password("admin12345")
                .authorities("READ", "WRITE")
                .passwordEncoder(s ->  "@" + s)
                .accountExpired(false)
                .disabled(false)
                .build();

        User.UserBuilder _userBuilder = User.withUserDetails(userDetails);
        UserDetails _useDetails = _userBuilder.build();
    }
}
