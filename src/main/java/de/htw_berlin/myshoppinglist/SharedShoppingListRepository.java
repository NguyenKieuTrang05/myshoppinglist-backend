package de.htw_berlin.myshoppinglist;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SharedShoppingListRepository extends CrudRepository<SharedShoppingList, Long> {
    List<SharedShoppingList> findByUserId(String userId);
}
