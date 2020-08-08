package com.baylab.project.domain.service;

import com.baylab.project.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserStorageTest {

    @Autowired
    UserStorage userStorage;

    @Test
    void testFindAll() {

        List<User> userList = userStorage.findAll();
        Assertions.assertEquals(userList.size(), 3);
    }

    @Test
    void testFindById() {

        Optional<User> userOptional = userStorage.findById(1);

        if (userOptional.isPresent()) {
            Assertions.assertEquals(userOptional.get().getPassword(),"1111");
        }
        else {
            Assertions.fail();
        }
    }
}