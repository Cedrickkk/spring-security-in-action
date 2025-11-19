package org.spring.security.ssiach3ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        DefaultSpringSecurityContextSource defaultSpringSecurityContextSource =
                new DefaultSpringSecurityContextSource("ldap://127.0.0.1:33389/dc=springframework,dc=org");
        defaultSpringSecurityContextSource.afterPropertiesSet();

        LdapUserDetailsManager userDetailsManager =
                new LdapUserDetailsManager(defaultSpringSecurityContextSource);

        userDetailsManager.setUsernameMapper(
                new DefaultLdapUsernameToDnMapper("ou=groups", "uid"));

        userDetailsManager.setGroupSearchBase("ou=groups");

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
