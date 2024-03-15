package org.example.authorization_and_authentication.repository;

import org.example.authorization_and_authentication.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByName(String name);
}
