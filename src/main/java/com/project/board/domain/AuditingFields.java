package com.project.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter // 모든 필드에 접근 가능하게 설정
@ToString // 쉽게 출력 가능하게 설정
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 설정
@MappedSuperclass // 상속을 통한 요소 추출
public class AuditingFields {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false) // 공백 불가, 업데이트 불가
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 100) // 공백 불가, 업데이트 불가, 길이 제한 100
    private String createdBy; // 생성자 (100자)

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false) // 공백 불가
    private LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100) // 공백 불가, 길이 제한 100
    private String modifiedBy; // 수정자 (100자)

}
