package com.baylab.project.domain.service;

import com.baylab.project.domain.model.Problem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProblemStorage extends JpaRepository<Problem,Long> {

    @Query("select u from Problem u where u.name = ?1")
    Problem findByName(final String name);

    @Query("select u from Problem u where u.number = ?1")
    Problem findByNumber(final long number);
}
