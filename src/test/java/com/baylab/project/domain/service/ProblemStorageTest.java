package com.baylab.project.domain.service;

import com.baylab.project.domain.model.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProblemStorageTest {

    @Autowired
    ProblemStorage problemStorage;

    @Test
    void testFindByAll() {
        List<Problem> arrayList = problemStorage.findAll();
        Assertions.assertEquals(arrayList.size(), 5);

        for (Problem p : arrayList) {
            System.out.println(p.getNumber() + ": " + p.getName());
        }
    }

    @Test
    void testFindByNumber() {
        Problem problem = problemStorage.findByNumber(17135L);
        Assertions.assertEquals(problem.getName(), "캐슬 디펜스");
    }

    @Test
    void testFindByName() {
        Problem problem = problemStorage.findByName("연산자 끼워넣기");
        Assertions.assertEquals(problem.getNumber(), 14888);
    }

}