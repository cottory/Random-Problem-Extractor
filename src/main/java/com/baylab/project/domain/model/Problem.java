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
@Table(name = "problem")
public class Problem {

    @Id
    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public Problem(final Long number, final String name) {
        this.number = number;
        this.name = name;
    }
}
