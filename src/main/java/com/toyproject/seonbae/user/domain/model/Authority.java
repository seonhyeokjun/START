package com.toyproject.seonbae.user.domain.model;

import com.toyproject.seonbae.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Authority extends BaseEntity {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}
