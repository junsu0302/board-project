package com.project.board.controller;

import com.project.board.Controller.MainController;
import com.project.board.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@DisplayName("View Controller - 메인페이지")
@WebMvcTest(MainController.class)
class MainControllerTest {
    // 테스트 타겟
    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    // 테스트 정의
    @DisplayName("[view][GET] 루트 페이지 테스트")
    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToArticlesPage() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());

    }
}