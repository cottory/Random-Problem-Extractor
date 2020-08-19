package com.baylab.project.domain.service;

import com.baylab.project.domain.model.SolvedProblem;
import com.baylab.project.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.annotation.Resource;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserStorageTest {

    @Resource
    private UserStorage userStorage;

    @Test
    void findByIdTest() {
        Optional<User> user = userStorage.findById(1447910803L);
        Assertions.assertEquals(user.get().getId(),1447910803L);
    }

    @Test
    void getUserSolvedListTest() {
        Optional<User> user = userStorage.findById(1447910803L);

        Set<SolvedProblem> solvedProblemSet = user.get().getSolvedList();

        for (SolvedProblem sp : solvedProblemSet)
        {
            log.info(sp.getUser() + ", "  + sp.getProblem());
        }
        
//        Assertions.assertEquals(solvedProblemSet.size(), 3);
    }


}