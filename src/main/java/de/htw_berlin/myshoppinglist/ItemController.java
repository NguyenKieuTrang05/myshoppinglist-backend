package de.htw_berlin.myshoppinglist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return List.of(
                new Item("Sneaker", "Fashion", "1 Stück", "Nike", "https://shop.de/sneaker", 89.99, "Hoch", "Zu kaufen", false),
                new Item("Foundation", "Beauty", "1 Stück", "Douglas", "https://shop.de/serum", 19.99, "Mittel", "Gekauft", true),
                new Item("Proteinriegel", "Food", "5 Stück", "Rewe", "https://shop.de/riegel", 2.49, "Niedrig", "Zu kaufen", false),
                new Item("Buch", "Books", "1 Stück", "Amazon", "https://shop.de/cleancode", 29.99, "Mittel", "Gekauft", true)
        );
    }
}