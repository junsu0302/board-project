package com.project.board.dto;

import com.project.board.domain.Article;
import com.project.board.domain.UserAccount;

import java.time.LocalDateTime;

public record ArticleDto(
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleDto of(long l, UserAccountDto userAccountDto, String title, String content, String hashtag, LocalDateTime now, String uno, LocalDateTime nowed, String s) {
        return new ArticleDto(null, userAccountDto, title, content, hashtag, null, null, null, null);
    }

    // Entity로부터 DTO 생성
    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    // DTO로부터 Entity 생성
    public Article toEntity(UserAccount userAccount) {
        return Article.of(
                userAccount,
                title,
                content,
                hashtag
        );
    }
}