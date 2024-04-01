package com.project.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter // 모든 필드에 접근 가능하게 설정
@ToString // 쉽게 출력 가능하게 설정
@Table(indexes = { // 쉽게 관찰 가능하게 설정
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy"),
})
@Entity // Entity 임을 명시
public class Article {
    // 기본 Filed
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 설정
    private Long id; // 아이디

    @Setter @Column(nullable = false) private String title; // 제목 (수정 가능)
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문 (수정 가능, 10000자)

    @Setter private String hashtag; // 해시태그 (수정 가능)

    @ToString.Exclude // 순환 참조 발생 시 연결 해제
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>(); // 양방향 바인딩

    @CreatedDate @Column(nullable = false) private LocalDateTime createAt; // 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createBy; // 생성자 (100자)
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy; // 수정자 (100자)

    // 기능
    protected Article() {} // 기본 생성자

    private Article(String title, String content, String hashtag) {
        // 도메인 Article 생성할 때, 필요한 정보 세팅
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        // 사용하기 편하게 세팅
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        // id를 기준으로 동일성, 동등성 검사
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
