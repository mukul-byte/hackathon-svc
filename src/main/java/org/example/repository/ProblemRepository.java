package org.example.repository;

import lombok.NoArgsConstructor;
import org.example.dto.ProblemDto;
import org.example.model.Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class ProblemRepository {
    Map<Integer, Problem> problemMap = new HashMap<Integer, Problem>();
    Integer counter=0;

    public int addProblem(ProblemDto problem) {
        counter++;
        problemMap.put(counter, new Problem(counter, problem));
        return counter;
    }

    public Problem getProblemWithId(int problemId) {
        return this.problemMap.getOrDefault(problemId, null);
    }

    public void solveProblem(int userId, int problemId) {
        problemMap.get(problemId).getUsersSolved().add(userId);
    }

    public List<Problem> getAllProblems() {
        return problemMap.values().stream().toList();
    }
}
