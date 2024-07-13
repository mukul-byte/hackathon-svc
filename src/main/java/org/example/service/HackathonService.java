package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ProblemDto;
import org.example.model.Filter;
import org.example.model.Problem;

import java.util.List;

@AllArgsConstructor
public class HackathonService {
    private ProblemService problemService;
    private UserService userService;
    private AnalyticService analyticService;

    public int registerUser(String name, String departmentName){
        return this.userService.addUser(name, departmentName);
    }

    public int addProblem(ProblemDto problem){
        return this.problemService.addProblem(problem);
    }

    public void solveProblem(int userId, int problemId, String solution, int timeTaken) {
        //validate user by id
        if(this.userService.getUserById(userId)==null){
            System.out.println("User not exists with User id "+ userId);
            return;
        }
        this.problemService.solveProblem(userId, problemId, solution, timeTaken);
    }

    public int getAverageSolveTime(int problemId){
        return this.analyticService.getAverageSolveTime(problemId);
    }

    public List<Problem> filterProblems(List<Filter> filters){
        return this.problemService.filterProblems(filters);
    }

}
