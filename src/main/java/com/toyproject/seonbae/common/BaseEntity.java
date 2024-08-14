package com.toyproject.seonbae.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedBy
    private Long regId; // 작성자

    @LastModifiedBy
    private Long updateId; // 수정자

    @CreatedDate
    private LocalDateTime createdDate; // 생성시간

    @LastModifiedDate
    private LocalDateTime modifiedDate; // 수정시간
}
