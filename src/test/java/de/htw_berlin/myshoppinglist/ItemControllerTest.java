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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ItemControllerTest {

    private MockMvc mockMvc;
    private ItemService service;

    @BeforeEach
    void setup() {
        service = mock(ItemService.class);

        ItemController controller = new ItemController();
        ReflectionTestUtils.setField(controller, "service", service);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldGetItemById() throws Exception {
        Item item = new Item();
        item.setId(1L);
        item.setName("Milch");

        when(service.getById(1L)).thenReturn(Optional.of(item));

        mockMvc.perform(get("/item/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Milch")));

        verify(service).getById(1L);
    }

    @Test
    void shouldGetAllItems() throws Exception {
        Item item1 = new Item();
        item1.setName("Milch");

        Item item2 = new Item();
        item2.setName("Brot");

        when(service.getAll()).thenReturn(List.of(item1, item2));

        mockMvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Milch")))
                .andExpect(content().string(containsString("Brot")));

        verify(service).getAll();
    }

    @Test
    void shouldGetItemsByShoppingListId() throws Exception {
        Item item = new Item();
        item.setName("Apfel");

        when(service.getByShoppingListId(5L)).thenReturn(List.of(item));

        mockMvc.perform(get("/item/shoppinglist/5"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Apfel")));

        verify(service).getByShoppingListId(5L);
    }
}
