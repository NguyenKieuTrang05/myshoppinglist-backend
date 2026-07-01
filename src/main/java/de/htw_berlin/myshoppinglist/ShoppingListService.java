package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingListService {


    @Autowired
    private ShoppingListRepository shoppingListRepo;

    public Iterable<ShoppingList> getAll() {
        return shoppingListRepo.findAll();
    }
    public Optional<ShoppingList> getById(Long id) {
        return shoppingListRepo.findById(id);
    }
    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListRepo.save(shoppingList);
    }
    public void delete(Long id) {
        shoppingListRepo.deleteById(id);
    }
}
