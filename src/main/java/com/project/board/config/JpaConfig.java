package com.project.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing // JPA Auditing 활성화
@Configuration // 각종 설정 정의
public class JpaConfig {
    // 작업을 수행한 사람의 이름을 Auditing 하기 위한 설정
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("junsu"); // TODO: 스프틸 시큐리티로 인증 구현 시 수정
    }
}
