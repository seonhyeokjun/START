package com.toyproject.seonbae.user.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Comment("사용자 이름")
    @Column(nullable = false, unique = true, length = 200)
    private String userName;

    @Comment("사용자 비밀번호")
    @Column(nullable = false)
    private String password;

    @Comment("사용자 닉네임")
    @Column(nullable = false, unique = true, length = 200)
    private String nickName;

    @Comment("사용자 활성화")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
