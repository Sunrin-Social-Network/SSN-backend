package io.twotle.ssn.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "text")
    private String introduce;

    @Column( columnDefinition = "varchar(255) default 'https://cdn.jsdelivr.net/gh/2tle/staticfiles@master/profile.PNG'")
    private String profileUrl;

    @Builder
    public User(String email, String password, String username, String introduce) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.introduce = introduce;
    }

}
