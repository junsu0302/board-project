package com.project.board.service;

import com.project.board.domain.type.SearchType;
import com.project.board.dto.ArticleDto;
import com.project.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 필드에 대한 생성자를 자동 생성
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    // 서비스 메소드
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }
}
