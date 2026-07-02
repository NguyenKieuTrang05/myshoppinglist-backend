package de.htw_berlin.myshoppinglist;

import org.springframework.stereotype.Service;

@Service
public class SharedShoppingListService {
    private SharedShoppingListRepository sharedRepository;
    private FriendshipRepository friendshipRepository;

    public SharedShoppingListService(SharedShoppingListRepository sharedRepository,  FriendshipRepository friendshipRepository) {
        this.sharedRepository = sharedRepository;
        this.friendshipRepository = friendshipRepository;
    }
    public Iterable<SharedShoppingList> getAll() {
        return sharedRepository.findAll();
    }
    public Iterable<SharedShoppingList> getByUserId(String userId) {
        return sharedRepository.findByUserId(userId);
    }
    public SharedShoppingList save(SharedShoppingList sharedShoppingList) {
        String ownerId = sharedShoppingList.getShoppingList().getOwner().getId();
        String friendId = sharedShoppingList.getUser().getId();

        if (ownerId.equals(friendId)) {
            throw new BadRequestException("Owner cannot share the list with themselves.");
        }

        boolean areFriends = friendshipRepository.existsByUserIdAndFriendIdAndStatus(
                ownerId,
                friendId,
                FriendshipStatus.ACCEPTED
        );

        if (!areFriends) {
            throw new BadRequestException("Shopping list can only be shared with accepted friends.");
        }
        if (sharedRepository.existsByShoppingListIdAndUserId(
                sharedShoppingList.getShoppingList().getId(),
                friendId)) {
            throw new IllegalStateException("Shopping list is already shared with this user.");

        }
        return sharedRepository.save(sharedShoppingList);
    }
    public void delete(Long id) {
        sharedRepository.deleteById(id);
    }

}
