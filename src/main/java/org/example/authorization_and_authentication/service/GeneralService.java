package org.example.authorization_and_authentication.service;

import java.util.Optional;

public interface GeneralService<T> {
    void save(T t);
    void remove(Long id);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
}
