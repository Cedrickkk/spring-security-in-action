package org.spring.security.ssiach3ex1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    private String authority;

}
