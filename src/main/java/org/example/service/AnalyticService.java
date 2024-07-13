package org.example.service;

import org.example.model.Problem;
import org.example.model.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticService {
    Map<Integer, List<Integer>> problemMetaData = new HashMap<Integer, List<Integer>>();

    public void solveProblem(int userId, int problemId, int timeTaken) {
        List<Integer>arrayList = problemMetaData
                .getOrDefault(userId, new ArrayList<Integer>());
        arrayList.add(timeTaken);
        problemMetaData.put(userId, arrayList);
    }

    public int getAverageSolveTime(int problemId){
        int totalTime = 0;
        for(int time: problemMetaData.getOrDefault(problemId, new ArrayList<>())){
            totalTime+= time;
        }

        return totalTime / Math.max(1, problemMetaData.size());
    }

    public void getTopProblems(int n, String order) {
        List<List<Integer>> problemList = problemMetaData.values().stream().toList();

    }
}
