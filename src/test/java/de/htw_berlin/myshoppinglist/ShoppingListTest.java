package de.htw_berlin.myshoppinglist;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void shouldStoreShoppingListValues() {
        ShoppingList list = new ShoppingList();

        list.setId(1L);
        list.setEmoji("🍏");
        list.setName("Obst");
        list.setCategory("Lebensmittel");
        list.setFavorite(true);

        assertEquals(1L, list.getId());
        assertEquals("🍏", list.getEmoji());
        assertEquals("Obst", list.getName());
        assertEquals("Lebensmittel", list.getCategory());
        assertTrue(list.getFavorite());
    }

    @Test
    void shouldSetCreatedAtAutomatically() {
        ShoppingList list = new ShoppingList();

        assertNotNull(list.getCreatedAt());
    }

    @Test
    void constructorShouldUseGivenCreatedAt() {
        LocalDate date = LocalDate.of(2026, 7, 5);

        ShoppingList list = new ShoppingList("🛒", "Edeka", "Lebensmittel", date);

        assertEquals(date, list.getCreatedAt());
    }

    @Test
    void constructorShouldUseTodayWhenCreatedAtIsNull() {
        ShoppingList list = new ShoppingList("🛒", "Edeka", "Lebensmittel", null);

        assertEquals(LocalDate.now(), list.getCreatedAt());
    }
}