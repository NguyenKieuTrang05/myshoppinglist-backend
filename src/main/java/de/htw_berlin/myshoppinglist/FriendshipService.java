package de.htw_berlin.myshoppinglist;

import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public Iterable<Friendship> getAll() {
        return friendshipRepository.findAll();
    }

    public Iterable<Friendship> getByUserId(String userId) {
        return friendshipRepository.findByUserId(userId);
    }

    public Friendship save(Friendship friendship) {
        String userId = friendship.getUser().getId();
        String friendId = friendship.getFriend().getId();

        if (userId.equals(friendId)) {
            throw new BadRequestException("User cannot add themselves as a friend.");
        }

        boolean exists =
                friendshipRepository.existsByUserIdAndFriendId(userId, friendId) ||
                        friendshipRepository.existsByUserIdAndFriendId(friendId, userId);

        if (exists) {
            throw new BadRequestException("Friend request already exists.");
        }

        friendship.setStatus(FriendshipStatus.PENDING);
        return friendshipRepository.save(friendship);
    }

    public void delete(Long id) {
        friendshipRepository.deleteById(id);
    }
    public Friendship accept(Long id) {
        Friendship friendship = friendshipRepository.findById(id).orElseThrow();

        if (friendship.getStatus() != FriendshipStatus.PENDING) {
            throw new BadRequestException("Friend request already processed.");
        }
        friendship.setStatus(FriendshipStatus.ACCEPTED);
        return friendshipRepository.save(friendship);
    }

    public Friendship decline(Long id) {
        Friendship friendship = friendshipRepository.findById(id).orElseThrow();

        if (friendship.getStatus() != FriendshipStatus.PENDING) {
            throw new BadRequestException("Friend request already processed.");
        }

        friendship.setStatus(FriendshipStatus.DECLINED);
        return friendshipRepository.save(friendship);
    }
}