package org.example.service.strategy;

import org.example.model.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterByDifficulty extends FilterStrategy {
    public FilterByDifficulty(String attribute) {
        try{

            //validations on difficulty if needed
        } catch (Exception ex){
            //
        }
        this.attribute = attribute;
    }

    @Override
    public List<Problem> filter(List<Problem> problems) {
        List<Problem> filteredProblem = new ArrayList<Problem>();
        return problems.stream().filter(p-> Objects.equals(p.getDifficulty().toString(), attribute)).collect(Collectors.toList());
    }
}
