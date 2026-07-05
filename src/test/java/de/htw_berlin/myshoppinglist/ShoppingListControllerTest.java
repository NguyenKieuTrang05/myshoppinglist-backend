package de.htw_berlin.myshoppinglist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ShoppingListControllerTest {

    private MockMvc mockMvc;
    private ShoppingListService shoppingListService;
    private ItemService itemService;

    @BeforeEach
    void setup() {
        shoppingListService = mock(ShoppingListService.class);
        itemService = mock(ItemService.class);

        ShoppingListController controller = new ShoppingListController();
        ReflectionTestUtils.setField(controller, "shoppingListService", shoppingListService);
        ReflectionTestUtils.setField(controller, "itemService", itemService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldGetShoppingListById() throws Exception {
        ShoppingList list = new ShoppingList();
        list.setId(1L);
        list.setName("Obst");
        list.setCategory("Lebensmittel");

        when(shoppingListService.getById(1L)).thenReturn(Optional.of(list));

        mockMvc.perform(get("/shoppinglist/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Obst")))
                .andExpect(content().string(containsString("Lebensmittel")));

        verify(shoppingListService).getById(1L);
    }

    @Test
    void shouldGetAllShoppingLists() throws Exception {
        ShoppingList list1 = new ShoppingList();
        list1.setName("Obst");

        ShoppingList list2 = new ShoppingList();
        list2.setName("Drogerie");

        when(shoppingListService.getAll()).thenReturn(List.of(list1, list2));

        mockMvc.perform(get("/shoppinglist"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Obst")))
                .andExpect(content().string(containsString("Drogerie")));

        verify(shoppingListService).getAll();
    }

    @Test
    void shouldGetShoppingListsByUser() throws Exception {
        ShoppingList list = new ShoppingList();
        list.setName("Edeka");

        when(shoppingListService.getByUserId("auth0|testuser"))
                .thenReturn(List.of(list));

        mockMvc.perform(get("/shoppinglist/user/{userId}", "auth0|testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Edeka")));

        verify(shoppingListService).getByUserId("auth0|testuser");
    }

    @Test
    void shouldGetItemsFromShoppingList() throws Exception {
        Item item = new Item();
        item.setName("Milch");

        when(itemService.getByShoppingListId(1L)).thenReturn(List.of(item));

        mockMvc.perform(get("/shoppinglist/1/items"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Milch")));

        verify(itemService).getByShoppingListId(1L);
    }

    @Test
    void shouldToggleFavorite() throws Exception {
        ShoppingList list = new ShoppingList();
        list.setId(1L);
        list.setName("Obst");
        list.setFavorite(true);

        when(shoppingListService.toggleFavorite(1L)).thenReturn(list);

        mockMvc.perform(patch("/shoppinglist/1/favorite"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Obst")))
                .andExpect(content().string(containsString("true")));

        verify(shoppingListService).toggleFavorite(1L);
    }
}