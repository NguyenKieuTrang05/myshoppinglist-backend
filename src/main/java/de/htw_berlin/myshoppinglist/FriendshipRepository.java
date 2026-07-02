package de.htw_berlin.myshoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

    List<Friendship> findByUserId(String userId);

    boolean existsByUserIdAndFriendId(String userId, String friendId);

    boolean existsByUserIdAndFriendIdAndStatus(
            String userId,
            String friendId,
            FriendshipStatus status
    );
}
