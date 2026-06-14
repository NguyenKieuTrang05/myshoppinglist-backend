package de.htw_berlin.myshoppinglist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public Iterable<Item> getAll() {
        return repo.findAll();
    }

    public Item save(Item item) {
        return repo.save(item);
    }
}