package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping
    public Iterable<ShoppingList> getAllShoppingList() {
        return shoppingListService.getAll();
    }

    @GetMapping("/{id}")
    public ShoppingList getShoppingListById(@PathVariable Long id) {
        return shoppingListService.getById(id).orElseThrow();
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

    @DeleteMapping("/{id}")
    public void deleteShoppingList(@PathVariable Long id) {
        shoppingListService.delete(id);
    }
}
