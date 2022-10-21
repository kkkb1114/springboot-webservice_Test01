package com.project.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우 해당 클래스의 필드들도 칼럼으로 인식한다.
@EntityListeners({AuditingEntityListener.class}) // BaseTimeEntity.class에 Auditing 기능을 추가한다.
public abstract class BaseTimeEntity {
    
    @CreatedDate // Entity가 생성되어 저장될때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity의 값을 수정할때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
