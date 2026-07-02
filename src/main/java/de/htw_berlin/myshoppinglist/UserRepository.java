package de.htw_berlin.myshoppinglist;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
