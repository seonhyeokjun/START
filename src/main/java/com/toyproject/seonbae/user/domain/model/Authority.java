package com.toyproject.seonbae.user.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}
