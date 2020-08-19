package com.baylab.project.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SolvedProblem> solvedList;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private Set<Account> accounts;

    @Builder
    public User(final Long userId) {
        this.id = userId;
    }
}
