package com.project.board.service;

import com.project.board.domain.Article;
import com.project.board.domain.type.SearchType;
import com.project.board.dto.ArticleDto;
import com.project.board.dto.ArticleUpdateDto;
import com.project.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

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

    @DisplayName("게시글 정보 입력 시, 게시글 생성")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "junsu", "title", "content", "#java"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID, 수정 정보 입력 시, 게시글 수정")
    @Test
    void givenArticleIdAndModified_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID 입력 시, 게시글 삭제")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);

        // Then
        then(articleRepository).should().delete(any(Article.class));
    }
    
}