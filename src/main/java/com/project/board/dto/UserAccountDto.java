package com.project.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.project.board.domain.UserAccount}
 */
public record UserAccountDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,

        Long id,
        String userId,
        String userPassword,
        String email,
        String nickname,

        String memo
) {
    public static UserAccountDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, Long id, String userId, String userPassword, String email, String nickname, String memo) {
        return new UserAccountDto(createdAt, createdBy, modifiedAt, modifiedBy, id, userId, userPassword, email, nickname, memo);
    }
}