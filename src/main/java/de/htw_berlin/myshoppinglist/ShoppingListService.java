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
    public Iterable<ShoppingList> getByUserId(String userId) {
        return shoppingListRepo.findByOwnerId(userId);
    }

    public ShoppingList save(ShoppingList shoppingList) {
        if (shoppingList.getOwner() != null && shoppingList.getOwner().getId() != null) {
            User owner = userRepository.findById(shoppingList.getOwner().getId())
                    .orElseGet(() -> userRepository.save(shoppingList.getOwner()));

            shoppingList.setOwner(owner);
        }

        return shoppingListRepo.save(shoppingList);
    }
    public ShoppingList toggleFavorite(Long id) {
        ShoppingList list = shoppingListRepo.findById(id).orElseThrow();

        list.setFavorite(!Boolean.TRUE.equals(list.getFavorite()));

        return shoppingListRepo.save(list);
    }

    public void delete(Long id) {
        shoppingListRepo.deleteById(id);
    }

}