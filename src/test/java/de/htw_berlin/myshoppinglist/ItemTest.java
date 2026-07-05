package de.htw_berlin.myshoppinglist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void shouldStoreItemValues() {
        Item item = new Item();

        item.setId(1L);
        item.setName("Mango");
        item.setCategory("Obst");
        item.setAmount("2");
        item.setShop("REWE");
        item.setUrl("https://rewe.de");
        item.setPrice(4.0);
        item.setPriority("Mittel");
        item.setStatus("Offen");
        item.setPurchased(false);

        assertEquals(1L, item.getId());
        assertEquals("Mango", item.getName());
        assertEquals("Obst", item.getCategory());
        assertEquals("2", item.getAmount());
        assertEquals("REWE", item.getShop());
        assertEquals("https://rewe.de", item.getUrl());
        assertEquals(4.0, item.getPrice());
        assertEquals("Mittel", item.getPriority());
        assertEquals("Offen", item.getStatus());
        assertFalse(item.isPurchased());
    }

    @Test
    void constructorShouldSetValues() {
        Item item = new Item(
                "Shampoo",
                "Drogerie",
                "1 Stück",
                "DM",
                "",
                2.99,
                "Hoch",
                "Offen",
                false
        );

        assertEquals("Shampoo", item.getName());
        assertEquals("Drogerie", item.getCategory());
        assertEquals("1 Stück", item.getAmount());
        assertEquals("DM", item.getShop());
        assertEquals(2.99, item.getPrice());
        assertEquals("Hoch", item.getPriority());
        assertEquals("Offen", item.getStatus());
        assertFalse(item.isPurchased());
    }

    @Test
    void shouldConnectItemWithShoppingList() {
        ShoppingList list = new ShoppingList();
        list.setId(5L);

        Item item = new Item();
        item.setShoppingList(list);

        assertEquals(5L, item.getShoppingList().getId());
    }
}