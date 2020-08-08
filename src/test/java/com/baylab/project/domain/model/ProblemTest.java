package com.baylab.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {

    @Test
    void testProblemBuilder() {
        Problem problem = Problem.builder().number(16653L)
                                            .name("녹색 옷을 입은 애가 젤다지?")
                                           .build();

        Assertions.assertEquals(problem.getNumber(),16653L);
        Assertions.assertEquals(problem.getName(),"녹색 옷을 입은 애가 젤다지?");
    }
}