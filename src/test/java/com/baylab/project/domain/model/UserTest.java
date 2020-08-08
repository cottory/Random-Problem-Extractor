package com.baylab.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testUserBuilder() {
        User user = User.builder().id(12345)
                                  .build();

        Assertions.assertEquals(user.getId(), 12345);
    }
}