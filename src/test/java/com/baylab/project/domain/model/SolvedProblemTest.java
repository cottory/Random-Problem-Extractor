package com.baylab.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SolvedProblemTest {

    @Test
    void testSolvedProblemBuilder() {
        SolvedProblem solvedProblem = SolvedProblem.builder()
                                                    .userId(1)
                                                    .problemId(13913L)
                                                    .build();

        Assertions.assertEquals(solvedProblem.getProblemId(), 13913L);
        Assertions.assertEquals(solvedProblem.getUserId(), 1);
    }
}