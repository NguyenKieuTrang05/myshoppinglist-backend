package de.htw_berlin.myshoppinglist;

import org.springframework.stereotype.Service;

@Service
public class SharedShoppingListService {
    private SharedShoppingListRepository sharedRepository;

    public SharedShoppingListService(SharedShoppingListRepository sharedRepository) {
        this.sharedRepository = sharedRepository;
    }
    public Iterable<SharedShoppingList> getAll() {
        return sharedRepository.findAll();
    }
    public Iterable<SharedShoppingList> getByUserId(String userId) {
        return sharedRepository.findByUserId(userId);
    }
    public SharedShoppingList save(SharedShoppingList sharedShoppingList) {
        return sharedRepository.save(sharedShoppingList);
    }
    public void delete(Long id) {
        sharedRepository.deleteById(id);
    }

}
