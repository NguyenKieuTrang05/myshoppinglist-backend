package de.htw_berlin.myshoppinglist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public Iterable<Item> getAll() {
        return repo.findAll();
    }
    public Optional<Item> getById(Long id) {
        return repo.findById(id);
    }

    public Iterable<Item> getByShoppingListId(Long shoppingListId) {
        return repo.findByShoppingListId(shoppingListId);
    }

    public Item save(Item item) {
        return repo.save(item);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}