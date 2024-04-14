package com.project.board.dto.request;

import com.project.board.dto.ArticleDto;
import com.project.board.dto.UserAccountDto;

import java.time.LocalDateTime;

public record ArticleRequest(
        String title,
        String content,
        String hashtag
) {

    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return ArticleDto.of(
                1L, userAccountDto,
                title,
                content,
                hashtag,
                LocalDateTime.now(), "junsu", LocalDateTime.now(), "junsu");
    }

}