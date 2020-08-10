package com.baylab.project.domain.common;

import com.baylab.project.domain.model.Problem;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContainerParser {
    public static HashMap<Problem, Boolean> list2HashMap(final List<Problem> problems)
    {
        HashMap<Problem, Boolean> newContainer = new HashMap<>();
        for (Problem problem : problems)
        {
            newContainer.put(problem,false);
        }
        return newContainer;
    }
}
