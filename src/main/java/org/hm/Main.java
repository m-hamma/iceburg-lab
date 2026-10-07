package org.hm;

import org.hm.model.User;
import org.hm.repository.UserIcebergRepository;
import org.hm.service.UserService;

public class Main {

    public static void main(String[] args) {

        UserIcebergRepository repository =
                new UserIcebergRepository();

        UserService service =
                new UserService(repository);
        service.createTable();

        service.createUser(
                new User(
                        1L,
                        "mohamed.hamma",
                        "ADMIN",
                        true
                )
        );
    }
}