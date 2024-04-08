package com.project.board.Controller;

import com.project.board.domain.type.SearchType;
import com.project.board.dto.response.ArticleResponse;
import com.project.board.dto.response.ArticleWithCommentsResponse;
import com.project.board.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor // 생성자 자동 생성
@RequestMapping("/articles") // 전역 경로 설정
@Controller
public class ArticleController  {

    private final ArticleService articleService;

    @GetMapping // Controller에서 View로 데이터 전달
    public String articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ) {
        map.addAttribute("articles", articleService.searchArticles(searchType, searchValue, pageable).map(ArticleResponse::from));
        return "articles/index"; // 해당 이름의 View 반환
    }

    @GetMapping("/{articleId}") // Controller에서 View로 데이터 전달
    public String article(@PathVariable Long articleId, ModelMap map) {
        ArticleWithCommentsResponse article = ArticleWithCommentsResponse.from(articleService.getArticle(articleId));
        map.addAttribute("article", article); // View에서 활용할 데이터
        map.addAttribute("articleComments", article.articleCommentResponse()); // View에서 활용할 데이터

        return "articles/detail"; // 해당 이름의 View 반환
    }
}
