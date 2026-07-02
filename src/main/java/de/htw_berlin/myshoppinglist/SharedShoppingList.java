package de.htw_berlin.myshoppinglist;

import jakarta.persistence.*;

@Entity
public class SharedShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ShoppingList shoppingList;

    @ManyToOne
    private User user;

    public SharedShoppingList() {
    }
    public SharedShoppingList(Long id, ShoppingList shoppingList, User user) {
        this.id = id;
        this.shoppingList = shoppingList;
        this.user = user;
    }
    public Long getId() { return id; }
    public void setId(Long id) {this.id = id;}

    public ShoppingList getShoppingList() {return shoppingList;}
    public void setShoppingList(ShoppingList shoppingList) {this.shoppingList = shoppingList;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
