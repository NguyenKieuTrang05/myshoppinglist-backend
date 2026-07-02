package de.htw_berlin.myshoppinglist;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @GetMapping
    public Iterable<Friendship> getAll() {
        return friendshipService.getAll();
    }

    @GetMapping("/user/{userId}")
    public Iterable<Friendship> getByUser(@PathVariable String userId) {
        return friendshipService.getByUserId(userId);
    }

    @PostMapping
    public Friendship create(@RequestBody Friendship friendship) {
        return friendshipService.save(friendship);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        friendshipService.delete(id);
    }
    @PutMapping("/{id}/accept")
    public Friendship acceptFriendship(@PathVariable Long id) {
        return friendshipService.accept(id);
    }

    @PutMapping("/{id}/decline")
    public Friendship declineFriendship(@PathVariable Long id) {
        return friendshipService.decline(id);
    }
}