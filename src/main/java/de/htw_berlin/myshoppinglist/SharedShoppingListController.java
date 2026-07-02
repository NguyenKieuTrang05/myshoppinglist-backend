package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shared-shoppinglists")
public class SharedShoppingListController {
    @Autowired
    private SharedShoppingListService sharedShoppingListService;

    @GetMapping
    public Iterable<SharedShoppingList> getAll() {
        return sharedShoppingListService.getAll();
    }
    @GetMapping("/user/{userId}")
    public Iterable<SharedShoppingList> getSharedListsByUser(@PathVariable String userId) {
        return sharedShoppingListService.getByUserId(userId);
    }

    @PostMapping
    public SharedShoppingList shareList(@RequestBody SharedShoppingList sharedShoppingList) {
        return sharedShoppingListService.save(sharedShoppingList);
    }

    @DeleteMapping("/{id}")
    public void deleteSharedList(@PathVariable Long id) {
        sharedShoppingListService.delete(id);
    }
}
