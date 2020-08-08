package com.baylab.project.domain.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@ToString
@Table(name = "solved_problem")
public class SolvedProblem {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "problem_id", nullable = false)
    private Long problemId;

    @Builder
    public SolvedProblem(final Integer userId, final Long problemId) {
        this.userId = userId;
        this.problemId = problemId;
    }
}
