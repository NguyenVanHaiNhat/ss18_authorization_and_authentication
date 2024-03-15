package org.example.authorization_and_authentication.repository;

import org.example.authorization_and_authentication.model.AppRole;
import org.springframework.data.repository.CrudRepository;


public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
}
