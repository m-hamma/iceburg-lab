package org.hm.service;

import org.hm.model.User;
import org.hm.repository.UserIcebergRepository;

public class UserService {

    private final UserIcebergRepository repository;

    public UserService(
            UserIcebergRepository repository) {

        this.repository = repository;
    }

    public void createUser(User user) {
        repository.insert(user);
    }
    public void createTable() {

        repository.createTable();

    }
}