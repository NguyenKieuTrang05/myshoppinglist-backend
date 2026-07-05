package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Iterable<ShoppingList> getAllShoppingList() {
        return shoppingListService.getAll();
    }

    @GetMapping("/user/{userId}")
    public Iterable<ShoppingList> getShoppingListsByUser(@PathVariable String userId) {
        return shoppingListService.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public ShoppingList getShoppingListById(@PathVariable Long id) {
        return shoppingListService.getById(id).orElseThrow();
    }
    @GetMapping("/{id}/items")
    public Iterable<Item> getItemsFromShoppingList(@PathVariable Long id) {
        return itemService.getByShoppingListId(id);
    }

    @PostMapping
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.save(shoppingList);
    }

    @PutMapping("/{id}")
    public ShoppingList updateShoppingList(@PathVariable Long id, @RequestBody ShoppingList shoppingList) {
        shoppingList.setId(id);
        return shoppingListService.save(shoppingList);
    }
    @PatchMapping("/{id}/favorite")
    public ShoppingList toggleFavorite(@PathVariable Long id) {
        return shoppingListService.toggleFavorite(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingList(@PathVariable Long id) {
        shoppingListService.delete(id);
    }
}
