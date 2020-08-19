package com.baylab.project.domain.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "solved_problem")
public class SolvedProblem {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "emp_id", nullable = false)
//    private Employee employee;

    @Builder
    public SolvedProblem(final User user, final Problem problem) {
        this.user = user;
        this.problem = problem;
    }
}
