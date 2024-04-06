package com.project.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.project.board.domain.ArticleComment}
 */
public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {
    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }

    public static ArticleCommentDto of(long l, long l1, UserAccountDto userAccountDto, String content, LocalDateTime now, String junsu, LocalDateTime now1, String junsu1) {
        return null;
    }

    public Long articleId() {
        return null;
    }

    public Long id() {
        return null;
    }
}