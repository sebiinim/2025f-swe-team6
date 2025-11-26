package kr.ac.korea.budding.entity;

import jakarta.persistence.*;
import kr.ac.korea.budding.enums.FriendshipStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "friendships",
uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_friendship",
                columnNames = {"user1_id", "user2_id"}
        )
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private UserEntity user2;

    @Enumerated
    private FriendshipStatus status;

    private LocalDateTime createdAt;
}
