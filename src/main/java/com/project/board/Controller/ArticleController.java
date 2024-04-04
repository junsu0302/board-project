package com.project.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/articles") // 전역 경로 설정
@Controller
public class ArticleController  {
    @GetMapping // Controller에서 View로 데이터 전달
    public String articles(ModelMap map) {
        map.addAttribute("articles", List.of()); // View에서 활용할 데이터
        return "articles/index"; // 해당 이름의 View 반환
    }

    @GetMapping("/{articleId}") // Controller에서 View로 데이터 전달
    public String article(@PathVariable Long articleId, ModelMap map) {
        map.addAttribute("article", "article"); // View에서 활용할 데이터 TODO: 구현할 때 실제 데이터 넣어야 함
        map.addAttribute("articleComments", List.of()); // View에서 활용할 데이터
        return "articles/detail"; // 해당 이름의 View 반환
    }
}
