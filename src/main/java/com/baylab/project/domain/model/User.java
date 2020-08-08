package com.baylab.project.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "id")
    private List<SolvedProblem> solvedList;

    @Builder
    public User(final Integer id, final String password) {
        this.id = id;
        this.password = password;
    }
}
