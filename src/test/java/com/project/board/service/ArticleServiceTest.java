package com.project.board.service;

import com.project.board.domain.type.SearchType;
import com.project.board.dto.ArticleDto;
import com.project.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    // 테스트 타겟 정의
    @InjectMocks private ArticleService sut; // System Under Test (테스트 대상)

    @Mock private ArticleRepository articleRepository; // 의존 대상

    // 테스트 정의
    @DisplayName("게시글 검색 시, 게시글 리스트 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        // Given


        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 조회 시, 게시글 반환")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given


        // When
        ArticleDto articles = sut.searchArticle(1L);

        // Then
        assertThat(articles).isNotNull();
    }
}