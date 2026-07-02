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
        friendship.setStatus(FriendshipStatus.PENDING);
        return friendshipRepository.save(friendship);
    }

    public void delete(Long id) {
        friendshipRepository.deleteById(id);
    }
    public Friendship accept(Long id) {
        Friendship friendship = friendshipRepository.findById(id).orElseThrow();

        if (friendship.getStatus() != FriendshipStatus.PENDING) {
            throw new IllegalStateException("Friend request already processed.");
        }
        friendship.setStatus(FriendshipStatus.ACCEPTED);
        return friendshipRepository.save(friendship);
    }

    public Friendship decline(Long id) {
        Friendship friendship = friendshipRepository.findById(id).orElseThrow();

        if (friendship.getStatus() != FriendshipStatus.PENDING) {
            throw new IllegalStateException("Friend request already processed.");
        }

        friendship.setStatus(FriendshipStatus.DECLINED);
        return friendshipRepository.save(friendship);
    }
}