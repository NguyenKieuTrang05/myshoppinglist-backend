package de.htw_berlin.myshoppinglist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/item")
    public Iterable<Item> getAllItems() {
        return service.getAll();
    }

    @PostMapping("/item")
    public Item createItem(@RequestBody Item item) {
        return service.save(item);
    }
}