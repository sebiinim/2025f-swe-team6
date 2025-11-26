package kr.ac.korea.budding.mapper;

import kr.ac.korea.budding.dto.FriendshipResponseDto;
import kr.ac.korea.budding.entity.FriendshipEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FriendshipMapper {

    @Mappings({
            @Mapping(target="user1Id", source="user1.id"),
            @Mapping(target="user2Id", source="user2.id")
    })
    FriendshipResponseDto toDto(FriendshipEntity friendship);

    List<FriendshipResponseDto> toDto(List<FriendshipEntity> friendships);
}
