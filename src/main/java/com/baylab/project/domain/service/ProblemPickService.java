package com.baylab.project.domain.service;

import com.baylab.project.domain.common.ContainerParser;
import com.baylab.project.domain.model.Problem;
import com.baylab.project.domain.model.User;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProblemPickService {

    //ProblemStorage
    @Resource
    ProblemStorage problemStorage;

    //UserStorage
    @Resource
    UserStorage userStorage;

    @Resource
    StorageService storageService;

    public List<Problem> pickRandomProblems(User user, final int pickNumber)
    {
        List<Problem> candidateProblems = getCandidateProblems(user.getId());
        return pickProblemsFromCandidate(candidateProblems, pickNumber, candidateProblems.size());
    }

    public List<Problem> getCandidateProblems(Integer user_id)
    {
        List<Problem> candidateProblems = new ArrayList<>();

        List<Problem> problems = problemStorage.findAll();
        HashMap<Problem,Boolean> problemsHash = ContainerParser.list2HashMap(problems);

        //This is Dummy List, It is user's solved Problem List.
        List<Problem> solvedProblems = problemStorage.findAll();

        for (Problem problem : solvedProblems)
        {
            problemsHash.replace(problem, false, true);
        }

        for (Problem problem : problemsHash.keySet())
        {
            if (problemsHash.get(problem) == false)
            {
                candidateProblems.add(problem);
            }
        }

        return candidateProblems;
    }

    public List<Problem> pickProblemsFromCandidate(final List<Problem> candidateProblems, final int pickNumber, final int upperBound)
    {
        LinkedList<Problem> selectedProblems = new LinkedList<Problem>();
        Boolean[] usedNumber = new Boolean[upperBound];

        int pickCount = 0;
        while (pickCount != pickNumber)
        {
            int number = generateRandomNumber(upperBound);
            if (usedNumber[number] == true)
            {
                continue;
            }
            else
            {
                usedNumber[number] = true;
                pickCount += 1;
                selectedProblems.add(candidateProblems.get(number));
            }
        }

        return selectedProblems;
    }

    public int generateRandomNumber(final int upperBound)
    {
        int randomNumber;
        double seedNumber = Math.random();
        randomNumber = (int)(seedNumber * upperBound);
        return randomNumber;
    }

}
