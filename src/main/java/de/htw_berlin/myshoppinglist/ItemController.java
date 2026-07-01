package de.htw_berlin.myshoppinglist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping
    public Iterable<Item> getAllItems() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        item.setId(id);
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/shoppinglist/{shoppingListId}")
    public Iterable<Item> getItemsByShoppingListId(@PathVariable Long shoppingListId) {
        return service.getByShoppingListId(shoppingListId);
    }
}