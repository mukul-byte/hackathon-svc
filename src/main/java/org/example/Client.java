package org.example;

import org.example.dto.ProblemDto;
import org.example.model.*;
import org.example.repository.ProblemRepository;
import org.example.repository.UserRepository;
import org.example.service.*;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {

        HackathonService hackathonService = getHackathonService();

        int user1 = hackathonService.registerUser("Mukul", "CSE");
        int user2 = hackathonService.registerUser("Rahul", "MCE");
        int problem1 = hackathonService.addProblem(new ProblemDto(new ArrayList<>(), "Add 1 and 2", Difficulty.EASY, 10));
        int problem2 = hackathonService.addProblem(new ProblemDto(new ArrayList<>(), "Add 11 and 21", Difficulty.MEDIUM, 15));
        int problem3 = hackathonService.addProblem(new ProblemDto(new ArrayList<>(), "Add 10 and 20", Difficulty.MEDIUM, 10));

        hackathonService.solveProblem(user1, problem1, "1+2=3", 10);
        hackathonService.solveProblem(user2, problem1, "1+2=3", 12);

        System.out.println("Average time to solve problem "+ problem1 + " : " + hackathonService.getAverageSolveTime(problem1));

        List<Problem> problemList = hackathonService.filterProblems(null);
        System.out.println("ALl problems: " + problemList);

        List<Problem> problemList2 = hackathonService.filterProblems(List.of(new Filter(FilterName.SCORE, "10")));
        System.out.println("ALl problems filtered by score: " + problemList2);

        List<Problem> problemList3 = hackathonService.filterProblems(List.of(new Filter(FilterName.DIFFICULTY, Difficulty.MEDIUM.toString())));
        System.out.println("ALl problems filtered by difficulty: " + problemList3);


        List<Problem> problemList4 = hackathonService.filterProblems(List.of(new Filter(FilterName.DIFFICULTY, Difficulty.MEDIUM.toString()),
                new Filter(FilterName.SCORE, "10")));
        System.out.println("ALl problems filtered by difficulty and score: " + problemList4);

        List<User> userList = hackathonService.getTopProblems(10, new Tag("Arrays"));
    }

    private static HackathonService getHackathonService() {
        ProblemRepository problemRepository = new ProblemRepository();
        UserRepository userRepository = new UserRepository();
        AnalyticService analyticService = new AnalyticService();
        FilterService filterService = new FilterService();
        ProblemService problemService = new ProblemService(problemRepository, analyticService, filterService);
        UserService userService = new UserService(userRepository);

        return new HackathonService(
                problemService, userService, analyticService);
    }
}