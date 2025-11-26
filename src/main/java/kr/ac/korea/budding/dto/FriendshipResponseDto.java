package kr.ac.korea.budding.dto;

import kr.ac.korea.budding.entity.UserEntity;
import kr.ac.korea.budding.enums.FriendshipStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FriendshipResponseDto {

    private Integer id;

    private Integer user1Id;

    private Integer user2Id;

    private FriendshipStatus status;

    private LocalDateTime createdAt;
}
