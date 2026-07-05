package de.htw_berlin.myshoppinglist;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShoppingListServiceTest {

    @Test
    void shouldFindShoppingListById() {
        ShoppingListRepository repo = mock(ShoppingListRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        CurrentUserService currentUserService = mock(CurrentUserService.class);

        ShoppingListService service =
                new ShoppingListService(repo, userRepository, currentUserService);

        ShoppingList list = new ShoppingList();
        list.setId(1L);
        list.setName("Obst");

        when(repo.findById(1L)).thenReturn(Optional.of(list));

        Optional<ShoppingList> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals("Obst", result.get().getName());
    }

    @Test
    void shouldReturnAllShoppingLists() {
        ShoppingListRepository repo = mock(ShoppingListRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        CurrentUserService currentUserService = mock(CurrentUserService.class);

        ShoppingListService service =
                new ShoppingListService(repo, userRepository, currentUserService);

        ShoppingList list1 = new ShoppingList();
        list1.setName("Obst");

        ShoppingList list2 = new ShoppingList();
        list2.setName("Drogerie");

        when(repo.findAll()).thenReturn(List.of(list1, list2));

        Iterable<ShoppingList> result = service.getAll();

        assertEquals(2, ((List<ShoppingList>) result).size());
    }

    @Test
    void shouldToggleFavorite() {
        ShoppingListRepository repo = mock(ShoppingListRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        CurrentUserService currentUserService = mock(CurrentUserService.class);

        ShoppingListService service =
                new ShoppingListService(repo, userRepository, currentUserService);

        ShoppingList list = new ShoppingList();
        list.setId(1L);
        list.setFavorite(false);

        when(repo.findById(1L)).thenReturn(Optional.of(list));
        when(repo.save(list)).thenReturn(list);

        ShoppingList result = service.toggleFavorite(1L);

        assertTrue(result.getFavorite());
        verify(repo).save(list);
    }

    @Test
    void shouldDeleteShoppingList() {
        ShoppingListRepository repo = mock(ShoppingListRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        CurrentUserService currentUserService = mock(CurrentUserService.class);

        ShoppingListService service =
                new ShoppingListService(repo, userRepository, currentUserService);

        service.delete(1L);

        verify(repo).deleteById(1L);
    }
}