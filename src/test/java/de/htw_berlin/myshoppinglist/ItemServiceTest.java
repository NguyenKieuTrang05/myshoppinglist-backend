package de.htw_berlin.myshoppinglist;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @Test
    void shouldReturnItemById() {

        ItemRepository repo = mock(ItemRepository.class);
        ItemService service = new ItemService(repo);

        Item item = new Item();
        item.setId(1L);
        item.setName("Milch");

        when(repo.findById(1L)).thenReturn(Optional.of(item));

        Optional<Item> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals("Milch", result.get().getName());

        verify(repo).findById(1L);
    }
    @Test
    void shouldSaveItem() {

        ItemRepository repo = mock(ItemRepository.class);
        ItemService service = new ItemService(repo);

        Item item = new Item();
        item.setName("Brot");

        when(repo.save(item)).thenReturn(item);

        Item result = service.save(item);

        assertEquals("Brot", result.getName());
        verify(repo).save(item);
    }
    @Test
    void shouldDeleteItem() {

        ItemRepository repo = mock(ItemRepository.class);
        ItemService service = new ItemService(repo);

        service.delete(1L);

        verify(repo).deleteById(1L);
    }
    @Test
    void shouldReturnAllItems() {

        ItemRepository repo = mock(ItemRepository.class);
        ItemService service = new ItemService(repo);

        Item item1 = new Item();
        Item item2 = new Item();

        when(repo.findAll()).thenReturn(List.of(item1, item2));

        Iterable<Item> result = service.getAll();

        assertEquals(2, ((List<Item>) result).size());
        verify(repo).findAll();
    }
    @Test
    void shouldReturnItemsByShoppingListId() {

        ItemRepository repo = mock(ItemRepository.class);
        ItemService service = new ItemService(repo);

        Item item = new Item();

        when(repo.findByShoppingListId(1L)).thenReturn(List.of(item));

        Iterable<Item> result = service.getByShoppingListId(1L);

        assertEquals(1, ((List<Item>) result).size());
        verify(repo).findByShoppingListId(1L);
    }

}
