package com.project.board.service;

import com.project.board.domain.type.SearchType;
import com.project.board.dto.ArticleDto;
import com.project.board.dto.ArticleWithCommentsDto;
import com.project.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 필드에 대한 생성자를 자동 생성
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    // 서비스 메소드
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(ArticleDto dto) {
    }

    public void deleteArticle(long articleId) {
    }

}
