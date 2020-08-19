package com.baylab.project.domain.service.impl;

import com.baylab.project.domain.model.Problem;
import com.baylab.project.domain.model.User;
import com.baylab.project.domain.service.SolvedProblemStorage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DualSolvedProblemStorageImpl implements SolvedProblemStorage {

    @Override
    public CompletableFuture<Boolean> saveSolvedProblem(User user, Problem problem) {
        return null;
    }

    @Override
    public List<Problem> getSolvedProblemsByUserId(User user) {
        return null;
    }
}
