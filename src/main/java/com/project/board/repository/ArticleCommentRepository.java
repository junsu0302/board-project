package com.project.board.repository;

import com.project.board.domain.ArticleComment;
import com.project.board.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>, // 모든 Entity에 대한 검색 기능 제공
        QuerydslBinderCustomizer<QArticleComment> // 커스텀 검색 기능 구현 기능 제공
{
    // 메소드
    List<ArticleComment> findByArticle_Id(Long articleId);

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // 부분 검색 기능 활성화
        bindings.excludeUnlistedProperties(true); // 선택적 검색 기능 활성화
        bindings.including(root.content, root.createdAt, root.createdBy); // 원하는 필드 추가

        // 검색 설정
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}