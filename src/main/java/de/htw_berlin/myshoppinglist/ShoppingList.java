package de.htw_berlin.myshoppinglist;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emoji;
    private String name;
    private String category;
    private LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "shoppingList")
    private List<Item> items;

    public ShoppingList() {
        this.createdAt = LocalDate.now();
    }

    public ShoppingList(String emoji, String name, String category, LocalDate createdAt) {
        this.emoji = emoji;
        this.name = name;
        this.category = category;
        this.createdAt = createdAt != null ? createdAt : LocalDate.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

}
