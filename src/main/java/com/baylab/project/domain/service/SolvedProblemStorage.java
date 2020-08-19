package com.baylab.project.domain.service;

import com.baylab.project.domain.model.Problem;
import com.baylab.project.domain.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SolvedProblemStorage {
    CompletableFuture<Boolean> saveSolvedProblem(User user, Problem problem);
    List<Problem> getSolvedProblemsByUserId(User user);
}
