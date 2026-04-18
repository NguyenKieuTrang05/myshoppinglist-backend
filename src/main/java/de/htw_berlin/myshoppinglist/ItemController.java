package de.htw_berlin.myshoppinglist;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return List.of(
                new Item("Sneaker", "Fashion", 89.99, "https://shop.de/sneaker", false),
                new Item("Foundation", "Beauty", 19.99, "https://shop.de/serum", true),
                new Item("Proteinriegel", "Food", 2.49, "https://shop.de/riegel", false),
                new Item("Buch", "Books", 29.99, "https://shop.de/cleancode", true)
        );

    }
}
