package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ProblemDto;
import org.example.model.Filter;
import org.example.model.Problem;
import org.example.repository.ProblemRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ProblemService {
    private ProblemRepository problemRepository;
    private AnalyticService analyticService;
    private FilterService filterService;

    public int addProblem(ProblemDto problem) {
        return this.problemRepository.addProblem(problem);
    }

    public void solveProblem(int userId, int problemId, String solution, int timeTaken) {
        Problem problem = problemRepository.getProblemWithId(problemId);
        if(problem == null){
            System.out.println("Problem not exists");
            return;
        }
        //validate solution
        //...

        problemRepository.solveProblem(userId, problemId);
        analyticService.solveProblem(userId, problemId, timeTaken);
    }

    public List<Problem> filterProblems(List<Filter> filters) {
        if(filters==null){
            filters = new ArrayList<Filter>();
        }
        List<Problem> problemList = this.problemRepository.getAllProblems();
        return this.filterService.filterBy(problemList, filters);
    }
}
