package de.htw_berlin.myshoppinglist;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepo;
    private final UserRepository userRepository;
    private final CurrentUserService currentUserService;

    public ShoppingListService(
            ShoppingListRepository shoppingListRepo,
            UserRepository userRepository,
            CurrentUserService currentUserService) {
        this.shoppingListRepo = shoppingListRepo;
        this.userRepository = userRepository;
        this.currentUserService = currentUserService;
    }

    public Iterable<ShoppingList> getAll() {
        return shoppingListRepo.findAll();
    }

    public Optional<ShoppingList> getById(Long id) {
        return shoppingListRepo.findById(id);
    }

    public ShoppingList save(ShoppingList shoppingList) {
        String userId = currentUserService.getCurrentUserId();

        User owner = userRepository.findById(userId)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setId(userId);
                    return userRepository.save(newUser);
                });

        shoppingList.setOwner(owner);

        return shoppingListRepo.save(shoppingList);
    }

    public void delete(Long id) {
        shoppingListRepo.deleteById(id);
    }
}